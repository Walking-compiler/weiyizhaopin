package org.glimmer.service.Impl;

import io.jsonwebtoken.Claims;
import org.apache.commons.io.FilenameUtils;
import org.glimmer.domain.LoginUser;
import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.UserInfo;
import org.glimmer.mapper.UserInfoMapper;
import org.glimmer.request.PostResume;
import org.glimmer.service.UploadResumeService;
import org.glimmer.utils.JwtUtil;
import org.glimmer.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UploadResumeServiceImpl implements UploadResumeService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    PostResume postResume;
    public static final String RESUME_FILE_PATH = "\\resumeFilePath\\";
    private static final String URL_SERVER = "http://localhost:8080";

    //允许上传的文件类型
    private static final String[] ALLOWED_FILE_TYPE = new String[]{"pdf", "doc","docx" };

    @Override
    public ResponseResult<HashMap<String, String>> uploadResume(HttpServletRequest request, MultipartFile file) {
        String token = request.getHeader("token");
        String webAppFolder = request.getServletContext().getRealPath("/");
        String fileName = file.getOriginalFilename();
        if (isAllow(fileName)) {
            String ext = FilenameUtils.getExtension(fileName).toLowerCase();
            String newFileName = UUID.randomUUID().toString().replace("-", "");
            // 自动创建上传目录
            String targetPath = FilenameUtils.normalize(webAppFolder + "\\" + RESUME_FILE_PATH);
            String targetFile = FilenameUtils.normalize(targetPath + "\\" + newFileName + "." + ext);
            new File(targetPath).mkdirs();
            try {
                //根据token查找用户Id
                String userid;
                Claims claims = JwtUtil.parseJWT(token);
                userid = claims.getSubject();
//                String redisKey = "login:"+userid;
//                LoginUser loginUser = redisCache.getCacheObject(redisKey);
                //将之前存储的简历文件删除
                UserInfo userInfo = userInfoMapper.selectByUserID(Long.parseLong(userid));
                String oldResumeFilePath = userInfo.getResumeFilePath();
                if (oldResumeFilePath != null) {
                    String oldResumeFileName = oldResumeFilePath.substring(oldResumeFilePath.lastIndexOf("/") + 1);
                    String oldResumeFile = FilenameUtils.normalize(webAppFolder + "\\" + RESUME_FILE_PATH + oldResumeFileName);
                    File oldFile = new File(oldResumeFile);
                    if (oldFile.exists()) {
                        oldFile.delete();
                    }
                }

                String urlPath = URL_SERVER +   RESUME_FILE_PATH  + newFileName + "." + ext;
                file.transferTo(new File(targetFile));

                ResponseResult  result = postResume.postResume(userid, targetFile);//向flask接口发送简历文件

                if(result.getCode() != 200){
                    return new ResponseResult<>(4002, "上传失败");
                }
                //更新数据库中的简历文件路径
                userInfoMapper.updateResumeFilePathByUserID(Long.parseLong(userid), urlPath);

                return new ResponseResult<>(200, "上传成功", new HashMap<String, String>() {{
                    put("url", urlPath);
                }});
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseResult<>(4002, "上传失败");
            }

        } else {

            return new ResponseResult<>(4002, "文件类型不允许");
        }
    }

    public boolean isAllow(String fileName) {

        String ext = FilenameUtils.getExtension(fileName).toLowerCase();
        for (String allowExtension : ALLOWED_FILE_TYPE) {

            if (allowExtension.toLowerCase().equals(ext)) {

                return true;
            }
        }
        return false;
    }

}

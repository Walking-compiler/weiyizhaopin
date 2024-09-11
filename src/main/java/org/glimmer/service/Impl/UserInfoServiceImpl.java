package org.glimmer.service.Impl;

import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.User;
import org.glimmer.domain.UserInfo;
import org.glimmer.grpc.client.Service.Impl.DifferenceServiceClient;
import org.glimmer.grpc.client.Service.Impl.JobRecommendServiceClient;
import org.glimmer.mapper.CompanyMapper;
import org.glimmer.mapper.JobMapper;
import org.glimmer.mapper.UserInfoMapper;
import org.glimmer.mapper.UserMapper;
import org.glimmer.service.UserInfoService;
import org.glimmer.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.Exceptions;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private DifferenceServiceClient differenceServiceClient;
    @Autowired
    CompanyMapper   companyMapper;
    @Autowired
    JobMapper jobMapper;
    @Autowired
    JobRecommendServiceClient jobRecommendServiceClient;

    @Override
    public void setUserInfo(Long userID, String skills, String projects, String internshipExperience, String desiredPosition, String education, String workExperience, String desiredSalary, String locationPreference, String certification, String professionalSummary, String linkedinProfile,
                             String educationExperience, String phone, String email,String sex,String name,String birthday)
    throws Exception {
        //存储用户的简历信息
        try{
            userInfoMapper.updateUserInfo(userID, skills, projects, internshipExperience, desiredPosition, education, workExperience, desiredSalary, locationPreference, certification, professionalSummary, linkedinProfile,
                    educationExperience,phone,email,sex,name,birthday);

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public UserInfo getUserInfo(Long userID) {
        return userInfoMapper.selectByUserID(userID);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) throws Exception {
        try{
            setUserInfo(userInfo.getUserID(), userInfo.getSkills(), userInfo.getProjects(), userInfo.getInternshipExperience(), userInfo.getDesiredPosition(), userInfo.getEducation(), userInfo.getWorkExperience(), userInfo.getDesiredSalary(), userInfo.getLocationPreference(), userInfo.getCertification(), userInfo.getProfessionalSummary(), userInfo.getLinkedinProfile(),
                    userInfo.getEducationExperience(),userInfo.getPhone(),userInfo.getEmail(),userInfo.getSex(),userInfo.getName(),userInfo.getBirthday());

        }catch (Exception e){
            throw e;
        }
        return 1;
    }
    @Override
    public String getResumeFilePath(Long userID) {
        return userInfoMapper.selectResumeFilePathByUserID(userID);
    }

    @Override
    public User getUserContact(Long userID) {
        return userMapper.selectUserContact(userID);
    }

    @Override
    public ResponseResult saveResumeFromRedisToDB(Long userId){
        UserInfo userInfo1 = (UserInfo)redisCache.getCacheObject("user_info:" + userId.toString());
        if(userInfo1 == null){
            return new ResponseResult(400, "保存出错");
        }
        UserInfo userInfo2 = userInfoMapper.selectByUserID(userId);
        if(userInfo2 == null){
            userInfoMapper.insert(userInfo1);
        }else{
            userInfoMapper.updateUserInfo(userId, userInfo1.getSkills(), userInfo1.getProjects(), userInfo1.getInternshipExperience(), userInfo1.getDesiredPosition(), userInfo1.getEducation(), userInfo1.getWorkExperience(), userInfo1.getDesiredSalary(), userInfo1.getLocationPreference(), userInfo1.getCertification(), userInfo1.getProfessionalSummary(), userInfo1.getLinkedinProfile(),
                    userInfo1.getEducationExperience(),userInfo1.getPhone(),userInfo1.getEmail(),userInfo1.getSex(),userInfo1.getName(),userInfo1.getBirthday());
        }
        return new ResponseResult(200, "用户信息保存成功");
    }

    @Override
    public ResponseResult modifyUserInfoInRedis(UserInfo userInfo) {
        redisCache.setCacheObject("user_info:" + userInfo.getUserID().toString(), userInfo);
        return new ResponseResult(200, "用户信息修改成功");
    }

    @Override
    public ResponseResult getDifference(Long userId,Long companyId,Long job){
        String jobName = jobMapper.selectJobName(job);
        String companyName = companyMapper.selectCompanyName(companyId);
        ResponseResult  result =  differenceServiceClient.requestDifference(userId,companyName,jobName);
        if (result.getCode() == 200){
            return new ResponseResult(200, "获取成功", result.getData());
        }else{
            return new ResponseResult(4005, "获取失败", null);
        }
    }

    @Override
    public ResponseResult getRecommend(Long userId){
        ResponseResult result = jobRecommendServiceClient.requestRecommend(userId);
        if (result.getCode() == 200){
            List<Job> resultJobs =  new ArrayList<>();
            List<Job> jobs = (List<Job>) result.getData();
            for(Job job : jobs){
                String jobName = job.getJobName();
                 List<Job> jobs1 =  jobMapper.searchJobByName(jobName);
                 for(Job job2 : jobs1){
                     resultJobs.add(job2);
                 }
            }
            return new ResponseResult(200, "获取成功", resultJobs);
        }else{
            return new ResponseResult(4005, "获取失败", null);
        }
    }

    @Override
    public  ResponseResult getEmployeeRecommend(Job job){
        List<UserInfo> userInfos = userInfoMapper.selectAllUserinfo();


        return new ResponseResult<>(200,"success",userInfos);
    }
}

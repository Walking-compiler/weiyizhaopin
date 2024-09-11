package org.glimmer.service;

import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.User;
import org.glimmer.domain.UserInfo;

public interface UserInfoService {

    /**
     * 设置用户简历信息
     */
    void setUserInfo(Long userID, String skills, String projects, String internshipExperience, String desiredPosition, String education, String workExperience, String desiredSalary, String locationPreference, String certification, String professionalSummary, String linkedinProfile,
                     String educationExperience,String phone,String email,String sex,String name,String birthday)throws Exception;

    /**
     * 获取用户简历信息
     */
    UserInfo getUserInfo(Long userID);
    /**
     * 修改用户简历信息
     */
    int updateUserInfo(UserInfo userInfo) throws  Exception;

    /**
     * 根据用户id返回用户简历文件路径
     */
    String getResumeFilePath(Long userID);
    /**
     * 获取用户邮箱、电话、用户名
     * 获取用户联系方式
     */
    User getUserContact(Long userID);

    /**
     * 将提取出来的简历信息从redis保存到数据库
     * @param userId
     * @return
     */
    ResponseResult saveResumeFromRedisToDB(Long userId  );

    ResponseResult modifyUserInfoInRedis(UserInfo userInfo);
    public ResponseResult getDifference(Long userId,Long companyId,Long job);

    public ResponseResult getRecommend(Long userId);

    public  ResponseResult getEmployeeRecommend(Job job);

}

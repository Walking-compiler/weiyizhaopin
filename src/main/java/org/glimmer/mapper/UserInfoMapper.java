package org.glimmer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.glimmer.domain.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select * from sys_user_info where id = #{ID}")
    UserInfo selectByID(Long ID);

    /**
     * 根据用户ID查询用户信息
     * @param userID
     * @return
     */
    @Select("select * from sys_user_info where user_id = #{userID}")
    UserInfo selectByUserID(Long userID);
    /**
     * 根据用户ID查询简历文件路径
     *
     */
    @Select("select sys_user_info from sys_job_search where user_id = #{userID}")
    String selectResumeFilePathByUserID(Long userID);
    /**
     * 根据用户id修改用户的简历路径
     *
     */
    @Update("update sys_user_info set resume_file_path = #{resumeFilePath} where user_id = #{userID}")
    int updateResumeFilePathByUserID(Long userID, String resumeFilePath);

    @Update("update sys_user_info set skills = #{skills}," +
            " projects = #{projects}," +
            " internship_experience = #{internshipExperience}," +
            " desired_position = #{desiredPosition}," +
            " education = #{education}," +
            " work_experience = #{workExperience}," +
            " desired_salary = #{desiredSalary}," +
            " location_preference = #{locationPreference}," +
            " certifications = #{certification}," +
            " professional_summary = #{professionalSummary}," +
            " linkedin_profile = #{linkedinProfile} ," +
            "education_experience = #{educationExperience},"+
            "phone = #{phone}," +
            "email = #{email}, " +
            "sex = #{sex},"+
            "name = #{name},"+
            "birthday = #{birthday}"+
            "where user_id = #{userID}")
    int updateUserInfo(Long userID, String skills, String projects, String internshipExperience, String desiredPosition, String education, String workExperience, String desiredSalary, String locationPreference, String certification, String professionalSummary, String linkedinProfile,
                       String educationExperience,String phone,String email,String sex,String name,String birthday);


    @Select("select * from sys_user_info")
    List<UserInfo> selectAllUserinfo();

}

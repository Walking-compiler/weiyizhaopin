package org.glimmer.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import com.glimmer.protobuf.grpcServiceProto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_job_search")
/**
 * 关联sys_user_info表
 */
public class UserInfo  {
    /**
     * 主键
     */
    int id;
    /**
     *
     * 用户ID
     */
    Long userID;
    /**
     * 技能
     */
    String skills;
    /**
     * 项目经验
     */
    String projects;
    /**
     * 实习经历
     */
    String internshipExperience;
    /**
     * 期望职位
     */

    String desiredPosition;
    /**
     * 教育经历
     */

    String education;
    /**
     * 工作经验
     */

    String workExperience;
    /**
     * 期望薪资
     */

    String desiredSalary;
    /**
     * 期望工作地点
     */
    String locationPreference;
    /**
     * 存储用户的证书或资格认证
     */

    String certification;
    /**
     * 专业技能
     */

    String professionalSummary;
    /**
     * 个人博客
     */
    String LinkedinProfile;
    /**
     * 简历路径
     */
    String resumeFilePath;
    /**
     * 教育经历
     */

    String educationExperience;

    /**
     *
     * email
     */
    String email;

    /**
     * phone
     * @param userInfo1
     */
    String phone;

    String sex;

    String birthday;

    String name;



    public UserInfo(grpcServiceProto.UserInfo userInfo1){
        this.userID = userInfo1.getUserId();
        this.skills = userInfo1.getSkills();
        this.projects = userInfo1.getProjects();
        this.internshipExperience = userInfo1.getInternshipExperience();
        this.desiredPosition = userInfo1.getDesiredPosition();
        this.education = userInfo1.getEducation();
        this.workExperience = userInfo1.getWorkExperience();
        this.desiredSalary = userInfo1.getDesiredSalary();
        this.locationPreference = userInfo1.getLocationPreference();
        this.certification = userInfo1.getCertificate();
        this.professionalSummary = userInfo1.getProfessionalSummary();
        this.LinkedinProfile = userInfo1.getLinkedinProfile();
        this.educationExperience = userInfo1.getEducationExperience();
        this.phone = userInfo1.getPhone();
        this.email = userInfo1.getEmail();
        this.birthday = userInfo1.getBirthday();
        this.sex = userInfo1.getSex();
        this.name = userInfo1.getName();
    }
}

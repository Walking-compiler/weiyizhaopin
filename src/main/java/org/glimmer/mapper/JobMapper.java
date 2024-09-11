package org.glimmer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.util.Pair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.glimmer.domain.Company;
import org.glimmer.domain.Job;

import java.util.List;

@Mapper
public interface JobMapper extends BaseMapper<Job> {
    @Select("SELECT c.* FROM sys_company c JOIN sys_job j ON c.companyId = j.companyId WHERE j.jobId = #{jobId}")
    Company getCompanyByJobId(@Param("jobId") Long jobId);
    @Select("SELECT * FROM sys_job WHERE companyId = #{companyId}")
    List<Job> getJobsByCompanyId(@Param("companyId") Long companyId);

    /**
     * 根据职位ID查询职位信息
     */
    @Select("SELECT * FROM sys_job WHERE jobId = #{jobId}")
    Job getJobInfoByJobID(@Param("jobId") Long jobId);


    //使用注解方式实现动态sql
    @Select("<script>" +
            "SELECT * FROM sys_job WHERE 1 = 1 " +
            "<if test='jobTypes != null and jobTypes.size() > 0'> " +
            "AND (" +
            "<foreach item='jobType' collection='jobTypes' separator=' OR '> " +
            "jobType LIKE CONCAT('%', #{jobType}, '%') " +
            "</foreach>" +
            ")"+
            "</if>" +
            "<if test='location != null'> " +
            "AND jobCity = #{location} " +
            "</if>" +
            "<if test='salaryRange != null'> " +
            "AND ((jobSalaryMin <![CDATA[<=]]> #{salaryRange.value} AND jobSalaryMax <![CDATA[>=]]> #{salaryRange.value} ) " +
            "OR (jobSalaryMax <![CDATA[>=]]> #{salaryRange.key} AND jobSalaryMin <![CDATA[<=]]> #{salaryRange.key})) " +
            "</if>" +
            "<if test='education != null and education.size() > 0'> " +
            "AND jobEducation IN " +
            "<foreach item='edu' collection='education' open='(' separator=',' close=')'> " +
            "#{edu}" +
            "</foreach>" +
            "</if>" +
            "<if test='experience != null'> " +
            "AND ((jobExperienceMin <![CDATA[<=]]> #{experience.value}) " +
            "OR (jobExperienceMax <![CDATA[>=]]> #{experience.key} )) " +
            "</if>" +
            "<if test='jobIndustry != null'> " +
            "AND jobIndustry LIKE #{jobIndustry} " +
            "</if>" +
            "<if test='companySize != null'> " +
            "AND companyId IN (SELECT companyId FROM sys_company WHERE companySize <![CDATA[>=]]> #{companySize}) " +
            "</if>" +
            "</script>")
    List<Job> searchJobs(@Param("jobTypes") List<String> jobType,
                         @Param("location") String location,
                         @Param("salaryRange")Pair<Integer, Integer> salaryRange,
                         @Param("education") List<String> education,
                         @Param("experience") Pair<Integer,Integer> experience,
                         @Param("jobIndustry") String jobIndustry,
                         @Param("companySize") Integer companySize);

    @Update("UPDATE sys_job SET jobName = #{jobName}," +
            "jobType = #{jobType}," +
            "jobCity = #{jobCity}," +
            "jobDescription = #{jobDescription}," +
            "jobDeadline = #{jobDeadline}," +"" +
            "jobDepartment = #{jobDepartment}," +
            "jobCity = #{jobCity}," +
            "jobIndustry = #{jobIndustry}," +
            "jobEducation = #{jobEducation}," +
            "jobExperience = #{jobExperience}," +
            "jobSkill = #{jobSkill}," +
            "jobSalaryMin = #{jobSalaryMin}," +
            "jobSalaryMax = #{jobSalaryMax} ," +
            "jobExperienceMin = #{jobExperienceMin}," +
            "jobExperienceMax = #{jobExperienceMax} " +
            "WHERE jobId = #{jobId}")
    void updateJob(@Param("jobName") String jobName,
                   @Param("jobType") String jobType,
                   @Param("jobCity") String jobCity,
                   @Param("jobDescription") String jobDescription,
                   @Param("jobDeadline") String jobDeadline,
                   @Param("jobDepartment") String jobDepartment,
                   @Param("jobIndustry") String jobIndustry,
                   @Param("jobEducation") String jobEducation,
                   @Param("jobExperience") String jobExperience,
                   @Param("jobSkill") String jobSkill,
                   @Param("jobSalaryMin") String jobSalaryMin,
                   @Param("jobSalaryMax") String jobSalaryMax,
                   @Param("jobExperienceMin") String jobExperienceMin,
                   @Param("jobExperienceMax") String jobExperienceMax,
                   @Param("jobId") Long jobId);

    /**
     * 模糊查询职位
     */
    @Select("SELECT * FROM sys_job WHERE jobName LIKE CONCAT('%', #{jobName}, '%')")
    List<Job> searchJobByName(@Param("jobName") String jobName);
    /**
     * 根据职位类型模糊查询职位
     */
    @Select("SELECT * FROM sys_job WHERE jobType LIKE CONCAT('%', #{jobType}, '%')")
    List<Job> searchJobByType(@Param("jobType") String jobType);
    /**
     *根据id查询职位名称
     */
    @Select( "SELECT jobName FROM sys_job WHERE jobId = #{jobId}")
    String selectJobName(Long jobId);




}

package org.glimmer.domain;

import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.glimmer.protobuf.grpcServiceProto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glimmer.utils.LongJsonSerializer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_job")
public class Job {
    /**
     * 主键
     */
    @TableId(value = "jobId")

    private Long jobId;
    /**
     * 职位名称
     */
    @TableField("jobName")
    private String jobName;

    /**
     * 职位类型
     */
    @TableField("jobType")
    private String jobType;
    /**
     * 职位描述
     */
    @TableField("jobDescription")
    private String jobDescription;
    /**
     * 职位状态
     */
    @TableField("jobStatus")
    private int jobStatus;
    /**
     * 职位发布时间
     */
    @TableField("jobPublishTime")
    private String jobPublishTime;
    /**
     * 职位截止时间
     */
    @TableField("jobDeadline")
    private String jobDeadline;
    /**
     * 职位所属公司
     */
    @TableField("companyId")
    private Long companyId;
    /**
     * 职位所属部门
     */
    @TableField("jobDepartment")
    private String jobDepartment;
    /**
     * 职位所属城市
     */
    @TableField("jobCity")
    private String jobCity;
    /**
     * 职位所属行业
     */
    @TableField("jobIndustry")
    private String jobIndustry;
    /**
     * 职位所属学历
     */
    @TableField("jobEducation")
    private String jobEducation;
    /**
     * 职位所属工作经验
     */
    @TableField("jobExperience")
    private String jobExperience;
    /**
     * 职位所属薪资
     */
    @TableField("jobSalary")
    private String jobSalary;
    /**
     * 职位所属福利
     */
    @TableField("jobWelfare")
    private String jobWelfare;
    /**
     * 职位所属技能
     */
    @TableField("jobSkill")
    private String jobSkill;
    /**
     * 职位所属标签
     */
    @TableField("jobTag")
    private String jobTag;
    /**
     * 薪资最小值
     */
    @TableField("jobSalaryMin")
    private String jobSalaryMin;
    /**
     * 薪资最大值
     */
    @TableField("jobSalaryMax")
    private String jobSalaryMax;
    /**
     * 经验最小值
     */
    @TableField("jobExperienceMin")
    private String jobExperienceMin;
    /**
     * 经验最大值
     */
    @TableField("jobExperienceMax")
    private String jobExperienceMax;

    @TableField("user_set")
    private Long userSet;
    @TableField("click_count")
    private Long clickCount;


    public Job(grpcServiceProto.Job job) {
        this.jobId = job.getJobId();
        this.jobName = job.getJobName();
        this.jobType = job.getJobType();
        this.jobDescription = job.getJobDesc();
        this.companyId = job.getCompanyId();
        this.jobCity = job.getJobLocation();

        this.jobEducation = job.getJobEducation();
        this.jobExperience = job.getJobExperience();
        this.jobSalary = job.getJobSalary();

        this.jobSkill = job.getJobSkill();
        this.jobSalary = job.getJobSalary();

    }
}

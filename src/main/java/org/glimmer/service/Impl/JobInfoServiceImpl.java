package org.glimmer.service.Impl;

import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;
import org.glimmer.mapper.JobMapper;
import org.glimmer.service.JobInfoService;
import org.glimmer.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobInfoServiceImpl implements JobInfoService {
    @Autowired
    JobMapper jobMapper;
    @Autowired
    RedisCache redisCache;

    @Override
    public ResponseResult<Job> getJobInfoByJobID(Long jobID) {
        Job job = jobMapper.getJobInfoByJobID(jobID);
        if( job!= null){
            return new ResponseResult<Job>(200, "查询成功",job);
        }else {
            return new ResponseResult<>(4009,"查询失败");
        }
    }

    @Override
    public ResponseResult addAJob(Job job){
        if(job.getCompanyId()==null){
            return new ResponseResult<>(4008,"无公司信息");
        }
        jobMapper.insert(job);
        return new ResponseResult<>(200,"添加成功");
    }
    @Override
    public ResponseResult deleteJob(Long jobID){
        int res = jobMapper.deleteById(jobID);
        if(res==0){
            return new ResponseResult<>(4008,"删除失败");
        }
        return new ResponseResult<>(200,"删除成功");
    }

    @Override
    public ResponseResult updateJob(Job job){
        jobMapper.updateJob(job.getJobName(),
                job.getJobType(),
                job.getJobCity(),
                job.getJobDescription(),
                job.getJobDeadline(),
                job.getJobDepartment(),
                job.getJobIndustry(),
                job.getJobEducation(),
                job.getJobExperience(),
                job.getJobSkill(),
                job.getJobSalaryMin(),
                job.getJobSalaryMax(),
                job.getJobExperienceMin(),
                job.getJobExperienceMax(),
                job.getJobId()
        );
        return new ResponseResult<>(200,"更新成功");
    }

}

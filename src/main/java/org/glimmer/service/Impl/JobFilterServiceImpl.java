package org.glimmer.service.Impl;

import javafx.util.Pair;
import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;
import org.glimmer.mapper.JobMapper;
import org.glimmer.service.JobFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobFilterServiceImpl implements JobFilterService {
    @Autowired
    JobMapper jobMapper;

    @Override
    public ResponseResult searchJobsByFilter(List<String> jobTypes, String jobCity, Pair<Integer, Integer> salaryRange, List<String> education, Pair<Integer, Integer> experience, String jobIndustry,Integer companySize   ) {
        List<Job> jobs = jobMapper.searchJobs(jobTypes, jobCity, salaryRange, education, experience, jobIndustry, companySize);
        return new ResponseResult<List<Job>>(200, "查询成功", jobs);
    }
}

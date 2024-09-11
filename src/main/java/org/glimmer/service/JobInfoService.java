package org.glimmer.service;

import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;

public interface JobInfoService {
    public ResponseResult getJobInfoByJobID(Long jobID);


    public ResponseResult addAJob(Job job);

    public ResponseResult deleteJob(Long jobID);

    public ResponseResult updateJob(Job job);



}

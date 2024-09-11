package org.glimmer.controller;

import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.UserInfo;
import org.glimmer.service.JobInfoService;
import org.glimmer.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobInfoController {
    @Autowired
    private JobInfoService jobInfoService;

    /**
     * 根据jobid请求jobinfo
     *
     */
    @GetMapping("/job/getinfo")
    @PreAuthorize("hasAuthority('system:job:info')")
    public ResponseResult getJobInfoByJobID(@RequestParam(name="jobID") Long jobID) {
        return jobInfoService.getJobInfoByJobID(jobID);
    }


    @PostMapping("/job/addjob")
    @PreAuthorize("hasAuthority('system:job:add')")
    public ResponseResult addAJob(@RequestBody Job job) {
        return jobInfoService.addAJob(job);
    }

    @PostMapping("/job/deletejob")
    @PreAuthorize("hasAuthority('system:job:delete')")
    public ResponseResult deleteJob(@RequestParam(name="jobID") Long jobID) {
        return jobInfoService.deleteJob(jobID);
    }

    @PostMapping("/job/updatejob")
    @PreAuthorize("hasAuthority('system:job:update')")
    public ResponseResult updateJob(@RequestBody Job job) {
        return jobInfoService.updateJob(job);
    }


}

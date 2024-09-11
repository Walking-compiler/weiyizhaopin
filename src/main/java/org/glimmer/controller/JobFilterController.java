package org.glimmer.controller;


import javafx.util.Pair;
import org.glimmer.domain.ResponseResult;
import org.glimmer.service.JobFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class JobFilterController  {
    @Autowired
    JobFilterService jobFilterService;
    @GetMapping("/job/filter")
    @PreAuthorize("hasAuthority('system:job:filter')")
    public ResponseResult searchJobsByFilter(@RequestParam(name="jobTypes",required = false) String jobTypesParam, @RequestParam(name = "jobCity",required = false) String jobCity,
                                             @RequestParam(name="salaryRange",required = false) String salaryRangeParam,
                                             @RequestParam(name="education",required = false) String educationParam,
                                             @RequestParam(name="experience",required = false) String experienceParam,
                                             @RequestParam(name="jobIndustry",required = false) String jobIndustry,
                                                @RequestParam(name="companySize",required = false) Integer companySize) {
        List<String> jobTypes = null;
        Pair<Integer,Integer> salaryRange = null;
        List<String> education = null;
        Pair<Integer,Integer> experience = null;

        if(jobTypesParam != null && !jobTypesParam.equals("")){
            jobTypes = Arrays.asList(jobTypesParam.split(","));
        }
        if(salaryRangeParam != null && !salaryRangeParam.equals("")){
             salaryRange = new Pair<>(Integer.parseInt(salaryRangeParam.split(",")[0]),Integer.parseInt(salaryRangeParam.split(",")[1]));
        }
        if(educationParam != null && !educationParam.equals("")){
             education = Arrays.asList(educationParam.split(","));
        }
        if(experienceParam != null && !experienceParam.equals("")){
            experience = new Pair<>(Integer.parseInt(experienceParam.split(",")[0]),Integer.parseInt(experienceParam.split(",")[1]));
        }
        return jobFilterService.searchJobsByFilter( jobTypes, jobCity, salaryRange, education, experience, jobIndustry,companySize);
    }
    //TODO company size
}

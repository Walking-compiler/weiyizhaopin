package org.glimmer.service;

import javafx.util.Pair;
import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;

import java.util.List;

public interface JobFilterService {
    public ResponseResult<List<Job>> searchJobsByFilter(List<String> jobTypes, String jobCity, Pair<Integer,Integer> salaryRange, List<String> education, Pair<Integer,Integer> experience, String jobIndustry,Integer companySize);
}

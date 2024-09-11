package org.glimmer.service;

import org.glimmer.domain.ResponseResult;

public interface AnalyzeResumeService {
    public ResponseResult analyzeResume(String userId, String resumePath);
}

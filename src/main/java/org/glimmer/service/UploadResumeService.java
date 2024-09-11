package org.glimmer.service;

import org.glimmer.domain.ResponseResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface UploadResumeService {
    public ResponseResult<HashMap<String,String>> uploadResume(HttpServletRequest request, MultipartFile file);



}

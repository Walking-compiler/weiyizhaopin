package org.glimmer.controller;

import org.glimmer.domain.ResponseResult;
import org.glimmer.service.UploadResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class UploadResumeController {
    @Autowired
    private UploadResumeService uploadResumeService;
    @PostMapping("/user/uploadResume")
    @PreAuthorize("hasAuthority('system:resume:upload')")
    public ResponseResult uploadResume(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        if(file !=null){
            return uploadResumeService.uploadResume(request, file);
        }
        return  new ResponseResult<>(4002,"failed");
    }
}

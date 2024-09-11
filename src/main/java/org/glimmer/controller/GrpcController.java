package org.glimmer.controller;

import org.glimmer.domain.ResponseResult;
import org.glimmer.grpc.client.Service.Impl.DifferenceServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcController {
    @Autowired
    DifferenceServiceClient differenceServiceClient;

    @GetMapping("/grpc")
    @PreAuthorize("hasAuthority('system:grpc')")
    public ResponseResult grpc() {
        String userId = "12132314";
        String resumePath = "path";
        String str = differenceServiceClient.requestDifference(null, resumePath,null).toString();
        System.out.println(str);
        return new ResponseResult(200, "success");
    }
}

package org.glimmer.grpc.client.Service.Impl;

import com.glimmer.protobuf.GrpcServiceGrpc;
import com.glimmer.protobuf.grpcServiceProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.glimmer.domain.ResponseResult;
import org.glimmer.domain.User;
import org.glimmer.domain.UserInfo;
import org.glimmer.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtractResumeClient {
    @Autowired
    RedisCache  redisCache;


    @GrpcClient("python-service")
    private GrpcServiceGrpc.GrpcServiceBlockingStub extractResumeServiceGrpc;

    public ResponseResult uploadExtractResult(String userId){
        grpcServiceProto.ExtractResumeRequest request = grpcServiceProto.ExtractResumeRequest.newBuilder()
                .setUserId(Long.parseLong(userId))
                .setCode(200)
                .setMessage("request recommend")
                .build();
        grpcServiceProto.ExtractResumeResponse response = extractResumeServiceGrpc.extractResume(request);
        System.out.println(response.getUserInfo());
        UserInfo userInfo1 = new UserInfo(response.getUserInfo());
        System.out.println(userInfo1);
        //TODO 保存用户信息到redis
        redisCache.setCacheObject("user_info:"+String.valueOf(response.getUserId()), userInfo1);
        return new ResponseResult(response.getCode(), response.getMessage(), userInfo1);
    }
}

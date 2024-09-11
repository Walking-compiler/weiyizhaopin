package org.glimmer.grpc.server.service;

import com.glimmer.protobuf.GrpcServiceGrpc;
import com.glimmer.protobuf.grpcServiceProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.glimmer.service.UserInfoService;
import org.glimmer.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ExtractResumeTest extends GrpcServiceGrpc.GrpcServiceImplBase{
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RedisCache redisCache;

    public static String USER_INFO_REDIS = "user_info";

    @Override
    public void extractResume(com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest request, io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse> responseObserver) {

        com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest req = request;
        int code = req.getCode();
        String message = req.getMessage();
        Long userId = req.getUserId();


        grpcServiceProto.UserInfo userInfo  = grpcServiceProto.UserInfo.newBuilder()
                .setUserId(userId)
                .setProjects("c++ thread pool")
                .build();
        grpcServiceProto.ExtractResumeResponse extractResumeResponse = grpcServiceProto.ExtractResumeResponse
                .newBuilder()
                .setCode(200)
                .setMessage("success")
                .setUserInfo(userInfo)
                .build();
//        //将userinfo存入redis
//        redisCache.setCacheObject(USER_INFO_REDIS+userId.toString(), userInfo1);
//
//        System.out.println("code: " + code+ " message: " + message );
//        com.glimmer.protobuf.ExtractedResume.ExtractResumeResponse extractResumeResponse = com.glimmer.protobuf.ExtractedResume.ExtractResumeResponse
//                .newBuilder()
//                .setCode(200)
//                .setMessage("success")
//                .build();
        responseObserver.onNext(extractResumeResponse);
        responseObserver.onCompleted();
    }
    @Override
    public void getRecommendJob(com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest request, io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse> responseObserver) {
        com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest req = request;
        int code = req.getCode();
        String message = req.getMessage();
        Long userId = req.getUserId();
        System.out.println("code: " + code+ " message: " + message + " userId: " + userId);
        com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse recommendJobResponse = com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse
                .newBuilder()
                .setCode(200)
                .setMessage("success")
                .setUserId(userId)
//                .addJob1(com.glimmer.protobuf.JobRecommend.Job.newBuilder().setJobId(1).setJobName("Java Developer").setJobDesc("Java Developer").setJobSalary("1000,2000").build())
                .build();
        responseObserver.onNext(recommendJobResponse);
        responseObserver.onCompleted();
    }
    @Override
    public void getDifference(grpcServiceProto.DifferenceRequest request, StreamObserver<grpcServiceProto.DifferenceResponse> responseObserver) {
        grpcServiceProto.DifferenceRequest req = request;
        int code = req.getCode();
        String message = req.getMessage();
        Long userId = req.getUserid();
        System.out.println("code: " + code+ " message: " + message + " userId: " + userId);
        grpcServiceProto.DifferenceResponse differenceResponse = grpcServiceProto.DifferenceResponse
                .newBuilder()
                .setCode(200)
                .setMessage("success")
                .setMessage("hello world")
                .setUserid(userId)
                .build();
        responseObserver.onNext(differenceResponse);
        responseObserver.onCompleted();

    }

}

//package org.glimmer.grpc.server.service;
//
//
//import net.devh.boot.grpc.server.service.GrpcService;
//
//@GrpcService
//public class JobRecommendTest extends JobRecommendServiceGrpc.JobRecommendServiceImplBase{
//    @Override
//    public void getRecommendJob(com.glimmer.protobuf.JobRecommend.GetRecommendJobRequest request, io.grpc.stub.StreamObserver<com.glimmer.protobuf.JobRecommend.GetRecommendJobResponse> responseObserver) {
//        com.glimmer.protobuf.JobRecommend.GetRecommendJobRequest req = request;
//        int code = req.getCode();
//        String message = req.getMessage();
//        Long userId = req.getUserId();
//        System.out.println("code: " + code+ " message: " + message + " userId: " + userId);
//        com.glimmer.protobuf.JobRecommend.GetRecommendJobResponse recommendJobResponse = com.glimmer.protobuf.JobRecommend.GetRecommendJobResponse
//                .newBuilder()
//                .setCode(200)
//                .setMessage("success")
//                .setUserId(userId)
////                .addJob1(com.glimmer.protobuf.JobRecommend.Job.newBuilder().setJobId(1).setJobName("Java Developer").setJobDesc("Java Developer").setJobSalary("1000,2000").build())
//                .build();
//        responseObserver.onNext(recommendJobResponse);
//        responseObserver.onCompleted();
//    }
//}

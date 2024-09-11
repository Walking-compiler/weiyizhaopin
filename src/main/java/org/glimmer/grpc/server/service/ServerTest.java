//package org.glimmer.grpc.server.service;
//
//import io.grpc.stub.StreamObserver;
//import net.devh.boot.grpc.server.service.GrpcService;
//
//@GrpcService
//public class ServerTest extends DifferenceServiceGrpc.DifferenceServiceImplBase {
//    @Override
//    public void getDifference(Difference.DifferenceRequest request, StreamObserver<Difference.DifferenceResponse> responseObserver) {
//        Difference.DifferenceRequest req = request;
//        int code = req.getCode();
//        String message = req.getMessage();
//        Long userId = req.getUserid();
//        System.out.println("code: " + code+ " message: " + message + " userId: " + userId);
//        Difference.DifferenceResponse differenceResponse = Difference.DifferenceResponse
//                .newBuilder()
//                .setCode(200)
//                .setMessage("success")
//                .setMessage("hello world")
//                .setUserid(userId)
//                .build();
//        responseObserver.onNext(differenceResponse);
//        responseObserver.onCompleted();
//
//    }
//}

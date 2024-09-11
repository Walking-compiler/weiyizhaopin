package org.glimmer.grpc.client.Service.Impl;

import com.glimmer.protobuf.GrpcServiceGrpc;
import com.glimmer.protobuf.grpcServiceProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.glimmer.domain.Job;
import org.glimmer.domain.ResponseResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobRecommendServiceClient {
    @GrpcClient("python-service")
    private GrpcServiceGrpc.GrpcServiceBlockingStub jobRecommendServiceGrpc;

    public ResponseResult requestRecommend(Long userId){
        grpcServiceProto.GetRecommendJobRequest request = grpcServiceProto.GetRecommendJobRequest.newBuilder()
                .setUserId(userId)
                .setCode(200)
                .setMessage("request recommend")
                .build();
        grpcServiceProto.GetRecommendJobResponse response = jobRecommendServiceGrpc.getRecommendJob(request);
        List<Job> jobs = new ArrayList<Job>();
        for(grpcServiceProto.Job job : response.getJobsList()){
            jobs.add(new Job(job));
        }
        return new ResponseResult(response.getCode(), response.getMessage(), jobs);
    }
}

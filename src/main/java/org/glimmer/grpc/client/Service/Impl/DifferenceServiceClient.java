package org.glimmer.grpc.client.Service.Impl;
import com.glimmer.protobuf.GrpcServiceGrpc;
import com.glimmer.protobuf.grpcServiceProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.glimmer.domain.ResponseResult;
import org.springframework.stereotype.Service;


@Service
public class DifferenceServiceClient {
    @GrpcClient("python-service")
    private GrpcServiceGrpc.GrpcServiceBlockingStub differenceServiceGrpc;

    public ResponseResult requestDifference(Long userId, String companyName,String jobName) {
        grpcServiceProto.JobAndCompany jobAndCompany = grpcServiceProto.JobAndCompany.newBuilder()
                .setCompanyName(companyName)
                .setJobName(jobName)
                .build();
        grpcServiceProto.DifferenceRequest request = grpcServiceProto.DifferenceRequest.newBuilder()
                .setMessage("request difference")
                .setUserid(userId)
                .setJobAndName(jobAndCompany)
                .build();
        grpcServiceProto.DifferenceResponse response = differenceServiceGrpc.getDifference(request);
        return new ResponseResult(response.getCode(), response.getMessage(), response.getData().toString());
    }

}

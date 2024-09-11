package com.glimmer.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: Demo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GrpcServiceGrpc {

  private GrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "GrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.glimmer.protobuf.grpcServiceProto.DifferenceRequest,
      com.glimmer.protobuf.grpcServiceProto.DifferenceResponse> getGetDifferenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getDifference",
      requestType = com.glimmer.protobuf.grpcServiceProto.DifferenceRequest.class,
      responseType = com.glimmer.protobuf.grpcServiceProto.DifferenceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.glimmer.protobuf.grpcServiceProto.DifferenceRequest,
      com.glimmer.protobuf.grpcServiceProto.DifferenceResponse> getGetDifferenceMethod() {
    io.grpc.MethodDescriptor<com.glimmer.protobuf.grpcServiceProto.DifferenceRequest, com.glimmer.protobuf.grpcServiceProto.DifferenceResponse> getGetDifferenceMethod;
    if ((getGetDifferenceMethod = GrpcServiceGrpc.getGetDifferenceMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getGetDifferenceMethod = GrpcServiceGrpc.getGetDifferenceMethod) == null) {
          GrpcServiceGrpc.getGetDifferenceMethod = getGetDifferenceMethod =
              io.grpc.MethodDescriptor.<com.glimmer.protobuf.grpcServiceProto.DifferenceRequest, com.glimmer.protobuf.grpcServiceProto.DifferenceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getDifference"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.glimmer.protobuf.grpcServiceProto.DifferenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.glimmer.protobuf.grpcServiceProto.DifferenceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("getDifference"))
              .build();
        }
      }
    }
    return getGetDifferenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest,
      com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse> getGetRecommendJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecommendJob",
      requestType = com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest.class,
      responseType = com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest,
      com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse> getGetRecommendJobMethod() {
    io.grpc.MethodDescriptor<com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest, com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse> getGetRecommendJobMethod;
    if ((getGetRecommendJobMethod = GrpcServiceGrpc.getGetRecommendJobMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getGetRecommendJobMethod = GrpcServiceGrpc.getGetRecommendJobMethod) == null) {
          GrpcServiceGrpc.getGetRecommendJobMethod = getGetRecommendJobMethod =
              io.grpc.MethodDescriptor.<com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest, com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecommendJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("GetRecommendJob"))
              .build();
        }
      }
    }
    return getGetRecommendJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest,
      com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse> getExtractResumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExtractResume",
      requestType = com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest.class,
      responseType = com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest,
      com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse> getExtractResumeMethod() {
    io.grpc.MethodDescriptor<com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest, com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse> getExtractResumeMethod;
    if ((getExtractResumeMethod = GrpcServiceGrpc.getExtractResumeMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getExtractResumeMethod = GrpcServiceGrpc.getExtractResumeMethod) == null) {
          GrpcServiceGrpc.getExtractResumeMethod = getExtractResumeMethod =
              io.grpc.MethodDescriptor.<com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest, com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExtractResume"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("ExtractResume"))
              .build();
        }
      }
    }
    return getExtractResumeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcServiceStub>() {
        @java.lang.Override
        public GrpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcServiceStub(channel, callOptions);
        }
      };
    return GrpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcServiceBlockingStub>() {
        @java.lang.Override
        public GrpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcServiceBlockingStub(channel, callOptions);
        }
      };
    return GrpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrpcServiceFutureStub>() {
        @java.lang.Override
        public GrpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrpcServiceFutureStub(channel, callOptions);
        }
      };
    return GrpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GrpcServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDifference(com.glimmer.protobuf.grpcServiceProto.DifferenceRequest request,
        io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.DifferenceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDifferenceMethod(), responseObserver);
    }

    /**
     */
    public void getRecommendJob(com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest request,
        io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRecommendJobMethod(), responseObserver);
    }

    /**
     */
    public void extractResume(com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest request,
        io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExtractResumeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDifferenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.glimmer.protobuf.grpcServiceProto.DifferenceRequest,
                com.glimmer.protobuf.grpcServiceProto.DifferenceResponse>(
                  this, METHODID_GET_DIFFERENCE)))
          .addMethod(
            getGetRecommendJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest,
                com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse>(
                  this, METHODID_GET_RECOMMEND_JOB)))
          .addMethod(
            getExtractResumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest,
                com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse>(
                  this, METHODID_EXTRACT_RESUME)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcServiceStub extends io.grpc.stub.AbstractAsyncStub<GrpcServiceStub> {
    private GrpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void getDifference(com.glimmer.protobuf.grpcServiceProto.DifferenceRequest request,
        io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.DifferenceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDifferenceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRecommendJob(com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest request,
        io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecommendJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void extractResume(com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest request,
        io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExtractResumeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GrpcServiceBlockingStub> {
    private GrpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.glimmer.protobuf.grpcServiceProto.DifferenceResponse getDifference(com.glimmer.protobuf.grpcServiceProto.DifferenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDifferenceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse getRecommendJob(com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecommendJobMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse extractResume(com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExtractResumeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GrpcServiceFutureStub> {
    private GrpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.glimmer.protobuf.grpcServiceProto.DifferenceResponse> getDifference(
        com.glimmer.protobuf.grpcServiceProto.DifferenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDifferenceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse> getRecommendJob(
        com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecommendJobMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse> extractResume(
        com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExtractResumeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DIFFERENCE = 0;
  private static final int METHODID_GET_RECOMMEND_JOB = 1;
  private static final int METHODID_EXTRACT_RESUME = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DIFFERENCE:
          serviceImpl.getDifference((com.glimmer.protobuf.grpcServiceProto.DifferenceRequest) request,
              (io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.DifferenceResponse>) responseObserver);
          break;
        case METHODID_GET_RECOMMEND_JOB:
          serviceImpl.getRecommendJob((com.glimmer.protobuf.grpcServiceProto.GetRecommendJobRequest) request,
              (io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.GetRecommendJobResponse>) responseObserver);
          break;
        case METHODID_EXTRACT_RESUME:
          serviceImpl.extractResume((com.glimmer.protobuf.grpcServiceProto.ExtractResumeRequest) request,
              (io.grpc.stub.StreamObserver<com.glimmer.protobuf.grpcServiceProto.ExtractResumeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.glimmer.protobuf.grpcServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcService");
    }
  }

  private static final class GrpcServiceFileDescriptorSupplier
      extends GrpcServiceBaseDescriptorSupplier {
    GrpcServiceFileDescriptorSupplier() {}
  }

  private static final class GrpcServiceMethodDescriptorSupplier
      extends GrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcServiceFileDescriptorSupplier())
              .addMethod(getGetDifferenceMethod())
              .addMethod(getGetRecommendJobMethod())
              .addMethod(getExtractResumeMethod())
              .build();
        }
      }
    }
    return result;
  }
}

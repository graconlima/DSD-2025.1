package cumprimentar;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.64.0)",
    comments = "Source: Cumprimentar.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CumprimentarServiceGrpc {

  private CumprimentarServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "CumprimentarService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cumprimentar.CumprimentarProto.CumprimentarRequest,
      cumprimentar.CumprimentarProto.CumprimentarReply> getDizerOlaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dizerOla",
      requestType = cumprimentar.CumprimentarProto.CumprimentarRequest.class,
      responseType = cumprimentar.CumprimentarProto.CumprimentarReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cumprimentar.CumprimentarProto.CumprimentarRequest,
      cumprimentar.CumprimentarProto.CumprimentarReply> getDizerOlaMethod() {
    io.grpc.MethodDescriptor<cumprimentar.CumprimentarProto.CumprimentarRequest, cumprimentar.CumprimentarProto.CumprimentarReply> getDizerOlaMethod;
    if ((getDizerOlaMethod = CumprimentarServiceGrpc.getDizerOlaMethod) == null) {
      synchronized (CumprimentarServiceGrpc.class) {
        if ((getDizerOlaMethod = CumprimentarServiceGrpc.getDizerOlaMethod) == null) {
          CumprimentarServiceGrpc.getDizerOlaMethod = getDizerOlaMethod =
              io.grpc.MethodDescriptor.<cumprimentar.CumprimentarProto.CumprimentarRequest, cumprimentar.CumprimentarProto.CumprimentarReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "dizerOla"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cumprimentar.CumprimentarProto.CumprimentarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cumprimentar.CumprimentarProto.CumprimentarReply.getDefaultInstance()))
              .setSchemaDescriptor(new CumprimentarServiceMethodDescriptorSupplier("dizerOla"))
              .build();
        }
      }
    }
    return getDizerOlaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CumprimentarServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CumprimentarServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CumprimentarServiceStub>() {
        @java.lang.Override
        public CumprimentarServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CumprimentarServiceStub(channel, callOptions);
        }
      };
    return CumprimentarServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CumprimentarServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CumprimentarServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CumprimentarServiceBlockingStub>() {
        @java.lang.Override
        public CumprimentarServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CumprimentarServiceBlockingStub(channel, callOptions);
        }
      };
    return CumprimentarServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CumprimentarServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CumprimentarServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CumprimentarServiceFutureStub>() {
        @java.lang.Override
        public CumprimentarServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CumprimentarServiceFutureStub(channel, callOptions);
        }
      };
    return CumprimentarServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void dizerOla(cumprimentar.CumprimentarProto.CumprimentarRequest request,
        io.grpc.stub.StreamObserver<cumprimentar.CumprimentarProto.CumprimentarReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDizerOlaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CumprimentarService.
   */
  public static abstract class CumprimentarServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CumprimentarServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CumprimentarService.
   */
  public static final class CumprimentarServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CumprimentarServiceStub> {
    private CumprimentarServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CumprimentarServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CumprimentarServiceStub(channel, callOptions);
    }

    /**
     */
    public void dizerOla(cumprimentar.CumprimentarProto.CumprimentarRequest request,
        io.grpc.stub.StreamObserver<cumprimentar.CumprimentarProto.CumprimentarReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDizerOlaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CumprimentarService.
   */
  public static final class CumprimentarServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CumprimentarServiceBlockingStub> {
    private CumprimentarServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CumprimentarServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CumprimentarServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cumprimentar.CumprimentarProto.CumprimentarReply dizerOla(cumprimentar.CumprimentarProto.CumprimentarRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDizerOlaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CumprimentarService.
   */
  public static final class CumprimentarServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CumprimentarServiceFutureStub> {
    private CumprimentarServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CumprimentarServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CumprimentarServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cumprimentar.CumprimentarProto.CumprimentarReply> dizerOla(
        cumprimentar.CumprimentarProto.CumprimentarRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDizerOlaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DIZER_OLA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DIZER_OLA:
          serviceImpl.dizerOla((cumprimentar.CumprimentarProto.CumprimentarRequest) request,
              (io.grpc.stub.StreamObserver<cumprimentar.CumprimentarProto.CumprimentarReply>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getDizerOlaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cumprimentar.CumprimentarProto.CumprimentarRequest,
              cumprimentar.CumprimentarProto.CumprimentarReply>(
                service, METHODID_DIZER_OLA)))
        .build();
  }

  private static abstract class CumprimentarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CumprimentarServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cumprimentar.CumprimentarProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CumprimentarService");
    }
  }

  private static final class CumprimentarServiceFileDescriptorSupplier
      extends CumprimentarServiceBaseDescriptorSupplier {
    CumprimentarServiceFileDescriptorSupplier() {}
  }

  private static final class CumprimentarServiceMethodDescriptorSupplier
      extends CumprimentarServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CumprimentarServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CumprimentarServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CumprimentarServiceFileDescriptorSupplier())
              .addMethod(getDizerOlaMethod())
              .build();
        }
      }
    }
    return result;
  }
}

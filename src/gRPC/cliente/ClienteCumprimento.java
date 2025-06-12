package cumprimentar;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import cumprimentar.CumprimentarProto.CumprimentarRequest;
import cumprimentar.CumprimentarProto.CumprimentarReply;
import cumprimentar.CumprimentarServiceGrpc;

public class ClienteCumprimento {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        CumprimentarServiceGrpc.CumprimentarServiceBlockingStub stub = CumprimentarServiceGrpc.newBlockingStub(channel);

        CumprimentarReply reply = stub.dizerOla(
            CumprimentarRequest.newBuilder().setNome("Gracon Lima").build()
        );

        System.out.println("Resposta do servidor: " + reply.getMensagem());

        channel.shutdown();
    }
}

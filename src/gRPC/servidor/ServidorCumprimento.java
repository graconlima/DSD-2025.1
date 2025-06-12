package cumprimentar;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import cumprimentar.CumprimentarProto.CumprimentarRequest;
import cumprimentar.CumprimentarProto.CumprimentarReply;
import cumprimentar.CumprimentarServiceGrpc;

public class ServidorCumprimento {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new CumprimentarServiceImpl())
                .build();

        System.out.println("Servidor iniciado na porta 50051...");
        server.start();
        server.awaitTermination();
    }

    static class CumprimentarServiceImpl extends CumprimentarServiceGrpc.CumprimentarServiceImplBase {
        @Override
        public void dizerOla(CumprimentarRequest request, StreamObserver<CumprimentarReply> responseObserver) {
            String resposta = "Olá, " + request.getNome() + "!";
            CumprimentarReply reply = CumprimentarReply.newBuilder().setMensagem(resposta).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}

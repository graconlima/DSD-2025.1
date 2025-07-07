package soap;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.InterfaceCalculadora")
public class ServicoCalculadora implements InterfaceCalculadora{
    
    public float soma(float num1, float num2){
        System.out.println("SOMA ACESSADA..");
        return num1+num2;
    }
    
    public float subtracao(float num1, float num2){
        System.out.println("SUBTRACAO ACESSADA");
        if(num1 > num2){
            return num1 - num2;
        }else{
            return num2 - num1;
        }
    }

    public float multiplicacao(float num1, float num2){
        System.out.println("MULTIPLICACAO ACESSADA");
        return num1*num2;
    }
    
    public float divisao(float num1, float num2){
        System.out.println("DIVISAO ACESSADA");
        if(num2 == 0){
            System.err.println("DIVISAO POR ZERO. NAO FETUADO");
            return 0;
        }else{
            return num1/num2;
        }
    }
}

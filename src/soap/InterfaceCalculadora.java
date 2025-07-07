package soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface InterfaceCalculadora {
    @WebMethod float soma(float num1, float num2);
    @WebMethod float subtracao(float num1, float num2);
    @WebMethod float multiplicacao(float num1, float num2);
    @WebMethod float divisao(float num1, float num2);
}

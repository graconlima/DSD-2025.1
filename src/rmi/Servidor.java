package rmi;

import java.rmi.Naming;

public class Servidor{
        public static void main(String args[]){
                try{
                        Calculadora stub = new CalculadoraRemota();
                        Naming.rebind("rmi://10.25.1.243:5000/calculadora", stub);
                        System.out.println("Servidor em funcionanmento");
                }catch(Exception e){
                    e.printStackTrace();
                }
        }
}

package rmi;

import java.rmi.Naming;

public class Cliente{
        public static void main(String args[]){
                try{
                        Calculadora stub = (Calculadora) Naming.lookup("rmi://localhost:5000/calculadora");
                        System.out.println(stub.soma(7,7));
                }catch(Exception e){}
        }
}

package compras.Error;

public class NumeroNegativo extends Exception{

    public NumeroNegativo(String message) {
        super("Se produjeron "+ message +" negativos");
    }
     
}

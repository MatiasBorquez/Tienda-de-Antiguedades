package compras.Error;

public class ExisteExc extends Exception{

    public ExisteExc(String message) {
        super("Ya existe en la base de datos de: " + message);
    }
    
}

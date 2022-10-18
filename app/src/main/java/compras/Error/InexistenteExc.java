package compras.Error;

public class InexistenteExc extends Exception{

    public InexistenteExc() {
        super("No existe lo que esta buscando en la base de datos");
    }

    public InexistenteExc(String message) {
        super("No existe en la base de datos de: " + message);
    }
    
    
}

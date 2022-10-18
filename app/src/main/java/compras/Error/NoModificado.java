package compras.Error;

public class NoModificado extends Exception{

    public NoModificado(String message) {
        super("No se pudo modificar " + message);
    }
    
}

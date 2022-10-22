package compras.model;

import java.util.HashSet;
import java.util.Set;

import compras.Error.ExisteExc;
import compras.Error.InexistenteExc;

public class TotalLineaPedidos {
    Set<LineaPedido> lineasPedidos;

    public TotalLineaPedidos() {
        lineasPedidos = new HashSet<>();
    }

    public Set<LineaPedido> getLineasPedidos() {
        return lineasPedidos;
    }

    public void agregarLineaPedido(LineaPedido lineaPedido){
        if(Inexistente(lineaPedido)){
            lineasPedidos.add(lineaPedido);
        }
        
    }

    public void eliminarLineaPedido(LineaPedido lineaPedido){
        if (existe(lineaPedido)) {
            lineasPedidos.remove(lineaPedido);
        }
    }

    public void modificarLineaPedido(LineaPedido lineaModificar,LineaPedido lineaModificada){
        eliminarLineaPedido(lineaModificar);
        agregarLineaPedido(lineaModificada);
    }

    public Integer cantida(){
        return lineasPedidos.size();
    }

    public Boolean existe(LineaPedido lineaPedido){
        Boolean existe = false;
        for (LineaPedido linea : lineasPedidos) {
            if(linea.getIdProducto().equals(lineaPedido.getIdProducto())){
               existe = true; 
            }
        }
        if (!existe) {
            try {
                throw new ExisteExc("Producto en la lista");
            } catch (ExisteExc e) {
                e.printStackTrace();
            }
        }
        return existe;
    }

    public LineaPedido buscarLineaPedido(Integer idProducto){
        for (LineaPedido lineaPedido : lineasPedidos) {
            if (lineaPedido.getIdProducto().equals(idProducto)) {
                return lineaPedido;
            }
        }
        try {
            throw new InexistenteExc();
        } catch (InexistenteExc e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean Inexistente(LineaPedido lineaPedido){
        Boolean existe = true;
        for (LineaPedido linea : lineasPedidos) {
            if(linea.getIdProducto().equals(lineaPedido.getIdProducto())){
               existe = false; 
            }
        }
        if (!existe) {
            try {
                throw new InexistenteExc("Producto en la lista");
            } catch (InexistenteExc e) {
                e.printStackTrace();
            }
        }
        return existe;
    }
    
}

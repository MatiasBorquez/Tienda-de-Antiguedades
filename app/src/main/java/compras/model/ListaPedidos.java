package compras.model;

import java.util.*;

import compras.Error.ExisteExc;
import compras.Error.InexistenteExc;

public class ListaPedidos {
    List<Pedido> pedidos;

    public ListaPedidos() {
        pedidos = new ArrayList<>();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedido pedido){
        if(Inexistente(pedido)){
            pedidos.add(pedido);
        }
        
    }

    public void eliminarPedido(Pedido pedido){
        if (existe(pedido)) {
            pedidos.remove(pedido);
        }
    }

    public void modificarPedido(Pedido lineaModificar,Pedido lineaModificada){
        eliminarPedido(lineaModificar);
        agregarPedido(lineaModificada);
    }

    public Integer cantida(){
        return pedidos.size();
    }

    public Boolean existe(Pedido pedido){
        Boolean existe = false;
        for (Pedido p : pedidos) {
            if(p.getIdPedido().equals(pedido.getIdPedido())){
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

    public Pedido buscarPedido(Integer idPedido){
        for (Pedido pedido : pedidos) {
            if (pedido.getIdPedido().equals(idPedido)) {
                return pedido;
            }
        }
        try {
            throw new InexistenteExc();
        } catch (InexistenteExc e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean Inexistente(Pedido pedido){
        Boolean existe = true;
        for (Pedido p : pedidos) {
            if(p.getIdPedido().equals(pedido.getIdPedido())){
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

package compras.model;

import java.util.*;

import compras.Error.InexistenteExc;
import compras.Error.NoModificado;

public class ListaPedidos {
    private List<Pedido> listaPedidos;

    public ListaPedidos() {
        listaPedidos = new ArrayList<>();
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void agregarPedido(Pedido pedido){
        listaPedidos.add(pedido);
    }

    public Boolean eliminarPedido(Pedido pedido){
        if(listaPedidos.contains(pedido)){
            listaPedidos.remove(pedido);
        }else{
            try {
                throw new InexistenteExc("Pedido");
            } catch (InexistenteExc e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public Pedido BuscarPedido(Integer id){
        for (Pedido c : listaPedidos) {
            if (c.getIdCliente().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void modificarPedido(Pedido pedidoModificar,Pedido pedidoModificado){
        Boolean err;
        err = eliminarPedido(pedidoModificado);
        if (err) {
            agregarPedido(pedidoModificado);
        } else {
            try {
                throw new NoModificado("Pedido");
            } catch (NoModificado e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}

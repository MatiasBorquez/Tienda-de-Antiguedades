package compras.model;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;
    private List<Pedido> listaPedidos;

    public Tienda() {
        listaProductos = new ArrayList<>();
        listaClientes = new ArrayList<>();
        listaPedidos = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void agregarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
    }

    public void agregarPedido(Pedido pedido){
        listaPedidos.add(pedido);
    }
    

    


    
}

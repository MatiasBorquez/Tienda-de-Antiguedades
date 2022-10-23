package compras.model;

public class Tienda {
    private AgendaClientes agendaClientes;
    private ListaProductos listaProducto;
    private ListaPedidos listaPedidos;
    
    public Tienda() {
        agendaClientes = new AgendaClientes();
        listaPedidos = new ListaPedidos();
        listaProducto = new ListaProductos();
    }

    public void agregarCliente(Cliente cliente){
        agendaClientes.agregarCliente(cliente);
    }

    public void agregarPedidos(Pedido pedido){
        listaPedidos.agregarPedido(pedido);
    }
    public void agregarProducto(Producto producto){
        listaProducto.agregarProducto(producto);
    }
    public void eliminarCliente(Cliente cliente){
        agendaClientes.eliminarCliente(cliente);
    }
    public void eliminarPedidos(Pedido pedido){
        listaPedidos.agregarPedido(pedido);
    }
    public void eliminarProducto(Producto producto){
        listaProducto.eliminarProducto(producto);
    }
    public void modificarCliente(Cliente clienteModificar, Cliente clienteModificado){
        agendaClientes.modificarCliente(clienteModificar, clienteModificado);
    }
    public void modificarPedidos(Pedido pedidoModificar, Pedido pedidoModificado){
        listaPedidos.modificarPedido(pedidoModificar, pedidoModificado);
    }
    public void modificarProducto(Producto productoModificar, Producto productoModificado){
        listaProducto.modificarProducto(productoModificar, productoModificado);
    }
    public void buscarCliente(Integer dni){
        agendaClientes.BuscarCliente(dni);
    }
    public void buscarPedidos(Integer idPedido){
        listaPedidos.buscarPedido(idPedido);
    }
    public void buscarProducto(Integer idProducto){
        listaProducto.buscarProducto(idProducto);
    }

    public AgendaClientes getAgendaClientes() {
        return agendaClientes;
    }

    public ListaProductos getListaProducto() {
        return listaProducto;
    }

    public ListaPedidos getListaPedidos() {
        return listaPedidos;
    }

    

}

package compras.model;

public class Pedido {
    private Integer idCliente;
    private TotalLineaPedidos lineaPedidos;
    private FormaPagos formaPago;
    private Integer idPedido;
    private static Integer count = 1;
    private Float totalAPagar;

    public Pedido(Integer idCliente, FormaPagos formaPago, TotalLineaPedidos lineasPedidos) {
        this.idCliente = idCliente;
        this.formaPago = formaPago;
        lineaPedidos = lineasPedidos;
        idPedido = count++;
    }

    public TotalLineaPedidos getLineaPedidos() {
        return lineaPedidos;
    }

    public FormaPagos getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPagos formaPago) {
        this.formaPago = formaPago;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    /*
    public Float getTotalAPagar(ListaProductos productos) {
        Producto producto;
        for (LineaPedido linea : lineaPedidos.getLineasPedidos()) {
            producto = linea.verProducto(productos);
            productos.
        }
    }
 */
}

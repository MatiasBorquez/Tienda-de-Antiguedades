package compras.model;

import java.util.List;

import javax.swing.JOptionPane;

public class Pedido {
    private Integer idCliente;
    private List<LineaPedido> lineaPedidos;
    private FormaPagos formaPago;
    private Integer idPedido;
    private static Integer count=1;
    private Float totalAPagar;


    public Pedido(Integer idCliente, FormaPagos formaPago, List<LineaPedido> lineasPedidos) {
        this.idCliente = idCliente;
        this.formaPago = formaPago;
        lineaPedidos = lineasPedidos;
        idPedido = count++;
    }

    public List<Producto> agregarProducto(Integer idProductos, Integer cantidad, List<Producto> listaProductos){
        Producto producto = listaProductos.get(idProductos-1);
        if(producto.getCantidad()-cantidad >=0){
            lineaPedidos.add(new LineaPedido(idProductos, cantidad));
            producto.setCantidad(producto.getCantidad()-cantidad);
            listaProductos.set(idProductos-1, null);
            totalAPagar =  (listaProductos.get(idProductos).getPrecio() * listaProductos.get(idProductos).getCantidad());
        }else{
            JOptionPane.showMessageDialog(null, "ERROR\n No posee la cantidad para realizar la venta");
            return listaProductos;
        }
        return listaProductos;
        
    }

    public List<LineaPedido> getLineaPedidos() {
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

    public Float getTotalAPagar() {
        return totalAPagar;
    }

    

    
}

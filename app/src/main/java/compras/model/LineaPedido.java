package compras.model;

import compras.Error.InexistenteExc;

public class LineaPedido {
    private Integer idProducto;
    private Integer cantidad;

    

    public LineaPedido(Integer idProducto, Integer cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public Producto verProducto(ListaProductos listaProductos){
        for (Producto producto : listaProductos.getProductos()) {
            if (producto.getId().equals(idProducto)) {
                return producto;
            }
        }
        try {
            throw new InexistenteExc();
        } catch (InexistenteExc e) {
            e.printStackTrace();
        }
        return null;
    }

    
    
}

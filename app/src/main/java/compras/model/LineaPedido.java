package compras.model;

import java.util.List;

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

    public Producto verProducto(List<Producto> listaProductos){
        return listaProductos.get(idProducto-1);
    }

    
    
}

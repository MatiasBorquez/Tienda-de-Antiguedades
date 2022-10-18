package compras.model;

import java.util.*;

import compras.Error.InexistenteExc;
import compras.Error.NoModificado;

public class ListaProductos {
    private List<Producto> listaProductos;

    public ListaProductos() {
        listaProductos = new ArrayList<>();
    }
    
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
    }

    public Boolean eliminaProducto(Producto producto){
        if (listaProductos.contains(producto)) {
            listaProductos.remove(producto);
            return true;
        } else {
            try {
                throw new InexistenteExc("producto");
            } catch (InexistenteExc e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }return false;
        
    }

    public Producto buscarProducto(Integer id){
        for (Producto producto : listaProductos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        try {
            throw new InexistenteExc("producto");
        } catch (InexistenteExc e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void modificarProducto(Producto productoModificar,Producto productoModificado){
        Boolean err = eliminaProducto(productoModificar);
        if (err) {
            agregarProducto(productoModificado);
        } else {
            try {
                throw new NoModificado("Producto");
            } catch (NoModificado e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}

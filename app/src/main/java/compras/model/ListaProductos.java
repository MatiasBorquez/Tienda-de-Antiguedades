package compras.model;

import java.util.*;

import compras.Error.ExisteExc;
import compras.Error.InexistenteExc;

public class ListaProductos {
    Set<Producto> productos;

    public ListaProductos() {
        productos = new HashSet<>();
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto){
        if(Inexistente(producto)){
            productos.add(producto);
        }
        
    }

    public void eliminarProducto(Producto producto){
        if (existe(producto)) {
            productos.remove(producto);
        }
    }

    public void modificarProducto(Producto lineaModificar,Producto lineaModificada){
        eliminarProducto(lineaModificar);
        agregarProducto(lineaModificada);
    }

    public Integer cantida(){
        return productos.size();
    }

    public Boolean existe(Producto producto){
        Boolean existe = false;
        for (Producto p : productos) {
            if(p.getId().equals(producto.getId())){
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

    public Producto buscarProducto(Integer idProducto){
        for (Producto p : productos) {
            if (p.getId().equals(idProducto)) {
                return p;
            }
        }
        try {
            throw new InexistenteExc();
        } catch (InexistenteExc e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean Inexistente(Producto producto){
        Boolean existe = true;
        for (Producto p : productos) {
            if(p.getId().equals(producto.getId())){
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

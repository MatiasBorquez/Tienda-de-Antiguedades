package compras.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ListaProductosTest {Cliente cliente1;
    
    Producto producto1;
    Producto producto2;
    Producto producto3;
    ListaProductos productos;

    @BeforeEach
    public void beforeEach(){
        producto1 = new Producto("nombre1", 10, 15.0, 25.0, true);
        producto2 = new Producto("nombre2", 10, 15.0, 30.0, true);
        producto3 = new Producto("nombre3", 30, 20.0, 40.0, false);
        productos = new ListaProductos();
        productos.agregarProducto(producto1);
        productos.agregarProducto(producto2);
    }

    @Test
    void testAgregarProducto() {
        assertTrue(productos.existe(producto1));
        assertTrue(productos.existe(producto2));
    }

    @Test
    void testBuscarProducto() {
        assertEquals(productos.buscarProducto(producto1.getId()), producto1);
        assertEquals(productos.buscarProducto(producto2.getId()), producto2);
    }

    @Test
    void testCantida() {
        assertEquals(productos.cantida(), 2);
        
    }

    @Test
    void testEliminarProducto() {
        productos.eliminarProducto(producto1);
        assertTrue(productos.Inexistente(producto1));
    }

    @Test
    void testModificarProducto() {
        productos.modificarProducto(producto2, producto3);
        assertEquals(productos.buscarProducto(producto3.getId()), producto3);
        assertTrue(productos.Inexistente(producto2));
    }
}

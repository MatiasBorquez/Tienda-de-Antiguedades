package compras.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ListaPedidosTest {
    
    ListaPedidos pedidos;
    Cliente cliente1;
    Cliente cliente2;
    Producto producto1;
    Producto producto2;
    Producto producto3;
    LineaPedido lineaPedido1;
    LineaPedido lineaPedido2;
    LineaPedido lineaPedido3;
    LineaPedido lineaPedido4;
    TotalLineaPedidos totalPedido1;
    TotalLineaPedidos totalPedido2;
    FormaPagos pago1;
    FormaPagos pago2;
    Pedido pedido1;
    Pedido pedido2;

    @BeforeEach
    public void beforeEach(){
        cliente1 = new Cliente("nombre1", "apellido1", 1, "1");
        cliente2 = new Cliente("nombre2", "apellido2", 2, "2");
        producto1 = new Producto("nombre1", 10, 15.0, 25.0, true);
        producto2 = new Producto("nombre2", 10, 15.0, 30.0, true);
        producto3 = new Producto("nombre3", 30, 20.0, 40.0, false);
        lineaPedido1 = new LineaPedido(1, 3);
        lineaPedido2 = new LineaPedido(2, 3);
        lineaPedido3 = new LineaPedido(3, 6);
        lineaPedido4 = new LineaPedido(2, 1);
        totalPedido1 = new TotalLineaPedidos();
        totalPedido2 = new TotalLineaPedidos();
        totalPedido2.agregarLineaPedido(lineaPedido2);
        totalPedido2.agregarLineaPedido(lineaPedido3);
        totalPedido2.agregarLineaPedido(lineaPedido4);
        totalPedido1.agregarLineaPedido(lineaPedido1);
        totalPedido1.agregarLineaPedido(lineaPedido3);
        pago1 = new FormaPagos(541324118618.0, LocalDate.now(), 536);
        pago2 = new FormaPagos();
        pedido1 = new Pedido(1, pago1, totalPedido1);
        pedido2 = new Pedido(2, pago2, totalPedido2);
        pedidos = new ListaPedidos();
        pedidos.agregarPedido(pedido1);
        pedidos.agregarPedido(pedido2);
    }

    @Test
    void testAgregarPedido() {
        assertTrue(pedidos.existe(pedido1));
        assertTrue(pedidos.existe(pedido2));
    }

    @Test
    void testBuscarPedido() {
        assertEquals(pedidos.buscarPedido(pedido1.getIdPedido()), pedido1);
        assertEquals(pedidos.buscarPedido(pedido2.getIdPedido()), pedido2);
    }

    @Test
    void testModificarPedido() {
        TotalLineaPedidos totalPedido3 = new TotalLineaPedidos();
        totalPedido3.agregarLineaPedido(lineaPedido2);
        totalPedido3.agregarLineaPedido(lineaPedido3);
        Pedido pedido3 = new Pedido(1, pago2, totalPedido3);
        pedidos.modificarPedido(pedido1, pedido3);
        assertTrue(pedidos.existe(pedido3));
        assertTrue(pedidos.Inexistente(pedido1));

    }


    @Test
    void testEliminarPedido() {
        pedidos.eliminarPedido(pedido1);
        assertTrue(pedidos.Inexistente(pedido1));
    }

    @Test
    void testCantida() {
        assertEquals(pedidos.cantida(), 2);
    }

    
}

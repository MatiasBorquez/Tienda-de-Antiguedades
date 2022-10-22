package compras.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PedidoTest {

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
        producto1 = new Producto("nombre1", 10, 15.0, 25.0, true);/*19.05 */
        producto2 = new Producto("nombre2", 10, 15.0, 30.0, true);/*19.8 */
        producto3 = new Producto("nombre3", 30, 20.0, 40.0, false);/*28.7 */
        lineaPedido1 = new LineaPedido(1, 3);
        lineaPedido2 = new LineaPedido(2, 3);
        lineaPedido3 = new LineaPedido(3, 6);
        lineaPedido4 = new LineaPedido(2, 1);
        totalPedido1 = new TotalLineaPedidos();
        totalPedido2 = new TotalLineaPedidos();
        totalPedido2.agregarLineaPedido(lineaPedido1);
        totalPedido2.agregarLineaPedido(lineaPedido2);
        totalPedido2.agregarLineaPedido(lineaPedido3);/*288.75 */
        totalPedido1.agregarLineaPedido(lineaPedido4);
        totalPedido1.agregarLineaPedido(lineaPedido3);/*191.25 */
        pago1 = new FormaPagos();
        pago2 = new FormaPagos(541324118618.0, LocalDate.now(), 536);
        pedido1 = new Pedido(1, pago1, totalPedido1);
        pedido2 = new Pedido(1, pago2, totalPedido2);
    }

    @Test
    void testGetFormaPago() {
        assertEquals(pedido1.getFormaPago(), pago1);
        assertEquals(pedido2.getFormaPago(), pago2);
    }

    @Test
    void testGetLineaPedidos() {
        assertEquals(pedido1.getLineaPedidos(), totalPedido1);
        assertEquals(pedido2.getLineaPedidos(), totalPedido2);
    }

    @Test
    void testGetTotalAPagar() {
        assertEquals(pedido1.getTotalAPagar(), Double.valueOf(191.25));
        assertEquals(pedido2.getTotalAPagar(), Double.valueOf(288.75));
    }
}

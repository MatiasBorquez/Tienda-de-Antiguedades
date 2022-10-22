package compras.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AgendaClientesTest {

    Cliente cliente1;
    Cliente cliente2;
    Cliente cliente3;
    AgendaClientes agenda;

    @BeforeAll
    public void beforeEach(){
        AgendaClientes agenda = new AgendaClientes();
        cliente1 = new Cliente("nombre1", "apellido1", 1, "1");
        cliente2 = new Cliente("nombre2", "apellido2", 2, "2");
        agenda.agregarCliente(cliente1);
        agenda.agregarCliente(cliente2);
    }

    @Test
    void testBuscarCliente() {
        assertEquals(agenda.BuscarCliente(1), cliente1);
        assertEquals(agenda.BuscarCliente(2), cliente2);
    }

    @Test
    void testAgregarCliente() {
        assertTrue(agenda.existe(cliente1));
        assertTrue(agenda.Inexistente(cliente2));
    }

    @Test
    void testBuscarCliente2() {
        assertEquals(agenda.buscarCliente(1), cliente1);
        assertEquals(agenda.buscarCliente(2), cliente2);
    }

    @Test
    void testCantida() {
        assertEquals(agenda.cantida(), 2);
    }

    @Test
    void testEliminarCliente() {
        agenda.eliminarCliente(cliente1);
        assertTrue(agenda.Inexistente(cliente1));
    }

    @Test
    void testModificarCliente() {
        cliente3 = new Cliente("nombre3", "apellido3", 3, "3");
        agenda.modificarCliente(cliente2, cliente3);
        assertEquals(agenda.BuscarCliente(3), cliente3);
        assertTrue(agenda.Inexistente(cliente2));
    }
}

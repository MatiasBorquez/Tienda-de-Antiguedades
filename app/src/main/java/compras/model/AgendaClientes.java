package compras.model;

import java.util.*;

public class AgendaClientes {
    private Set<Cliente> listaClientes;

    public AgendaClientes() {
        
        listaClientes = new HashSet<>();
    }

    public Set<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void agregarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente){
        listaClientes.remove(cliente);
    }

    public Cliente BuscarCliente(Integer dni){
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }
}

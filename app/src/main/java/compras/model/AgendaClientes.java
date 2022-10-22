package compras.model;

import java.util.*;

import compras.Error.*;

public class AgendaClientes {
    List<Cliente> agenda;

    public AgendaClientes() {
        agenda = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente){
        if(Inexistente(cliente)){
            agenda.add(cliente);
        }

        
    }

    public void eliminarCliente(Cliente cliente){
        if (existe(cliente)) {
            agenda.remove(cliente);
        }
    }

    public void modificarCliente(Cliente clienteModificar,Cliente clienteModificadp){
        eliminarCliente(clienteModificar);
        agregarCliente(clienteModificadp);
    }

    public Integer cantida(){
        return agenda.size();
    }

    public Cliente buscarCliente(Integer idCliente){
        for (Cliente cliente : agenda) {
            if (cliente.getDni().equals(idCliente)) {
                return cliente;
            }
        }
        try {
            throw new InexistenteExc();
        } catch (InexistenteExc e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean existe(Cliente cliente){
        Boolean existe = false;
        for (Cliente c : agenda) {
            if(c.getDni().equals(cliente.getDni())){
               existe = true; 
            }
        }
        if (!(existe)) {
            try {
                throw new ExisteExc("Producto en la lista");
            } catch (ExisteExc e) {
                e.printStackTrace();
            }
        }
        return existe;
    }

    public Boolean Inexistente(Cliente cliente){
        Boolean inexistente = true;
        for (Cliente c : agenda) {
            if(c.getDni().equals(cliente.getDni())){
               inexistente = false; 
            }
        }
        if (!(inexistente)) {
            try {
                throw new InexistenteExc("Producto en la lista");
            } catch (InexistenteExc e) {
                e.printStackTrace();
            }
        }
        return inexistente;
    }

    public Cliente BuscarCliente(Integer dni){
        for (Cliente c : agenda) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }
}

package compras.model;

import java.util.*;

public class Cliente {
    private String nombre;
    private String apellido;
    private Integer dni;
    private String domicilio;
    private List<Integer> idPedidos;
    private Integer idCliente;
    private static Integer count=1; 

    public Cliente(String nombre, String apellido, Integer dni, String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        idPedidos = new ArrayList<>();
        idCliente = count++;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public List<Integer> verIDPedidos(){
        return idPedidos;
    }

    public void AgregarIdPedido(Integer id){
        idPedidos.add(id);
    }

    

    

    
}

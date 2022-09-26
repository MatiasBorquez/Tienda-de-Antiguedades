package compras.Controllers;

import java.util.*;

import javax.swing.JOptionPane;

import compras.model.*;

public class TiendaController implements ITiendaControllers{

    private Tienda tienda;

    public TiendaController() {
        tienda = new Tienda();
    }

    @Override
    public void agregarCliente() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre del cliente");
        String apellido = JOptionPane.showInputDialog(null, "Ingrese apellido del cliente");
        String domicilio = JOptionPane.showInputDialog(null, "Ingrese domicilio del cliente");
        Integer dni = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese dni del cliente"));
        Cliente cliente = new Cliente(nombre, apellido, dni, domicilio);
        tienda.agregarCliente(cliente);
    }

    @Override
    public void agregarPedido() {
        Boolean condition;
        Integer idCliente=null;
        FormaPagos formaPagos;
        Integer forma = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de cual va a ser la forma de pago"+
        "\n\t1- Tarjeta\n\t2- Cheque\n\t3- Efectivo"));
        switch (forma) {
            case 1:
                Integer numeroTarjeta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de tarjeta"));
                String fechaDeVencimiento = (JOptionPane.showInputDialog(null, "Ingrese fecha de vencimiento de la tarjeta"));
                Integer codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese fecha de vencimiento de la tarjeta"));
                formaPagos = new FormaPagos(numeroTarjeta, fechaDeVencimiento, codigo);
                break;
            case 2:
                String numCheque = JOptionPane.showInputDialog(null, "Ingrese numCheque del cliente");
                formaPagos = new FormaPagos(numCheque);
                break;
            case 3:
                formaPagos = new FormaPagos();
                break;
            default:
                JOptionPane.showMessageDialog(null, "A ingresado un numero que no esta configurado");
                return;
        }
        Integer desicion = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea seleccionar un cliente existente o crear uno nuevo? 1=existente/2=nuevo"));
        if (desicion.equals(1)) {
            idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, tienda.getListaClientes(), "Ingrese Id del cliente", 0));
        } else if (desicion.equals(2)) {
            agregarCliente();
            Cliente cliente = tienda.getListaClientes().get(tienda.getListaClientes().size()-1);
            idCliente = cliente.getIdCliente();
        }
        List<LineaPedido> lineaPedido = new ArrayList<>();
        do {
            Integer idPedidos = Integer.parseInt(JOptionPane.showInputDialog(null, tienda.getListaProductos(), "Ingrese Id del Producto", 0));
            Integer cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de productos comprados"));
            lineaPedido.add(new LineaPedido(idPedidos, cantidad));
            String decision = JOptionPane.showInputDialog(null, "Quiere seguir ingresando?si/no");
            condition = (decision.equalsIgnoreCase("si")) ? false : true;
        } while (condition);
        tienda.agregarPedido(new Pedido(idCliente, formaPagos, lineaPedido));
    }

    @Override
    public void agregarProducto() {
        Boolean nacional;
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre del cliente");
        Integer cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese nombre del cliente"));
        Float precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese nombre del cliente"));
        Float porcentajeImpuestos = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese nombre del cliente"));
        Integer nacionalI = Integer.parseInt(JOptionPane.showInputDialog(null, "El producto es nacional? 1=Si/2=No"));
        if (nacionalI == 1) {
            nacional = true;
        } else {
            nacional = false;
        }

        tienda.agregarProducto(new Producto(nombre, cantidad, precio, porcentajeImpuestos, nacional));
        
    }

    @Override
    public void VerPedidos() {
        JOptionPane.showMessageDialog(null, tienda.getListaPedidos(), "Pedidos", 0, null);        
    }

    @Override
    public void VerProductos() {
        JOptionPane.showMessageDialog(null, tienda.getListaProductos(), "Productos", 0);
        
    }
    
}

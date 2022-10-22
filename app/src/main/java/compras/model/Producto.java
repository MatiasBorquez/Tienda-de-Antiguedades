package compras.model;

public class Producto {
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private Double porcentajeImpuestos;
    private Integer id;
    private static Integer count = 1;
    private Boolean nacional;
    private Double retencion = 0.02;
    private Double aduana = 0.01;
    private Double transporte = 0.005;

    public Producto(String nombre, Integer cantidad, Double precio, Double porcentajeImpuestos, Boolean nacional) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.porcentajeImpuestos = porcentajeImpuestos/100;
        this.nacional = nacional;
        this.porcentajeImpuestos += (nacional) ?  retencion : (transporte + aduana + retencion);
        this.precio = (1 + this.porcentajeImpuestos) * precio;
        this.id = count++;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double getPorcentajeImpuestos() {
        return porcentajeImpuestos;
    }

    public Boolean getNacional() {
        return nacional;
    }

    public Integer getId() {
        return id;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}

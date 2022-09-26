package compras.model;

public class FormaPagos {
    enum metodo{Tarjeta, Cheque, Efectivo}
    private metodo metodoPago;
    private Integer numeroDeTarjeta;
    private String fechaDeVencimiento;
    private Integer codigo;
    private String numCheque;

    public FormaPagos(Integer numeroDeTarjeta, String fechaDeVencimiento, Integer codigo) {
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.codigo = codigo;
        this.metodoPago = metodo.Tarjeta;
    }

    public FormaPagos() {
        this.metodoPago = metodo.Efectivo;
    }

    public FormaPagos(String numCheque) {
        this.numCheque = numCheque;
        this.metodoPago = metodo.Cheque;
    }

    public String VerMetodo(){
        switch (metodoPago) {
            case Tarjeta:
                return "Pagado con Tarjeta:\n numeroDeTarjeta: " + numeroDeTarjeta;
            case Cheque:
                return "Pagado con Cheque:\n Cheque: " + numCheque ;
            case Efectivo:
                return "Pagado con Efectivo";
            default:
                
                break;
        }
        return null;
    }

    @Override
    public String toString() {

        return VerMetodo();
    }
}


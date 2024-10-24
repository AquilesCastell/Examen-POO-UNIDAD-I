package UNAH.EXAMEN_POO.TIENDA.PRODUCTOS.PAGOS;

public class PagoPayPal implements IMetodoPago {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Conectando a PayPal para procesar un pago de $" + monto + "...");
        System.out.println("Pago procesado exitosamente a través de PayPal.");
        return true;
    }
}

}

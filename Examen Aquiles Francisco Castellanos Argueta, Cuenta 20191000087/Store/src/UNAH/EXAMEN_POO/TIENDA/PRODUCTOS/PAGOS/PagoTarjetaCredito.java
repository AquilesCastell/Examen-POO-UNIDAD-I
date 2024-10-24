package UNAH.EXAMEN_POO.TIENDA.PRODUCTOS.PAGOS;

public class PagoTarjetaCredito implements IMetodoPago {

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " con tarjeta de crédito...");
        // Simulación de verificación de fondos
        if (monto > 100) { // Simulación de fondos insuficientes
            System.out.println("Fondos insuficientes.");
            return false;
        }
        System.out.println("Pago procesado exitosamente.");
        return true;
    }
}
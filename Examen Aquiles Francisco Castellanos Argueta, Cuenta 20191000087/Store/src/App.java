import UNAH.EXAMEN_POO.TIENDA.Tienda;
import UNAH.EXAMEN_POO.TIENDA.Pedido;
import UNAH.EXAMEN_POO.TIENDA.PRODUCTOS.ProductoElectrónico;
import UNAH.EXAMEN_POO.TIENDA.PRODUCTOS.ProductoAlimenticio;
import UNAH.EXAMEN_POO.TIENDA.PRODUCTOS.PAGOS.IMetodoPago;
import UNAH.EXAMEN_POO.TIENDA.PRODUCTOS.PAGOS.PagoPayPal;
import UNAH.EXAMEN_POO.TIENDA.PRODUCTOS.PAGOS.PagoTarjetaCredito;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

       // Crear productos
       ProductoElectrónico laptop = new ProductoElectrónico("Laptop", 1200.00, 10, 24);
       ProductoAlimenticio leche = new ProductoAlimenticio("Leche", 1.50, 50, "2024-12-31");
       
       // Crear pedidos
       Pedido[] pedidos = new Pedido[2];

       try {
           // Primer pedido con un producto de cada tipo
           Pedido pedido1 = new Pedido();
           pedido1.agregarProducto(laptop, 1);
           pedido1.agregarProducto(leche, 2);
           pedidos[0] = pedido1;

           // Segundo pedido con un producto de cada tipo
           Pedido pedido2 = new Pedido();
           pedido2.agregarProducto(leche, 3); // Intentando agregar más leche al segundo pedido
           pedido2.agregarProducto(laptop, 1);
           pedidos[1] = pedido2;

           // Procesar ambos pedidos con diferentes métodos de pago
           IMetodoPago pago1 = new PagoTarjetaCredito();
           pedido1.procesarPago(pago1);

           IMetodoPago pago2 = new PagoPayPal();
           pedido2.procesarPago(pago2);

       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

       // Mostrar información de la tienda
       Tienda tienda = Tienda.getInstancia();
       System.out.println("Información de la tienda:");
       System.out.println("Nombre: " + tienda.getNombreTienda());
       System.out.println("Dirección: " + tienda.getDireccion());
       System.out.println("Moneda: " + tienda.getMoneda());

       // Mostrar totales de los pedidos procesados
       for (Pedido pedido : pedidos) {
           if (pedido != null) {
               System.out.println("Total del pedido: $" + pedido.calcularTotal());
           }
       }
   }
}


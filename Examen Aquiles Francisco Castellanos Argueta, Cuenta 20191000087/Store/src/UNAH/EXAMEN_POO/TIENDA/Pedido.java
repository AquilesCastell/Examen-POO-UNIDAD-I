package UNAH.EXAMEN_POO.TIENDA;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import UNAH.EXAMEN_POO.TIENDA.PRODUCTOS.ProductoAlimenticio;

public class Pedido {
    private List<Producto> productos;

    public Pedido() {
        this.productos = new ArrayList<>();
    }

   public void agregarProducto(Producto producto, int cantidad) throws Exception {
       // Validar si el producto es alimenticio y está vencido
       if (producto instanceof ProductoAlimenticio) {
           if (isProductoVencido((ProductoAlimenticio) producto)) {
               throw new Exception("El producto " + producto.getNombre() + " está vencido y no puede ser agregado al pedido.");
           }
       }

       // Validar stock disponible
       if (producto.getStock() < cantidad) {
           throw new Exception("No hay suficiente stock para el producto: " + producto.getNombre());
       }

       // Agregar el producto y reducir el stock
       for (int i = 0; i < cantidad; i++) {
           productos.add(producto);
           producto.reducirStock(1); // Reducir el stock por cada unidad agregada
       }
       
       System.out.println("Agregado: " + cantidad + " x " + producto.getNombre());
   }

   private boolean isProductoVencido(ProductoAlimenticio producto) {
       return LocalDate.now().isAfter(producto.getFechaExpiracion());
   }

   public double calcularTotal() {
       double total = 0.0;
       for (Producto producto : productos) {
           total += producto.getPrecio();
       }
       return total;
   }

   public void procesarPedido(MetodoPago metodoPago) throws Exception {
       double total = calcularTotal();
       if (!metodoPago.procesarPago(total)) {
           throw new Exception("Error en el procesamiento del pago. Pedido no completado.");
       }
       System.out.println("Pedido procesado exitosamente. Total: $" + total);
   }
}


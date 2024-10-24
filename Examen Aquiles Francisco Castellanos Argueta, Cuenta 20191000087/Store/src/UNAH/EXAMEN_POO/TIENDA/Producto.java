package UNAH.EXAMEN_POO.TIENDA;
/* import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; */

public class Producto {

        private String nombre;
        private double precio;
        private int stock;
    
        public Producto(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public double getPrecio() {
            return precio;
        }
    
        public int getStock() {
            return stock;
        }
    
        public void reducirStock(int cantidad) {
            this.stock -= cantidad;
        }
    
        @Override
        public String toString() {
            return "Producto: " + nombre + ", Precio: " + precio + ", Stock: " + stock;
        }
    }

}
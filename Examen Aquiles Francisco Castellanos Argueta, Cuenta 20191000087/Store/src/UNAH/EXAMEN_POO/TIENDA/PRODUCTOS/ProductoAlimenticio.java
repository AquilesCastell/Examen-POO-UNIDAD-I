package UNAH.EXAMEN_POO.TIENDA.PRODUCTOS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import UNAH.EXAMEN_POO.TIENDA.Producto;

public class ProductoAlimenticio extends Producto{

    private LocalDate fechaExpiracion;

    public ProductoAlimenticio(String nombre, double precio, int stock, String fechaExpiracion) {
        super(nombre, precio, stock);
        this.fechaExpiracion = LocalDate.parse(fechaExpiracion, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fecha de Expiración: " + fechaExpiracion;
    }
}


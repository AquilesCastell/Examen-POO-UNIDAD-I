package UNAH.EXAMEN_POO.TIENDA.PRODUCTOS;

import UNAH.EXAMEN_POO.TIENDA.Producto;

public class ProductoElectrónico extends Producto{

    private int garantia; // en meses

    public ProductoElectrónico(String nombre, double precio, int stock, int garantia) {
        super(nombre, precio, stock);
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Garantía: " + garantia + " meses";
    }
}

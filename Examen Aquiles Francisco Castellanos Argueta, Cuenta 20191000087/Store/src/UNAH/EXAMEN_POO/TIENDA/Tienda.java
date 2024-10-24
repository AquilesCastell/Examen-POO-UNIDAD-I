package UNAH.EXAMEN_POO.TIENDA;

public class Tienda {

    private static Tienda instancia;
    
    private String nombreTienda;
    private String direccion;
    private String moneda;

    private Tienda() {
        this.nombreTienda = "EL GUACHIPILÍN";
        this.direccion = "Tienda Central: Calle Principal, Marcala, La Paz, Honduras";
        this.moneda = "USD";
    }

    public static Tienda getInstancia() {
        if (instancia == null) {
            instancia = new Tienda();
        }
        return instancia;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMoneda() {
        return moneda;
    }
}


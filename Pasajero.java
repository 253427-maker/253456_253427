public class Pasajero {
    private String nombre;
    private int asiento;

    public Pasajero(String nombre, int asiento) {
        this.nombre = nombre;
        this.asiento = asiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAsiento() {
        return asiento;
    }

    public boolean esIgualA(Pasajero otro) {
        return this.nombre.equalsIgnoreCase(otro.nombre) && this.asiento == otro.asiento;
    }

    @Override
    public String toString() {
        return nombre + " (asiento " + asiento + ")";
    }
}

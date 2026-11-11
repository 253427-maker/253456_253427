import java.util.ArrayList;

public class GestorAbordaje {
    private static final int CAPACIDAD = 40;

    private ArrayList<Pasajero> ventas = new ArrayList<>();
    private ArrayList<Pasajero> abordados = new ArrayList<>();
    private Cola fila = new Cola();

    public String venderBoleto(String nombre, int asiento) {
        if (asiento < 1 || asiento > CAPACIDAD) {
            return "Error: el asiento debe estar entre 1 y " + CAPACIDAD + ".";
        }
        for (Pasajero v : ventas) {
            if (v.getAsiento() == asiento) {
                return "Error: el asiento " + asiento + " ya fue vendido.";
            }
        }
        ventas.add(new Pasajero(nombre, asiento));
        return "Boleto registrado: " + nombre + ", asiento " + asiento + ".";
    }

    public String llegarAFila(String nombre, int asiento) {
        Pasajero p = new Pasajero(nombre, asiento);
        if (fila.contiene(p)) {
            return "Error: " + nombre + " ya esta en la fila.";
        }
        fila.encolar(p);
        return nombre + " se formo en la fila (lugar " + fila.getTamano() + ").";
    }

    public String abordar() {
        Pasajero p = fila.desencolar();
        if (p == null) {
            return "Error: no hay pasajeros en la fila.";
        }
        abordados.add(p);
        return "Abordo: " + p;
    }

    public void verFila() {
        System.out.println("--- Fila de abordaje (" + fila.getTamano() + " pasajeros) ---");
        fila.mostrar();
    }

    public void verVentas() {
        System.out.println("--- Registro de ventas ---");
        if (ventas.isEmpty()) {
            System.out.println("No hay boletos vendidos.");
        }
        for (Pasajero v : ventas) {
            System.out.println(v);
        }
    }

    private boolean estaEn(ArrayList<Pasajero> lista, Pasajero p) {
        for (Pasajero x : lista) {
            if (x.esIgualA(p)) {
                return true;
            }
        }
        return false;
    }

    public void inspeccionFinal() {
        System.out.println("===== INSPECCION FINAL (CHECKLIST) =====");
        int faltantes = 0;
        int sinBoleto = 0;

        for (Pasajero v : ventas) {
            if (estaEn(abordados, v)) {
                System.out.println("[OK] " + v + " - presente");
            } else {
                System.out.println("[X]  " + v + " - NO abordo");
                faltantes++;
            }
        }

        for (Pasajero a : abordados) {
            if (!estaEn(ventas, a)) {
                System.out.println("[X]  " + a + " - a bordo SIN boleto registrado");
                sinBoleto++;
            }
        }

        System.out.println("----------------------------------------");
        System.out.println("Boletos vendidos: " + ventas.size() + " | A bordo: " + abordados.size());
        if (faltantes == 0 && sinBoleto == 0) {
            System.out.println("RESULTADO: la asistencia coincide con los boletos emitidos.");
        } else {
            System.out.println("RESULTADO: hay diferencias (faltantes: " + faltantes
                    + ", sin boleto: " + sinBoleto + ").");
        }
    }
}

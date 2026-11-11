public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int tamano;

    public Cola() {
        frente = null;
        fin = null;
        tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamano() {
        return tamano;
    }

    public void encolar(Pasajero p) {
        Nodo nuevo = new Nodo(p);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamano++;
    }

    public Pasajero desencolar() {
        if (estaVacia()) {
            return null;
        }
        Pasajero p = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        tamano--;
        return p;
    }

    public Pasajero verFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.dato;
    }

    public boolean contiene(Pasajero p) {
        Nodo actual = frente;
        while (actual != null) {
            if (actual.dato.esIgualA(p)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La fila esta vacia.");
            return;
        }
        Nodo actual = frente;
        int posicion = 1;
        while (actual != null) {
            System.out.println(posicion + ". " + actual.dato);
            actual = actual.siguiente;
            posicion++;
        }
    }
}

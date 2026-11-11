import java.util.Scanner;

public class MenuAbordaje {

    private int leerEntero(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        GestorAbordaje gestor = new GestorAbordaje();
        int opcion;

        do {
            System.out.println();
            System.out.println("===== ABORDAJE DE AUTOBUS =====");
            System.out.println("1. Vender boleto");
            System.out.println("2. Llegada de pasajero a la fila");
            System.out.println("3. Abordar (sube el primero de la fila)");
            System.out.println("4. Ver fila");
            System.out.println("5. Ver registro de ventas");
            System.out.println("6. Inspeccion final (checklist)");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                case 2:
                    System.out.print("Nombre del pasajero: ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Numero de asiento: ");
                    int asiento = leerEntero(sc);
                    if (opcion == 1) {
                        System.out.println(gestor.venderBoleto(nombre, asiento));
                    } else {
                        System.out.println(gestor.llegarAFila(nombre, asiento));
                    }
                    break;
                case 3:
                    System.out.println(gestor.abordar());
                    break;
                case 4:
                    gestor.verFila();
                    break;
                case 5:
                    gestor.verVentas();
                    break;
                case 6:
                    gestor.inspeccionFinal();
                    break;
                case 0:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}

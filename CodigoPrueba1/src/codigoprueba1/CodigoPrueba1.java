package codigoprueba1;


import java.util.Scanner;

public class CodigoPrueba1 {
    private static final String[] notas = new String[100];
    private static int contador = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            limpiarPantalla();
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Ingrese la nota:");
                    String nota = scanner.nextLine();
                    añadirNota(nota);
                    pausa();
                    break;
                case 2:
                    limpiarPantalla();
                    mostrarNotas(0);
                    pausa();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    limpiarPantalla();
                    System.out.println("Opción no válida");
                    pausa();
                    break;
            }
        } while (opcion != 3);
    }

    private static void añadirNota(String nota) {
        if (contador < notas.length) {
            notas[contador] = nota;
            contador++;
            System.out.println("Nota añadida correctamente.");
        } else {
            System.out.println("No se pueden añadir más notas.");
        }
    }

    private static void mostrarNotas(int indice) {
        if (indice < contador) {
            System.out.println((indice + 1) + ". " + notas[indice]);
            mostrarNotas(indice + 1);
        } else if (indice == 0) {
            System.out.println("No hay notas para mostrar.");
        }
    }

    private static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void pausa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }

    private static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Añadir nota");
        System.out.println("2. Mostrar notas");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }
}

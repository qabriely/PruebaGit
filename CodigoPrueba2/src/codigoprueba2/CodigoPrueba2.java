package codigoprueba2;

import java.util.Scanner;

// Nodo de la lista circular
class Nodo {
    String palabra;
    Nodo siguiente;

    Nodo(String palabra) {
        this.palabra = palabra;
        this.siguiente = null;
    }
}

// Lista Circular
class ListaCircular {
    Nodo cabeza;

    ListaCircular() {
        cabeza = null;
    }

    // Método para agregar palabras a la lista
    void agregar(String palabra) {
        Nodo nuevoNodo = new Nodo(palabra);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            nuevoNodo.siguiente = cabeza; 
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        }
    }

    // Calcula la cantidad de palabras en la lista
    int contarPalabras() {
        if (cabeza == null) {
            return 0;
        }

        int contador = 0;
        Nodo temp = cabeza;

        do {
            contador++;
            temp = temp.siguiente;
        } while (temp != cabeza);

        return contador;
    }

    // Concatena las palabras con espacios
    String concatenarConEspacios() {
        if (cabeza == null) {
            return "";
        }

        StringBuilder resultado = new StringBuilder();
        Nodo temp = cabeza;

        do {
            resultado.append(temp.palabra).append(" ");
            temp = temp.siguiente;
        } while (temp != cabeza);

        return resultado.toString().trim(); 
    }
}

// Clase principal

/**
 *
 * @author gabri
 */
public class CodigoPrueba2 {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Bienvenido a la Calculadora de sus Compras\n");

        while (continuar) {
            System.out.print("Ingrese un producto para agregar a su lista \n(Presione 'fin' para terminar): ");
            String palabra = scanner.nextLine();

            if (palabra.equalsIgnoreCase("fin")) {
                continuar = false;
            } else {
                lista.agregar(palabra);
                System.out.printf("\nEl producto '%s' ha sido agregado correctamente.\n\n", palabra);
            }
        }

        int totalPalabras = lista.contarPalabras();
        System.out.printf("\nProductos en total: %d\n", totalPalabras);

        String palabrasConcatenadas = lista.concatenarConEspacios();
        System.out.println("\nLos productos son los siguientes:");
        System.out.println(palabrasConcatenadas);

        System.out.println("\n Hasta luego...");
    }
}

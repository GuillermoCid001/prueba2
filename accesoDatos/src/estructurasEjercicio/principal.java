package estructurasEjercicio;

import java.util.ArrayList;
import java.util.Scanner;

public class principal {
    private static ArrayList<String> listaNumeros = new ArrayList<>();
    
    
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	 listaNumeros.add("Guillermo");
    	 listaNumeros.add("Miguel");
    	 listaNumeros.add("Rania");
        int eleccion;
         
        do {
            mostrarMenu();
            eleccion = sc.nextInt();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    añadir.añadirValor(listaNumeros, sc);
                    break;
                case 2:
                    modificar.modificarValor(listaNumeros, sc);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("Lista actual: " + listaNumeros);
        } while (eleccion != 0);

        sc.close();
    }

   
    private static void mostrarMenu() {
        System.out.println("INTRODUCE \n 1.Para añadir un valor a la lista\n 2.Para modificar un valor existente \n 0.Para salir del programa");
    }

    
    }


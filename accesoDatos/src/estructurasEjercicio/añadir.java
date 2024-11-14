package estructurasEjercicio;

import java.util.ArrayList;
import java.util.Scanner;

public class añadir {
    public static void añadirValor(ArrayList<String> listaNumeros, Scanner sc) {
        System.out.println("Introduce un valor para añadir a la lista:");
        String valorAñadir = sc.nextLine();
        listaNumeros.add(valorAñadir);
        System.out.println("Valor añadido: " + valorAñadir);
    }
}

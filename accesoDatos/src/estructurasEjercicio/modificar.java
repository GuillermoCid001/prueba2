package estructurasEjercicio;

import java.util.ArrayList;
import java.util.Scanner;

public class modificar {
    public static void modificarValor(ArrayList<String> listaNumeros, Scanner sc) {
        System.out.println("Introduce el  valor que quieres modificar:");
        int indiceModificar = sc.nextInt();
        sc.nextLine();
        
        for()
        
        if (indiceModificar >= 0 && indiceModificar < listaNumeros.size()) {
            System.out.println("Introduce el nuevo valor:");
            String nuevoValor = sc.nextLine();
            listaNumeros.set(indiceModificar, nuevoValor);
            System.out.println("Valor modificado " + indiceModificar + ": " + nuevoValor);
        } else {
            System.out.println("Índice no válido.");
        }
    }
}

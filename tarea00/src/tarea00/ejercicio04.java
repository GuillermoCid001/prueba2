package tarea00;

import java.io.File;

public class ejercicio04 {

    public static void main(String[] args) {
        
        String carpetaPrimeroDam = "C:\\Users\\Guille\\Documents\\acceso a datos\\Carpeta personal\\primeroDam";

        
        String nombreFichero = "notas.txt";

        
        File ficheroNotas = new File(carpetaPrimeroDam, nombreFichero);

        
        if (ficheroNotas.exists()) {
            if (ficheroNotas.delete()) {
                System.out.println("fichero '" + nombreFichero + "'  eliminado");
            
        } else {
            System.out.println("fichero '" + nombreFichero + "' no se pudo borrar.");
        }
    }
   }
  }

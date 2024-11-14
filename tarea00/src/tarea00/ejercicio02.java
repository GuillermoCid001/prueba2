package tarea00;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ejercicio02 {

    public static void main(String[] args) {
        
        String carpetaPrimeroDam = "C:\\Users\\Guille\\Documents\\acceso a datos\\Carpeta personal\\primeroDam";

        
        String notas = "notas.txt";

        
        File ficheroNotas = new File(carpetaPrimeroDam, notas);

        
        StringBuilder contenidoNotas = new StringBuilder();
        contenidoNotas.append("Programación: 9\n");
        contenidoNotas.append("Bases de Datos: 8\n");
        contenidoNotas.append("Entornos de Desarrollo: 7\n");
        contenidoNotas.append("Sistemas Informáticos: 5\n");
        contenidoNotas.append("FOL: 10\n");
        contenidoNotas.append("Lenguaje de marcas: 8\n");

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroNotas))) {
            
            writer.write(contenidoNotas.toString());
            System.out.println(" notas  guardadas en fichero: " + ficheroNotas.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}

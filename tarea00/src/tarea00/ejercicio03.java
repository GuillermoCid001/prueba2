package tarea00;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio03 {

    public static void main(String[] args) {
        
        String carpetaSegundoDam = "C:\\Users\\Guille\\Documents\\acceso a datos\\Carpeta personal\\segundoDam";

        
        String nombreFichero = "alumnos.txt";

        
        File ficheroAlumnos = new File(carpetaSegundoDam, nombreFichero);

        
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce tus apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Introduce tu DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Introduce tu teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Introduce tu fecha de nacimiento: ");
        String fechaNacimiento = scanner.nextLine();

        
        StringBuilder contenido = new StringBuilder();
        contenido.append("Nombre: ").append(nombre).append("\n");
        contenido.append("Apellidos: ").append(apellidos).append("\n");
        contenido.append("DNI: ").append(dni).append("\n");
        contenido.append("Teléfono: ").append(telefono).append("\n");
        contenido.append("Fecha de Nacimiento: ").append(fechaNacimiento).append("\n");
        contenido.append("-------------------------------\n");

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroAlumnos, true))) {
            
            writer.write(contenido.toString());
            System.out.println(" datos  guardados en  fichero: " + ficheroAlumnos.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }

        
        scanner.close();
    }
}

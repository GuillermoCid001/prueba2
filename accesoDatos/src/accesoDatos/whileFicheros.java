package accesoDatos;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class whileFicheros {
	public static void main(String[] args) {
		int Salir = 0;
		int opcion = -1;
		String nombre;
		int contrasenha;
		String correo;
		
		 Scanner scanner = new Scanner(System.in);
		
		
		while (opcion != Salir) {
			System.out.println("Selecione una opción: 1. Fichero plano  2. Configuración  3. Xml  0.salir");
			
			opcion = scanner.nextInt();
		
		switch(opcion) {
        case 1:
            System.out.println("Has seleccionado Fichero Plano.");
            System.out.println("Introduzca nombre");
            nombre = scanner.next();
            System.out.println("Introduzca contrasenha");
            contrasenha = scanner.nextInt();
            System.out.println("Introduzca correo");
            correo = scanner.next();
            
            try {
                
                FileWriter writer = new FileWriter("c:\\eclipse\\prueba.txt");

                
                writer.write("Nombre: " + nombre + "\n");
                writer.write("Contraseña: " + contrasenha + "\n");
                writer.write("Correo: " + correo + "\n");

                
                writer.close();

                System.out.println("Fichero  generado correctamente.");

            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir en el archivo.");
                e.printStackTrace();
            }
           
            break;
        case 2:
            System.out.println("Has seleccionado Configuración.");

            
            System.out.println("Introduzca nombre:");
            nombre = scanner.next();
            System.out.println("Introduzca contraseña");
            contrasenha = scanner.nextInt(); 
            System.out.println("Introduzca correo:");
            correo = scanner.next();

            
            try {
                
                Properties props = new Properties();

                
                props.setProperty("nombre", nombre);
                props.setProperty("contrasenha", String.valueOf(contrasenha));
                props.setProperty("correo", correo);

                
                FileOutputStream out = new FileOutputStream("c:\\eclipse\\prueba.props");
                props.store(out, "Archivo de configuración");
                out.close();

                System.out.println("Fichero de configuración generado correctamente.");

            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir el archivo de configuración.");
                e.printStackTrace();
            }
            break;
        case 3:
            System.out.println("Has seleccionado XML.");

            
            System.out.println("Introduzca nombre:");
            nombre = scanner.next();
            System.out.println("Introduzca contraseña");
            contrasenha = scanner.nextInt(); 
            System.out.println("Introduzca correo:");
            correo = scanner.next();

            
            try {
                
                FileWriter writer = new FileWriter("c:\\eclipse\\prueba.xml");

               
                writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                writer.write("<usuario>\n");
                writer.write("    <nombre>" + nombre + "</nombre>\n");
                writer.write("    <contrasenha>" + contrasenha + "</contrasenha>\n");
                writer.write("    <correo>" + correo + "</correo>\n");
                writer.write("</usuario>\n");

               
                writer.close();

                System.out.println("Fichero XML generado correctamente.");

            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir el archivo XML.");
                e.printStackTrace();
            }
            break;
        case 0:
            System.out.println("Saliendo...");
            break;
        default:
            System.out.println("Opción no válida. Intente de nuevo.");
    }
}

		scanner.close();
	}

}
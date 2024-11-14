package directorios;

import java.io.File;
import java.io.IOException;

public class principal {
	public static void main(String[] args) {

	
		        String carpeta = "c:\\mayhen";
		        
		        
		        File directorio = new File(carpeta);

		       
		        if (directorio.exists()) {
		            System.out.println("El directorio ya existe: " + directorio.getAbsolutePath());
		        } else {
		            
		            if (directorio.mkdir()) {
		                System.out.println("Directorio creado exitosamente: " + directorio.getAbsolutePath());
		            } else {
		                System.out.println("No se pudo crear el directorio. Hubo un error.");
		            }
		}
		        File archivoTxt = new File(directorio, "proyecto21.txt");
		        File archivoCsv = new File(directorio, "proyecto22.csv");

		        try {
		            if (archivoTxt.createNewFile()) {
		                System.out.println("Archivo .txt creado exitosamente: " + archivoTxt.getAbsolutePath());
		            } else {
		                System.out.println("El archivo .txt ya existe.");
		            }

		            if (archivoCsv.createNewFile()) {
		                System.out.println("Archivo .csv creado exitosamente: " + archivoCsv.getAbsolutePath());
		            } else {
		                System.out.println("El archivo .csv ya existe.");
		            }

		        } catch (IOException e) {
		            System.out.println("Ocurrió un error al crear los archivos: " + e.getMessage());
		        }
		    }
	

}


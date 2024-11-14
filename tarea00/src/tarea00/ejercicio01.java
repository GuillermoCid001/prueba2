package tarea00;

import java.io.File;

public class ejercicio01 {

    public static void main(String[] args) {
        
        String carpetaPrincipal = "C:\\Users\\Guille\\Documents\\acceso a datos";

        
        String carpetaPersonal = "Carpeta personal";

        
        String carpetaPrimeroDam = "primeroDam";
        String carpetaSegundoDam = "segundoDam";

        
        File carpetaPersonalRuta = new File(carpetaPrincipal, carpetaPersonal);

       
        File carpetaPrimeroDamRuta = new File(carpetaPersonalRuta, carpetaPrimeroDam);

        
        File carpetaSegundoDamRuta = new File(carpetaPersonalRuta, carpetaSegundoDam);

        
        File practica1PrimeroDam = new File(carpetaPrimeroDamRuta, "practica1");
        File practica2PrimeroDam = new File(carpetaPrimeroDamRuta, "practica2");
        File practica3PrimeroDam = new File(carpetaPrimeroDamRuta, "practica3");

        
        File practica1SegundoDam = new File(carpetaSegundoDamRuta, "practica1");
        File practica2SegundoDam = new File(carpetaSegundoDamRuta, "practica2");
        File practica3SegundoDam = new File(carpetaSegundoDamRuta, "practica3");
        File practica4SegundoDam = new File(carpetaSegundoDamRuta, "practica4");

        

        
        if (carpetaPrimeroDamRuta.mkdirs()) {
            practica1PrimeroDam.mkdir();
            practica2PrimeroDam.mkdir();
            practica3PrimeroDam.mkdir();
            System.out.println("carpeta '" + carpetaPrimeroDam + "' y  subcarpetas  creadas.");
        } else {
            System.out.println(" carpeta '" + carpetaPrimeroDam + "' no creada o ya existe.");
        }

        
        if (carpetaSegundoDamRuta.mkdirs()) {
            practica1SegundoDam.mkdir();
            practica2SegundoDam.mkdir();
            practica3SegundoDam.mkdir();
            practica4SegundoDam.mkdir();
            System.out.println(" carpeta '" + carpetaSegundoDam + "' y subcarpetas creadas.");
        } else {
            System.out.println(" carpeta '" + carpetaSegundoDam + "' no creada o ya existe.");
        }
    }
}

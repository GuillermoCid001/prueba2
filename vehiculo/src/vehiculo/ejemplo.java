package vehiculo;
import java.util.Scanner;

public class ejemplo {

    public static void main(String[] args) {

        coche miCoche = new coche("ABC123", 100, 4);
        System.out.println("Información del coche:");
        System.out.println(miCoche);


        camion miCamion = new camion("XYZ789", 80);
        System.out.println("\nInformación del camión:");
        System.out.println(miCamion);

        try {
            System.out.println("\nIntentando acelerar el camión...");
            miCamion.acelerar(120);
            System.out.println("Velocidad después de acelerar: " + miCamion.getVelocidad() + " km/h");
        } catch (DemasiadoRapidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Remolque remolque = new Remolque(2000);
        miCamion.ponRemolque(remolque);
        System.out.println("\nInformación del camión con remolque:");
        System.out.println(miCamion);
        
        System.out.println("\nIngrese los datos de un nuevo vehículo:");
        vehiculo nuevoVehiculo = pedirDatosPorConsola();
        System.out.println("\nInformación del nuevo vehículo:");
        System.out.println(nuevoVehiculo);
    }

    public static vehiculo pedirDatosPorConsola() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la matrícula del vehículo:");
        String matricula = scanner.nextLine();
        
        System.out.println("Ingrese la velocidad del vehículo:");
        int velocidad = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.println("Ingrese el tipo de vehículo (coche/camion):");
        String tipoVehiculo = scanner.nextLine();
        
        if (tipoVehiculo.equalsIgnoreCase("coche")) {
            System.out.println("Ingrese el número de puertas del coche:");
            int numPuertas = scanner.nextInt();
            return new coche(matricula, velocidad, numPuertas);
        } else if (tipoVehiculo.equalsIgnoreCase("camion")) {
            return new camion(matricula, velocidad);
        } else {
            System.out.println("Tipo de vehículo desconocido. Creando un vehículo genérico.");
            return new vehiculo(matricula, velocidad);
        }
    }
}

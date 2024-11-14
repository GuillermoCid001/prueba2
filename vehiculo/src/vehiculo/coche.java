package vehiculo;

public class coche extends vehiculo {
    private int numPuertas;

    public coche(String matricula, int velocidad, int numPuertas) {
        super(matricula, velocidad);
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return super.toString() + "Matrícula: " + matricula + ", Velocidad: " + velocidad + " km/h, Número de puertas: " + numPuertas;
    }
    
    public static void main(String[] args) {
        coche miCoche = new coche("ABC123", 100, 4);
        System.out.println(miCoche);
    }
}

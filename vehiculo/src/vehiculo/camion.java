package vehiculo;

public class camion extends vehiculo {
    private Remolque remolque;

    public camion(String matricula, int velocidad) {
        super(matricula, velocidad);
        this.remolque = null;
    }    
    public void ponRemolque(Remolque remolque) {
        this.remolque = remolque;
    }
    
    public void quitaRemolque() {
        this.remolque = null;
    }
    
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public void acelerar(int incremento) throws DemasiadoRapidoException {
        if (remolque != null) {
            int nuevaVelocidad = velocidad + incremento;
            if (nuevaVelocidad > 100) {
                throw new DemasiadoRapidoException();
            }
        }
        super.acelerar(incremento);
    }
    
    @Override
    public String toString() {
        String infoRemolque = "";
        if (remolque != null) {
            infoRemolque = ", Remolque: " + remolque.toString();
        }
        return super.toString() + " Matrícula: " + matricula + ", Velocidad: " + velocidad + " km/h" + infoRemolque;
    }

    public static void main(String[] args) {
        camion miCamion = new camion("XYZ789", 80);
        
        System.out.println(miCamion);
    }
}

class Remolque {
    private int peso;

    public Remolque(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Peso: " + peso + " kg";
    }
}


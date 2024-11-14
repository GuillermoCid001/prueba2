package vehiculo;

public class DemasiadoRapidoException extends Exception {
    public DemasiadoRapidoException() {
        super("¡El camión está acelerando demasiado rápido!");
    }
}

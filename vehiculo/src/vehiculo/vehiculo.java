package vehiculo;

public class vehiculo {
	
	
    protected String matricula;
	protected int velocidad;

	public vehiculo(String matricula, int velocidad) {
        this.matricula = matricula;
        this.velocidad = velocidad;
    }
	    	

	    public void acelerar(int incremento) throws DemasiadoRapidoException {
	        
	        velocidad += incremento;
	    }

	    @Override
	    public String toString() {
	        return "";
	    }
	}

package aereopuerto;

public class Aeropuerto {

	int numeroTotales;
	String tipo;

	public Aeropuerto() {
		this.numeroTotales = 20;
	}

	public synchronized void despegar(String nombre, int id) {

		System.out.println("Llega a la pista " + nombre + " Thread " + id);
		System.out.println("=======================================================");
		System.out.println(
				"Aeroplano tipo: " + nombre + " con numero" + " Thread " + id + " entra en la pista de despegue...");
		System.out.println("=======================================================");

	}

}

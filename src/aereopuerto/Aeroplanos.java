package aereopuerto;

public class Aeroplanos extends Thread {
	String tipo;
	Aeropuerto a;
	int id;

	public Aeroplanos(Aeropuerto a, int id) {
		this.a = a;
		this.id = id;
		double num = Math.random(); // 50% de probabilidad para cada uno
		if (num < 0.5) {
			tipo = "Avioneta";
		} else {
			tipo = "Avion";
		}
	}

	public void zonaEspera() {
		System.out.println("Zona de espera para " + tipo + " con id: " + id);
		try {
			sleep((long) 2000);
		} catch (InterruptedException e) {
		}
		if (tipo.equals("Avion")) {
			System.out.println("El avion llega a la pista con id: " + getName());
			System.out.println("=======================================================");
			setPriority(MAX_PRIORITY);
			a.despegar(tipo, id);
			try {
				sleep((long) 3000);
			} catch (InterruptedException e) {
			}
		} else if (tipo.equals("Avioneta")) {
			setPriority(NORM_PRIORITY);
			System.out.println("La Avioneta llega a la pista con id: " + getName());
			System.out.println("=======================================================");

			a.despegar(tipo, id);
			try {
				sleep((long) 2000);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void run() {
		zonaEspera();
	}
}

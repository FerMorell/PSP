package comidaADomicilio;

public class Cocinero extends Thread {
	private String tipo;
	private Buffer buffer;
	private int totalHamburguesas = 0;
	private int totalPizzas = 0;

	public Cocinero(Buffer b, String tipo) {
		this.buffer = b;
		this.tipo = tipo;

	}

	public void preparacion() {

		while (true) {// el cocinero trabaja hasta que se cierre el restaurante
			if (!buffer.estaAbierto()) {
				System.out.println("SE PARA LA COCINA DE " + tipo.toUpperCase());
				break;
			}

			int tiempoPreparacion = tipo.equals("HAMBURGUESA") ? (int) (Math.random() * 200)
					: (int) (Math.random() * 300);
			try {
				System.out.println("Preparando una " + tipo + "...");
				sleep(tiempoPreparacion);

			} catch (InterruptedException e) {
				System.out.println("Se detiene la cocina de " + tipo);
				Thread.currentThread().interrupt();
				return;
			}

			if (tipo.equals("HAMBURGUESA")) {
				buffer.ponerHamburguesa();
				totalHamburguesas++;
			} else if (tipo.equals("PIZZA")) {
				buffer.ponerPizza();
				totalPizzas++;

			}

		}

	}

	public int getTotalHamburguesas() {
		return totalHamburguesas;
	}

	public int getTotalPizzas() {
		return totalPizzas;
	}

	@Override
	public void run() {
		preparacion();
	}

}

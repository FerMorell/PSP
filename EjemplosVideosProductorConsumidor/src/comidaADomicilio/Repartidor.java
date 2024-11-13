package comidaADomicilio;

public class Repartidor extends Thread {

	private Buffer buffer;
	private String nombre;
	private int repartos;
	private String tipo;
	private int repartosPizza;
	private int repartosHamburguesas;

	public Repartidor(Buffer b, String tipo, String nombre) {
		this.buffer = b;
		this.tipo = tipo;
		this.nombre = nombre;
	}

	public void repartir() {
		while (repartos < 15) {
			int tiempoReparto = (int) (Math.random() * 600);

			if (tipo.equals("HAMBURGUESA")) {
				buffer.recogerHamburguesa();
				repartos++;
				repartosHamburguesas++;
				System.out.println(nombre + " va a repartir hamburguesa. Quedan: " + buffer.getHamburguesa());
			} else if (tipo.equals("PIZZA")) {
				buffer.recogerPizza();
				repartosPizza++;
				repartos++;
				System.out.println(nombre + "va a repartir una pizza. Quedan " + buffer.getPizza());
			} else if (tipo.equals("AMBOS")) {
				// TENEMOS QUE PRIORIZAR HAMBURGUESAS

				if (buffer.getHamburguesa() > 0) {
					buffer.recogerHamburguesa();
					repartos++;
					repartosHamburguesas++;
					System.out.println(nombre + " va a repartir hamburguesa. Quedan: " + buffer.getHamburguesa());
				} else if (buffer.getPizza() > 0) {
					buffer.recogerPizza();
					repartos++;
					repartosPizza++;
					System.out.println(nombre + " va a repartir una pizza. Quedan " + buffer.getPizza());
				}

			}
			try {
				sleep(tiempoReparto);
			} catch (InterruptedException e) {

				Thread.currentThread().interrupt();
				return;
			}

		}
		System.out.println("===============================================================");
		System.out.println("El repartidor " + nombre + " ha completado su turno.");
		System.out.println("Total de pizzas entregadas:  " + repartosPizza);
		System.out.println("Total de hamburguesas entregadas:  " + repartosHamburguesas);
		System.out.println("===============================================================");

		buffer.repartidorTerminado();
	}

	@Override
	public void run() {
		repartir();

	}
}

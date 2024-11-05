package comidaADomicilio;

public class Buffer {
//	private ArrayList<String> hamburguesa;
//	private ArrayList<String> pizza;
	private int hamburguesa = 0;
	private int hamburguesasCocinadas = 0;
	private int pizzasCocinadas = 0;
	private int pizza = 0;
	private int espacioPizza = 2;
	private int espacioHamburguesa = 3;
	private int totalRepartidores;
	private boolean restauranteAbierto = true;// lo hago porque sino se quedaba en bucle
	// poner comida para repartidores
	private int repartidor = 0;
	private int repartosHamburguesas = 0;
	private int repartosPizza = 0;

	public synchronized void cerrrarRestaurante() {
		restauranteAbierto = false;
		System.out.println("Todos los repartidores han terminado.");
		notifyAll();// notificamos a todos los hilos que está cerrado
		System.out.println("===============================================================");
		System.out.println("Total de hamburguesas cocinadas: " + getHamburguesasCocinadas());
		System.out.println("Total de pizzas cocinadas: " + getPizzasCocinadas());
		System.out.println("===============================================================");
		System.out.println("Hamburguesas entregadas en total: " + repartosHamburguesas);
		System.out.println("Pizzas entregadas en total: " + repartosPizza);
		// Verificar si quedan en el horno
		System.out.println("===============================================================");
		System.out.println("Hamburguesas restantes en el horno: " + getHamburguesa());
		System.out.println("Pizzas restantes en el horno: " + getPizza());
		System.out.println("===============================================================");
	}

	public Buffer(int repartidores) {
		this.totalRepartidores = repartidores;
	}

	public synchronized void repartidorTerminado() {
		repartidor++;
		if (repartidor == totalRepartidores) {
			cerrrarRestaurante();
		}
	}

	public synchronized boolean estaAbierto() {
		return restauranteAbierto;
	}

	public synchronized void ponerHamburguesa() {

		while (hamburguesa >= espacioHamburguesa && restauranteAbierto) {
//			System.out.println("El lugar para poner hamburguesa esta lleno.");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (restauranteAbierto) {
			hamburguesa++;
			hamburguesasCocinadas++;
			System.out
					.println("Hamburguesa preparada para reparto. Hamburguesa Pendientes de entregar: " + hamburguesa);
			notifyAll();
		}

	}

	public int getHamburguesasCocinadas() {
		return hamburguesasCocinadas;
	}

	public int getPizzasCocinadas() {
		return pizzasCocinadas;
	}

	public synchronized void ponerPizza() {

		while (pizza >= espacioPizza && restauranteAbierto) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
		if (restauranteAbierto) {
			pizzasCocinadas++;
			pizza++;
			System.out.println("Pizza preaparada para reparto . Pizzas pendientes de entregar:  " + pizza);
			notifyAll();
		}

	}

	public synchronized void recogerHamburguesa() {

		while (hamburguesa <= 0 && restauranteAbierto) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
				return;
			}
		}
		if (hamburguesa > 0) {
			repartosHamburguesas++;
			hamburguesa--;
			System.out.println("Se han llevado una Hamburguesa ahora quedan: " + hamburguesa);
			notifyAll();

		}

	}

	public synchronized void recogerPizza() {

		while (pizza <= 0 && restauranteAbierto) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();

			}
		}
		if (pizza > 0) {
			repartosPizza++;
			pizza--;
			System.out.println("Se han llevado una pizza ahora quedan: " + pizza);
			notifyAll();
		}

	}

	public synchronized int getHamburguesa() {
		return hamburguesa;
	}

	public synchronized int getPizza() {
		return pizza;
	}

}

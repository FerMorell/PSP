package comida;

public class Restaurante {

	int espacioPizza = 2;
	int espacioHamburguesa = 3;
	int hamburguesas = 0;
	int pizzas = 0;
	int repartidores;
	int totalRepartidores;
	private boolean restauranteAbierto = true;

	public Restaurante(int repartidoresaTotal) {
		totalRepartidores = repartidoresaTotal;

	}

	public synchronized void repartidorTerminado() {
		repartidores++;
		if (repartidores == totalRepartidores) {
			cerrarRestaurante();
		}
	}

	private synchronized void cerrarRestaurante() {
		restauranteAbierto = false;
		notifyAll();
	}

	public synchronized void ponerHamburguesa() {

		if (hamburguesas >= espacioHamburguesa && restauranteAbierto) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (restauranteAbierto) {

			hamburguesas++;
			System.out
					.println("Hamburguesa preparada para reparto. Hamburguesa Pendientes de entregar: " + hamburguesas);
			notifyAll();
		}
	}

	public synchronized void quitarHamburguesa() {
		if (hamburguesas <= 0 && restauranteAbierto) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (hamburguesas > 0) {
			hamburguesas--;
			System.out.println("Se han llevado una Hamburguesa ahora quedan: " + hamburguesas);

			notifyAll();
		}
	}

	public int getHamburguesas() {
		return hamburguesas;
	}

	public int getPizzas() {
		return pizzas;
	}

	public synchronized void ponerPizza() {

		if (pizzas > espacioPizza && restauranteAbierto) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (restauranteAbierto) {

			pizzas++;
			System.out.println("Pizza preaparada para reparto . Pizzas pendientes de entregar:  " + pizzas);

			notifyAll();
		}
	}

	public synchronized void quitarPizza() {
		if (pizzas <= 0 && restauranteAbierto) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pizzas > 0) {

			pizzas--;
			System.out.println("Se han llevado una pizza ahora quedan: " + pizzas);

			notifyAll();
		}
	}

	public boolean restauranteAbierto() {
		return restauranteAbierto;
	}

}

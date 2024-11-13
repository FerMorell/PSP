package comida;

public class Repartidor extends Thread {

	private Restaurante r;
	private String nombre;
	private String tipo;
	int repartos = 0;
	int repartosPizza = 0;
	int repartosHamburguesas = 0;

	public Repartidor(Restaurante r, String nombre, String tipo) {
		super();
		this.r = r;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public void recoger() {

		while (repartos < 15) {
			int tiempoMimir = (int) (Math.random() * 600);
			if (tipo.equals("HAMBURGUESA")) {
				r.quitarHamburguesa();
				repartosHamburguesas++;
				repartos++;
			} else if (tipo.equals("PIZA")) {
				r.quitarPizza();
				repartosPizza++;
				repartos++;

			} else if (tipo.equals("AMBOS")) {
				if (r.getHamburguesas() > 0) {
					repartosHamburguesas++;
					r.quitarHamburguesa();
					repartos++;

				} else {
					repartosPizza++;
					r.quitarPizza();
					repartos++;

				}
			}
			try {
				sleep(tiempoMimir);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("===============================================================");
		System.out.println("El repartidor " + nombre + " ha completado su turno.");
		System.out.println("Total de pizzas entregadas:  " + repartosPizza);
		System.out.println("Total de hamburguesas entregadas:  " + repartosHamburguesas);
		System.out.println("===============================================================");

		r.repartidorTerminado();

	}

	@Override
	public void run() {
		recoger();
	}
}

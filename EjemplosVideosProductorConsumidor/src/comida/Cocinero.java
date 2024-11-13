package comida;

public class Cocinero extends Thread {
	private Restaurante r;
	private String tipo;

	public Cocinero(Restaurante r, String tipo) {
		this.r = r;
		this.tipo = tipo;

	}

	public void cocinar() {
		while (true) {
			if (!r.restauranteAbierto()) {
				System.out.println("SE HA PARADO LA COCINA " + tipo);
				break;
			}
			int tiempoCocina = tipo.equals("HAMBURGUESA") ? (int) (Math.random() * 200) : (int) (Math.random() * 300);

			try {
				System.out.println("Preparando una "+ tipo+" ...");
				sleep(tiempoCocina);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				Thread.currentThread().interrupt();
				return;
			}

			if (tipo.equals("HAMBURGUESA")) {
				r.ponerHamburguesa();
			} else {
				r.ponerPizza();
			}
		}
	}

	@Override
	public void run() {
		cocinar();
	}
}

public class Dispensador extends Thread {

	private String bola;
	private Comedero c;

	public Dispensador(Comedero comedero) {
		this.c = comedero;
	}

	public void ponerComida() {
		while (true) {
			if (!c.isGallinasComiendo()) {
				break;
			}
			int elegirAlmento = (int) (Math.random() * (3 - 1)) + 1;

			if (elegirAlmento <= 1) {
				bola = "MAIZ";
				c.ponerComida(bola);

			} else if (elegirAlmento >= 2) {
				bola = "TRIGO";
				c.ponerComida(bola);

			}
			int mimir = (int) (Math.random() * 100);
			try {
				sleep(mimir);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}

	@Override
	public void run() {
		ponerComida();
	}
}

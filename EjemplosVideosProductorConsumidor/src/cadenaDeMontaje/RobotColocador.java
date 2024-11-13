package cadenaDeMontaje;

public class RobotColocador extends Thread {

	private Buffer b;

	public RobotColocador(Buffer bu) {
		this.b = bu;

	}

	public void produciendo() {
		while (!Thread.currentThread().interrupted()) {
			int tipo = (int) (Math.random() * 3) + 1;

			System.out.println("Produciendo tipo " + tipo);
			int tiempoDormir = (int) (Math.random() * 250);
			try {
				sleep(tiempoDormir);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			b.colocar(tipo);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		produciendo();
	}
}

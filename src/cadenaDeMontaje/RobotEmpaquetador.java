package cadenaDeMontaje;

public class RobotEmpaquetador extends Thread {

	private int tipo;
	private Buffer b;

	public RobotEmpaquetador(int tipo, Buffer bu) {
		this.tipo = tipo;
		this.b = bu;
	}

	public void quitar() {
		while (!Thread.currentThread().interrupted()) {
			b.quitar(tipo);
			int tiempoDormir = (int) (Math.random() * 500);
			try {
				sleep(tiempoDormir);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	@Override
	public void run() {
		quitar();
	}

}

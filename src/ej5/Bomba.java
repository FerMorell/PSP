package ej5;

public class Bomba extends Thread {

	public void cuentaAtras() {
		try {
			for (int i = 9; i >= 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
			System.out.println("BOOOOOOOOOOOOOOM");

		} catch (InterruptedException e) {
			System.out.println("La bomba ha sido desactivada");
			
		}
	}

	@Override
	public void run() {
		cuentaAtras();
	}
}

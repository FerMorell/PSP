package ej5;

public class Artificiero extends Thread {

	public void desactivar() {
		System.out.println("El Artificiero empieza a desactivar la bomba : ");
		int tarda = (int) (Math.random() * (10000 - 9500) + 9500);
		try {
			Thread.sleep(tarda);
		} catch (InterruptedException e) {
			System.out.println("El Artificiero ha sido interrumpido. No pudo desactivar la bomba a tiempo.");
		return;
		}
		System.out.println("Ha desactivado la bomba y ha tardado: " + tarda);
	}
	@Override
	public void run() {
		desactivar();
	}
}

package ej4;

public class Corredor implements Runnable {
	private String equipo;
	private String nombre;

	public Corredor(String equipo, String nombre) {
		super();
		this.equipo = equipo;
		this.nombre = nombre;
	}

	public void relevos() {
		int tiempo=0;
		try {
			System.out.println(equipo + ": " + nombre + " comienza su relevo.");

			for (int i = 1; i <= 10; i++) {
				int tiempoPara10Metros = (int) (Math.random() * 101 + 950);
				tiempo+=tiempoPara10Metros;
				Thread.sleep(tiempoPara10Metros);
			}
			double enSec= tiempo/1000.0;
			System.out.println(equipo + ": " + nombre + " ha terminado su relevo en: "+ enSec);

		} catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {
		relevos();
	}

}

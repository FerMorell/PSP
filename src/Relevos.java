
public class Relevos implements Runnable {
	String nombre;
	String equipo;

	public Relevos(String nombre, String equipo) {
		super();
		this.nombre = nombre;
		this.equipo = equipo;
	}

	public void correr() {
		System.out.println(equipo + ":" + nombre + " comienza su relevo");
		int distancia = 100;
		int velocidad =  (int) (Math.random() * (1050-950+1)+950 );
		long tiempototal = (long) ((velocidad /distancia)*1000);
		try {
			Thread.sleep(tiempototal);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
		double tiempEnSec=tiempototal;
		System.out.println(equipo + ":" + nombre + " ha acabado su relevo- Ha tardado: " + tiempEnSec + " segundos");
	}

	@Override
	public void run() {
		correr();
	}
}

package ej3;

public class Relevos implements Runnable {
	private Corredor c;

	public Relevos(Corredor c) {
		super();
		this.c = c;
	}

	public void relevo() {
		System.out.println("El corredor: " + c.getNombre() + " del equipo: " + c.getEquipo() + " empieza a correr");
		int tiempoTotal = 0;
		
			int TiempoEnLosDiezMetros = (int) (Math.random() * (1050-950) +950 );
			tiempoTotal = TiempoEnLosDiezMetros*10;// vamos sumando el tiempo de los metros
			try {
				Thread.sleep( tiempoTotal);// Aqui esperamos que corra los 10 metros
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("El corredor " + c.getNombre() + " del equipo " + c.getEquipo()  + " ha completado " + (i * 10)
//					+ " metros.");
//ponemos i*10 porque el corredor tiene que correr 100m
		
		System.out.println(
				"El corredor " + c.getNombre() + " del equipo " + c.getEquipo() + " ha terminado su relevo" + " en "+ (double)tiempoTotal/1000);
	}

	@Override
	public void run() {
		relevo();
	}

}

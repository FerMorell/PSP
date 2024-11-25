package main;

import java.util.concurrent.Semaphore;

public class Playa {
	private Semaphore s;
	private Naufrago na;
	private int rescatados;

	public Playa(Semaphore sm, Naufrago n) {
		s = sm;
		na = n;
	}

	public synchronized void rescatar(int total, int id) {

		System.out.println("La barca " + id + " Llega a la placa a rescatarlo " + Thread.currentThread().getName());

		try {

			System.out.println("ESPERANDO semaforo barca:" + id + " con un tamaño de " + total);

			this.s.acquire();
			System.out.println("Hay un total de " + na.getTotal() + " naufragos");
			this.rescatados = na.getTotal() - total;
			System.out.println("Han rescatado " + total + " ahora quedan " + (na.getTotal() - total) + " naufragos");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Barca volviendose con los recogidos");
		s.release();
	}

}

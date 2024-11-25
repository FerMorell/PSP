package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Isla {

	public static void main(String[] args) {
		int numNaufragos = (int) (Math.random() * (1000 - 800) + 800);
		Naufrago n = new Naufrago(numNaufragos);
		Semaphore miSemaforo = new Semaphore(2);
		int tamaniob1 = (int) (Math.random() * (40 - 20) + 20);
		int tamaniob2 = (int) (Math.random() * (50 - 30) + 30);
		int tamaniob3 = (int) (Math.random() * (60 - 40) + 40);
		Playa p = new Playa(miSemaforo,n);
		Barca b1 = new Barca(1, tamaniob1, p);
		Barca b2 = new Barca(2,  tamaniob2, p);
		Barca b3 = new Barca(3, tamaniob3, p);
		ExecutorService e = Executors.newFixedThreadPool(3);
		while(n.haypelaos()) {
			e.submit(b1);
			e.submit(b2);
			e.submit(b3);
		}
		
		e.shutdown();
	}

}

package ej3;

public class Main {

	public static void main(String[] args) {

		Corredor c1 = new Corredor("Pepe", "España");
		Corredor c2 = new Corredor("Maria", "España");
		Corredor c3 = new Corredor("Marta", "España");

		Relevos r = new Relevos(c1);
		Relevos r2 = new Relevos(c2);
		Relevos r3 = new Relevos(c3);

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();

	}
}

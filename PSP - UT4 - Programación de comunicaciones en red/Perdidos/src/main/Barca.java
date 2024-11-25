package main;

public class Barca implements Runnable {
	private int tamaninototal;
	private Playa pa;
	private int id;

	public Barca(int id,  int tamanioT, Playa p) {
	
		tamaninototal = tamanioT;
		pa = p;
		this.id = id;
	}

	@Override
	public void run() {
		pa.rescatar(tamaninototal, id);
	}

}

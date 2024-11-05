package ej5;

public class Main {

	public static void main(String[] args) {
		Bomba b = new Bomba();
		Artificiero a = new Artificiero();

		b.start();
		a.start();

	do {}while(a.isAlive()&&b.isAlive());//mientras estan vivos no hacemos nada

			if (a.isAlive()==false) {
				b.interrupt();
			}else {	
				a.interrupt();
			}
		
	

	}
}

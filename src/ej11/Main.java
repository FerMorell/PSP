package ej11;

public class Main {

	public static void main(String[] args) {

		
		int numJugadores=6;
		Arbitro a = new Arbitro(numJugadores);
		
		for(int i=0;i <=numJugadores;i++) {
			Jugador j= new Jugador(i, a);
			j.start();
		}
		
	}

}

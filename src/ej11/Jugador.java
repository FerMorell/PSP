package ej11;

public class Jugador extends Thread {

	int idJugador;
	Arbitro a;

	public Jugador(int idJugador, Arbitro a) {

		this.idJugador = idJugador;
		this.a = a;
	}

	@Override
	public void run() {
		while(!a.terminado()) {
			this.yield();//Para que los hilos no sean egoístas , deje pasar al resto
			if (idJugador == a.getTurno()) {
				int numAleatorio=(int)(Math.random()*10) +1;
				a.jugada(idJugador, numAleatorio);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
}

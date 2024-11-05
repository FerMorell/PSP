package ej11;

public class Arbitro {
	int numAdivinar;
	int turno;
	int totalJugadores;
	boolean finalizado = false;

	public Arbitro(int totalJudores) {
		this.totalJugadores = totalJudores;
		this.turno = 1;
		this.numAdivinar = (int) (Math.random() * 10) + 1;
		System.out.println("EL NUMERO A ADIVINAR ES : " + numAdivinar);
	}

	public synchronized void jugada(int idJugador, int numero) {

		if (turno == idJugador) {
			System.out.println(" \033[35mEl jugador " + idJugador + " ha empezado a adivinar y su numero es: " + numero);

			if (numAdivinar == numero) {
				System.out.println(" \033[32mEl jugador " + idJugador + " gana, ha adivinado el numero!!");
				finalizado = true;
			}else {
				System.out.println("\033[31mEl jugador " + idJugador + " ha fallado el número, le toca al siguiente.");
				turno++;
				if (turno > totalJugadores) {
				    turno = 1;  // Regresa al primer jugador si te pasas del número total
				}
			}
			
		}
	}

	public int getTurno() {
		return turno;
	}

	public boolean terminado() {
		return finalizado;
	}
}

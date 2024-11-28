package objetosCliente;

import java.io.Serializable;

public class EstadoDelJuego implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ganadasDelServer;
	private int ganadasDelCliente;
	private String winner;
	private int jugadaServer;
	private int jugadaCliente;

	public EstadoDelJuego(int ganadasDelServer, int ganadasDelCliente, String winner, int jugadaServer,
			int jugadaCliente) {
		super();
		this.ganadasDelServer = ganadasDelServer;
		this.ganadasDelCliente = ganadasDelCliente;
		this.winner = winner;
		this.jugadaServer = jugadaServer;
		this.jugadaCliente = jugadaCliente;
	}

	public int getGanadasDelServer() {
		return ganadasDelServer;
	}

	public int getGanadasDelCliente() {
		return ganadasDelCliente;
	}

	public String getWinner() {
		return winner;
	}

	@Override
	public String toString() {
		return "Jugada Actual\n" + "Server=" + ganadasDelServer + "\nCliente=" + ganadasDelCliente + "\nGanador="
				+ winner;
	}

	public int getJugadaServer() {
		return jugadaServer;
	}

	public int getJugadaCliente() {
		return jugadaCliente;
	}
	
	
}

package mainServerHilo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Hilito implements Runnable {

	private final Socket s;
	private int serverpuntos;
	private int clientepuntos;

	public Hilito(Socket so) {
		s = so;

	}

	public void arrancarElAsunto() {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));) {

			bw.write("\033[33mHola jugador! :D :\u001B[0m \n");
			bw.flush();

			while (serverpuntos < 3 && clientepuntos < 3) {
				bw.write("\033[33mElige piedra, papel o tijera.\u001B[0m \n");
				bw.flush();

				String eleccionCliente = br.readLine().trim().toLowerCase();
				String eleccionserver = generarEleccion();
				
				if(!opcionInvalida(eleccionCliente)) {
					bw.write("\u001B[31mLa jugada que has puesto está mal\u001B[0m \n");
					bw.flush();
					continue;
				}
				
				
				String ganador = elegirGanador(eleccionCliente, eleccionserver);

				bw.write("\033[35mServidor juega " + eleccionserver + "\u001B[0m" + "\n");
				bw.write(ganador + "\n");
				bw.write(mostrarMarcador());
				bw.flush();
			}

			String ganadorFinal = clientepuntos == 3 ? "\033[33mMuy bien has ganado :D\u001B[0m \n"
					: "\033[35mQue triste has perdido D:, Ha ganado el Servidor >:D\u001B[0m";

			bw.write(ganadorFinal);

			bw.flush();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String elegirGanador(String eleccionCliente, String eleccionserver) {
		if (eleccionCliente.equals(eleccionserver)) {
			return "\033[34mEmpate\u001B[0m";
		}

		if ((eleccionCliente.equals("piedra") && eleccionserver.equals("tijera"))
				|| (eleccionCliente.equals("papel") && eleccionserver.equals("piedra"))
				|| (eleccionCliente.equals("tijera") && eleccionserver.equals("papel"))) {
			clientepuntos++;
			return "\033[33mGanaste esta ronda :D!\u001B[0m";
		}

		serverpuntos++;
		return "\033[35mServidor gana esta ronda D:.\u001B[0m";
	}

	private String generarEleccion() {
		int num = (int) (Math.random() * 3) + 1;

		if (num == 1) {
			return "tijera";
		} else if (num == 2) {
			return "piedra";
		} else {
			return "papel";
		}

	}

	public String mostrarMarcador() {
		return "Marcador:\n\033[33m-Cliente ->\u001B[0m " + clientepuntos + "\n\033[35m-Servidor->\u001B[0m"
				+ serverpuntos + "\n";
	}

	@Override
	public void run() {
		arrancarElAsunto();
	}

	private boolean opcionInvalida(String eleccion) {
		return eleccion.equals("piedra") || eleccion.equals("papel") || eleccion.equals("tijera");
	}
}
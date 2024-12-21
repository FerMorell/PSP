package mainEjercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		int puntaje1 = 0;
		String jugada1;
		String jugada2;
		int puntaje2 = 0;
		int puerto = 7773;
		try (ServerSocket server = new ServerSocket(puerto);) {

			System.out.println("El servidor se incia en el puerto: " + puerto);

			Socket socket1 = server.accept();
			System.out.println("\033[35mSe concecta el jugador 1\u001B[0m");
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
			BufferedWriter bwf = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
			Socket socket2 = server.accept();
			System.out.println("\033[33mSe concecta el jugador 2\u001B[0m");
			BufferedReader bf2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
			BufferedWriter bwf2 = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));

			while (puntaje1 < 3 && puntaje2 < 3) {
				bwf.write("\033[36mElige tu jugada: PIEDRA , PAPEL O TIJERA\u001B[0m\n");
				bwf.flush();
				jugada1 = bf.readLine().toLowerCase();

				bwf2.write("\033[36mElige tu jugada: PIEDRA , PAPEL O TIJERA\u001B[0m\n");
				bwf2.flush();
				jugada2 = bf2.readLine().toLowerCase();

				String determinar = elegirGanador(jugada1, jugada2);

				if (determinar.equals("\033[35mJugador 1 gana\u001B[0m\n")) {
				    puntaje1++;
				} else if (determinar.equals("\033[33mJugador 2 gana\u001B[0m\n")) {
				    puntaje2++;
				}
				bwf.write(determinar + "\033[35mEl jugador 1 va: \u001B[0m" + puntaje1 + " \033[33my el segundo\u001B[0m " + puntaje2 + "\n");
				bwf.flush();
				bwf2.write(determinar + "\033[33mEl jugador 2 va: \u001B[0m" + puntaje2 + " \033[35my el primero\u001B[0m " + puntaje1 + "\n");
				bwf2.flush();
			}
			String mensajeFinal = (puntaje1 == 3) ? "\033[35mHa ganado el jugador numero 1\u001B[0m" : "\033[33mHa ganado el jugador numero 2\u001B[0m";

			bwf.write(mensajeFinal + "\n");
			bwf.flush();

			bwf2.write(mensajeFinal + "\n");
			bwf2.flush();

			socket1.close();
			socket2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String elegirGanador(String pruebaEspacios, String pruebaEspacios2) {

		String a1 = pruebaEspacios.trim().toLowerCase();
		String b2 = pruebaEspacios2.trim().toLowerCase();

		if (!a1.matches("piedra|papel|tijera") || !b2.matches("piedra|papel|tijera")) {
			return "\033[31mNo has puesto una opcion válida D:'.\u001B[0m\n ";
		}
		if (a1.equals(b2)) {
			return "Empate\u001B[0m\n";
		}
		if ((a1.equals("piedra") && b2.equals("tijera")) || (a1.equals("papel") && b2.equals("piedra"))
				|| (a1.equals("tijera") && b2.equals("papel"))) {
			return "\033[35mJugador 1 gana\u001B[0m\n";
		}
		return "\033[33mJugador 2 gana\u001B[0m\n";
	}
}

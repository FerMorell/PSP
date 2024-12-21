package mainClienteEj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.net.Socket;

public class Cliente2 {

	private static final String nombreHost = "localhost";
	private static final int puerto = 7773;

	public static void main(String[] args) {

		try (Socket soc = new Socket(nombreHost, puerto);
				PrintWriter pin = new PrintWriter(soc.getOutputStream(), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in))) {

			String mensajeDelServidor;

			while ((mensajeDelServidor = br.readLine()) != null) {

				System.out.println(mensajeDelServidor);
				if (mensajeDelServidor.contains("Elige tu jugada")) {
					String eleccion = br2.readLine();
					pin.println(eleccion);
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

}

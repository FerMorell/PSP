package mainServerHilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		int puerto = 7777;

		try (ServerSocket sv = new ServerSocket(puerto);) {
			System.out.println("El servidor se incia en el puerto: " + puerto);

			while (true) {
				Socket so = sv.accept();
				System.out.println("Nuevo jugador se ha conectado :D");
				new Thread(new Hilito(so)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

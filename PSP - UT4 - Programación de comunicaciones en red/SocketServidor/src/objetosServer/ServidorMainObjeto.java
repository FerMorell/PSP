package objetosServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMainObjeto {
	public static void main(String[] args) {
		int puerto = 7777;
		int ganadasServer = 0;
		int ganadasCliente = 0;

		try (ServerSocket s = new ServerSocket(puerto);) {
			System.out.println("Esperando cliente....");
			Socket socket = s.accept();
			System.out.println("Cliente conectado :D");
			ObjectOutputStream obs = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream bis = new ObjectInputStream(socket.getInputStream());

			while (ganadasCliente < 3 && ganadasServer < 3) {
//				int x = (int) (Math.random() * 2);
//				String eleccionServer = x == 0 ? "PARES" : "IMPARES";
//				System.out.println("El juga: " + eleccionServer);
				String eleccionCliente = (String) bis.readObject();
				String eleccionServer = eleccionCliente.equals("PARES") ? "IMPARES" : "PARES";
				System.out.println("Juega " + eleccionServer);
				int numJuega = (int) (Math.random() * 60);
				System.out.println("JUEGA " + numJuega);
				int numCliente = bis.readInt();
				System.out.println("El cliente juega " + numCliente);

				int suma = numJuega + numCliente;
				boolean esPar = suma % 2 == 0;
				System.out.println("Suma " + suma + (esPar ? "PARES" : " IMPARES"));
//				String ganador;

				if ((eleccionCliente.equals("PARES") && esPar) || (eleccionCliente.equals("IMPARES") && !esPar)) {
					ganadasCliente++;
				} else {
					ganadasServer++;
				}
//				System.out.println(ganador);
				String ganadorDeRonda = (ganadasCliente > ganadasServer) ? "Cliente" : "Server";
				EstadoDelJuego est = new EstadoDelJuego(ganadasServer, ganadasCliente, ganadorDeRonda, numJuega,
						numCliente);
				obs.writeObject(est);
				obs.flush();
				System.out.println("Se ha enviado al cliente");
				if (ganadasCliente == 3 || ganadasServer == 3) {
					break;
				}
			}
			System.out.println("El juego ha terminado");
			if (ganadasServer == 3) {
				System.out.println("Ha ganado el servidor !!");

			} else {
				System.out.println("Ha ganado el cliente!!");
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

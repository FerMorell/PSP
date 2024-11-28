package objetosCliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteMainObjeto {
	public static void main(String[] args) {

		String host = "localhost";
		int puerto = 7777;

		try (Socket socket = new Socket(host, puerto);) {
			System.out.println("Me conecto al server");
			ObjectOutputStream bos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream bis = new ObjectInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);

			int estadoCliente = 0;
			int estadoServer = 0;

			while (estadoCliente < 3 && estadoServer < 3) {
				System.out.println("Elige: PARES O IMPARES");
				String eleccion= sc.nextLine().toUpperCase();
				bos.writeObject(eleccion);
				bos.flush();
				
				System.out.println("¿Dime un numero? ");
				int numero = Integer.parseInt(sc.nextLine());
				bos.writeInt(numero);
				bos.flush();

				EstadoDelJuego est = (EstadoDelJuego) bis.readObject();
				System.out.println(est);
				System.out.println("El servidor jugó : " + est.getJugadaServer());
				System.out.println("Y tu jugaste: " + est.getJugadaCliente());
				estadoCliente = est.getGanadasDelCliente();
				estadoServer = est.getGanadasDelServer();
				if (estadoServer == 3) {
					System.out.println("Ha ganado el server");
					break;
				} else if(estadoCliente==3) {
					System.out.println("Has ganado la partidaaaa");
					break;
				}
			}
			sc.close();
		} catch (IOException | ClassNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio2 {
	public static void main(String[] args) {
		int puerto = 7777;

		try (ServerSocket s = new ServerSocket(puerto)) {

			System.out.println("Esperando al Cliente");

			try (Socket cliente = s.accept();
					InputStream entrada = cliente.getInputStream();
					DataInputStream dis = new DataInputStream(entrada);
					OutputStream os = cliente.getOutputStream();
					DataOutputStream dos = new DataOutputStream(os);) {
				int leido = (int) Math.pow(dis.readInt(), 2);

				dos.writeInt(leido);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

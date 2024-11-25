package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio3 {
	public static void main(String[] args) {
		int puerto = 7779;

		try (ServerSocket s = new ServerSocket(puerto)) {

			System.out.println("Esperando al Cliente numero 1");

			try (Socket cliente = s.accept();
					DataInputStream dis = new DataInputStream(cliente.getInputStream());
					DataOutputStream dos = new DataOutputStream(cliente.getOutputStream())) {
				String leido = dis.readUTF();
				dos.writeUTF("\u001B[31m"+leido.toUpperCase());

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Esperando al Cliente numero 2");

			try (Socket cliente2 = s.accept();
					DataInputStream dis2 = new DataInputStream(cliente2.getInputStream());
					DataOutputStream dos2 = new DataOutputStream(cliente2.getOutputStream());) {
				String leido2 = dis2.readUTF();
				dos2.writeUTF("\u001B[36m"+leido2.toLowerCase());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.yield();
	}
}

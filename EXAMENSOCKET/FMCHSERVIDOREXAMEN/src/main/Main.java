package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {

		int puerto = 3203;

		System.out.println("Esperando al Cliente...");

		try (ServerSocket s = new ServerSocket(puerto);) {
			System.out.println("El servidor se incia en el puerto: " + puerto);
			try (Socket c = s.accept();
					InputStream is = c.getInputStream();
					DataInputStream dis = new DataInputStream(is);
					OutputStream os = c.getOutputStream();
					DataOutputStream dos = new DataOutputStream(os);) {

				System.out.println("\033[35mSe concecta el cliente\u001B[0m");

				int saldoCliente = 100;

				while (saldoCliente > 0 && saldoCliente<200) {
					int numGenerado = (int) (Math.random() * 36);
					dos.writeUTF("Ha salido: " + numGenerado);

					String eleccion = dis.readUTF();

					if (eleccion.equals("1")) {

						if (numGenerado <= 12 && numGenerado > 0) {
							dos.writeUTF("Has gando" + " Saldo: \n");
							saldoCliente += 40;

						} else {
							dos.writeUTF("Has perdido. Saldo: ");
							saldoCliente -= 20;

						}
					} else if (eleccion.equals("2")) {
						if (numGenerado <= 24 && numGenerado >= 13) {
							dos.writeUTF("Has gando" + " Saldo: \n");
							saldoCliente += 40;

						} else {
							dos.writeUTF("Has perdido. Saldo: " + "\n");
							dos.flush();
							saldoCliente -= 20;

						}
					} else if (eleccion.equals("3")) {
						if (numGenerado <= 36 && numGenerado >= 25) {
							dos.writeUTF("Has gando" + " Saldo: \n");
							saldoCliente += 40;

						} else {
							dos.writeUTF("Has perdido. Saldo: " + "\n");
							saldoCliente -= 20;

						}

					}

				}
				dos.writeUTF("Se ha acabado la partida: " + saldoCliente + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}

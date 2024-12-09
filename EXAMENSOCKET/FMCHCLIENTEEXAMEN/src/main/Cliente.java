package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {

		int saldoCliente = 100;
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 3203;

		try (Socket cliente = new Socket(host, puerto);
				DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
				DataInputStream dis = new DataInputStream(cliente.getInputStream())) {

			while (saldoCliente >= 0 && saldoCliente <200) {/* Mirar lo de 200$ */
				System.out.println("Tu saldo es de " + saldoCliente);
				System.out
						.println("Elige como quieras jugar \n1)1ªDocena(1-12) \n2)2ªDocena(13-24)\n3)3ªDocena(25-36)");
				String eleccion = sc.nextLine();
				dos.writeUTF(eleccion);

				String numsalido = dis.readUTF();
				String num = dis.readUTF();
				System.out.println(numsalido);
				System.out.println(num);
				if (num.contains("Has gando" + " Saldo: \n")) {
					saldoCliente += 40;
				} else if (num.contains("Has perdido. Saldo: ")) {
					saldoCliente -= 20;
				}
				if (saldoCliente == 200 || saldoCliente == 0) {
					dos.writeUTF("SE ACABO");
				}
				System.out.println(saldoCliente);
		

			}
			System.out.println(dis.readUTF());

//			String finalString = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();
	}
}

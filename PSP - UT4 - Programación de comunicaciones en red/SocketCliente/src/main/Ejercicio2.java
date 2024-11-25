package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {

		String host = "localhost";
		int puerto = 7777;
		Scanner sc = new Scanner(System.in);
		try (Socket cliente = new Socket(host, puerto);
				DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
				DataInputStream dis = new DataInputStream(cliente.getInputStream());) {
			System.out.println("Escribe el numero que quieras su cuadrado");
			int num= Integer.parseInt(sc.nextLine());
			dos.writeInt(num);
			System.out.println(dis.readInt());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();

	}
}

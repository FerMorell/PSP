package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {

		String host = "localhost";
		int puerto = 7777;
		Scanner sc = new Scanner(System.in);
		try (Socket cliente = new Socket(host, puerto);
				DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
				DataInputStream dis = new DataInputStream(cliente.getInputStream());) {
			System.out.println("Escribe la palabra que quieres que te devuelva el SV");
			String p = sc.nextLine().toLowerCase();
			dos.writeUTF(p);
			System.out.println(dis.readUTF());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}

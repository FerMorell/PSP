package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP1 {

	public static void main(String[] args) throws Exception {

		InetAddress destino = InetAddress.getLocalHost();
		int puerto = 7777;

		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe la palabra a pasar a mayus :");
		String palabra = sc.nextLine().toLowerCase();
		
		byte[] mensaje =   palabra.getBytes();
		
		DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, puerto);

		DatagramSocket socket = new DatagramSocket();
		
		socket.send(envio);

		byte[] recibido = new byte[1024];
		DatagramPacket recDatagramPacket = new DatagramPacket(recibido, recibido.length);
		socket.receive(recDatagramPacket);
		
		String resp= new String(recDatagramPacket.getData(),0, recDatagramPacket.getLength());
		
		System.out.println("\033[33m"+resp);
		
		socket.close();
		sc.close();
	}
}

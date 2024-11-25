package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP2 {
	public static void main(String[] args) throws Exception {
		InetAddress destino = InetAddress.getLocalHost();
		int puerto = 7779;

		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el número a elevar al cuadrado :");
		String numero = sc.nextLine();
		
		byte[] mensaje =   numero.getBytes();
		
		DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, puerto);

		DatagramSocket socket = new DatagramSocket();
		
		socket.send(envio);

		byte[] recibido = new byte[1024];
		DatagramPacket recDatagramPacket = new DatagramPacket(recibido, recibido.length);
		socket.receive(recDatagramPacket);
		
		String resp= new String(recDatagramPacket.getData(),0, recDatagramPacket.getLength());
		
		System.out.println(resp);
		
		socket.close();
		sc.close();
	}
}

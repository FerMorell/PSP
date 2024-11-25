package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.util.Scanner;

public class ClienteUDP3 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		InetAddress destino = InetAddress.getLocalHost();
		int puerto = 7772;
		System.out.println("-------------------------------------------");
		System.out.println("Introduce el nombre del fichero + la ruta :");
		String rutaConNombre = sc.nextLine();
		System.out.println("-------------------------------------------");

	
		byte[] mensaje = rutaConNombre.getBytes();

		DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, puerto);

		DatagramSocket socket = new DatagramSocket();

		socket.send(envio);

		byte[] recibido = new byte[1024];
		DatagramPacket recDatagramPacket = new DatagramPacket(recibido, recibido.length);
		socket.receive(recDatagramPacket);

		String resp = new String(recDatagramPacket.getData(), 0, recDatagramPacket.getLength());

		System.out.println(resp);

		socket.close();
		sc.close();

	}
}

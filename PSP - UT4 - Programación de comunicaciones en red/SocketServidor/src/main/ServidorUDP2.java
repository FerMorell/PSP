package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP2 {
	public static void main(String[] args) throws IOException {
		/*
		 * Ejercicio 2 Haz un programa que mediante un socket UDP reciba un número de un
		 * cliente, haga su cuadrado y se lo devuelva a quien se lo ha enviado. Haz un
		 * programa que pida por consola un número, se lo envíe al programa anterior y
		 * la respuesta la pinte por pantalla.
		 */
		byte[] buffer = new byte[1024];

		DatagramSocket socket = new DatagramSocket(7779);
		System.out.println("Esperando NUMERO CLIENTE.... ");

//Mensaje enviado por el cliente
		DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);

		socket.receive(recibido);
		// lo pasamos a String
		String palabra = new String(recibido.getData(), 0, recibido.getLength());
		int numero=(int) Math.pow(Integer.parseInt(palabra), 2);
		
		System.out.println("recibimos " + numero);
		String resp = String.valueOf(numero);
		InetAddress iporigen = recibido.getAddress();
		int puerto = recibido.getPort();

		byte[] respuestaEnviar = resp.getBytes();
		DatagramPacket envio = new DatagramPacket(respuestaEnviar, respuestaEnviar.length, iporigen, puerto);
		socket.send(envio);
		socket.close();
	}
}

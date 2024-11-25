package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP1 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		byte[] buffer = new byte[1024];
		
		DatagramSocket socket = new DatagramSocket(7777);
		System.out.println("Esperando.... ");
		
//Mensaje enviado por el cliente
		DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);

		socket.receive(recibido);
		// lo pasamos a String
		String palabra = new String(recibido.getData(),0 ,recibido.getLength());
		System.out.println("recibimos " + palabra);
		String resp= palabra.toUpperCase();
		InetAddress iporigen= recibido.getAddress();
		int puerto=recibido.getPort();
		
		byte[] respuestaEnviar= resp.getBytes();
		DatagramPacket envio= new DatagramPacket(respuestaEnviar,respuestaEnviar.length,iporigen ,puerto);
		socket.send(envio);
		socket.close();
	}
}

package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor3UDP {
	public static void main(String[] args) throws Exception {

		byte[] buffer = new byte[1024];
		DatagramSocket socket = new DatagramSocket(7772);
		System.out.println("Esperando datagrama.... ");
		DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);
		System.out.println("Recibido datagrama...");
		socket.receive(recibido);
		String ruta = new String(recibido.getData(), 0, recibido.getLength());
		System.out.println("Ruta: " + ruta);
		InetAddress iporigen = recibido.getAddress();
		int puerto = recibido.getPort();
		File f = new File(ruta);
		if (!f.exists()) {
			f.createNewFile();
		} else {
			System.out.println("Ya existe :O");
		}
		String paraFichero = "Leer fichero conseguido";
		try (FileWriter fl = new FileWriter(f); BufferedWriter bf = new BufferedWriter(fl);) {
			System.out.println("Leer fichero conseguido");
			bf.write(paraFichero);
		} catch (Exception e) {
		}

		String enviarCliente = "Contenido de fichero =>" + paraFichero;
		byte[] respuestaEnviar = enviarCliente.getBytes();
		DatagramPacket envio = new DatagramPacket(respuestaEnviar, respuestaEnviar.length, iporigen, puerto);
		System.out.println("Enviando Datagrama repuesta.......");
		try (FileReader fl = new FileReader(f); BufferedReader bf = new BufferedReader(fl);) {
			String linea;
			while ((linea = bf.readLine()) != null) {
				System.out.println("Fichero: " + linea);
			}
		} catch (Exception e) {
		}

		socket.send(envio);
		System.out.println("Cerrando conexion");
		socket.close();

	}
}

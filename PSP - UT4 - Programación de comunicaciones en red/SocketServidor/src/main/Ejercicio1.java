package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int puerto = 7777;
		ServerSocket s = new ServerSocket(puerto);
		Socket cliente = null;
		System.out.println("Esperando al Cliente");
		cliente = s.accept();

		InputStream entrada = cliente.getInputStream();
		DataInputStream dis = new DataInputStream(entrada);
		// leeremos la palabra que pondremos en mayus >:D
		String leido = dis.readUTF();
		OutputStream os = cliente.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("\u001B[31m"+leido.toUpperCase());

		dos.close();
		os.close();
		dis.close();
		entrada.close();
		cliente.close();
		s.close();
	}

}

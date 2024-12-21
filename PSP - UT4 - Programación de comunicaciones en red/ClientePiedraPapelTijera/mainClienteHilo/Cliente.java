package mainClienteHilo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 7777;
		Scanner sc = new Scanner(System.in);
		try (Socket s = new Socket(host, puerto);
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));) {

			System.out.println("siii nos hemos conectado >:D");

			String mensajeSv;

			while ((mensajeSv = br.readLine()) != null) {

				System.out.println(mensajeSv);

				if (mensajeSv.contains("Elige")) {
					String eleccion = sc.nextLine();
					bw.write(eleccion + "\n");
					bw.flush();
				}
			}
			System.out.println("Juego terminado D:");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
}

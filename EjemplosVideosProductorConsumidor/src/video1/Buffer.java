package video1;

import java.util.ArrayList;

public class Buffer {
//simularemos la cola

	private ArrayList<Recursos> buffer;// mirar queue o si lo puedo hacer con arraylis
	private int capacidad;

	public Buffer() {
		buffer = new ArrayList<Recursos>();
		capacidad = 4;
	}

	// las dos misiones importantes tiene que saber cuando se puede o no

	public synchronized void producir(Recursos rec) throws InterruptedException {

		while (buffer.size() == capacidad) {// Lo hemos hecho en while porque es una pregunta constante
			System.out.println("Estoy lleno, no puedo producir nada.");
			wait();// lo que pasa cuando estamos llenos nos bloqueamos
		}

		buffer.add(rec);// Cuando si puedo producir
		System.out.println("Has podido producir " + rec.getId());// notificamos a los demas que ya he producido
		notifyAll();// Notificamos que ya hay algo para consumir
	}

	public synchronized Recursos consumir() throws InterruptedException {// consumir es lo mismo pero al revez
		while (buffer.isEmpty()) {// mientras el buffer este vacio que espere no hay nada que consumir
			System.out.println("El buffer está vacio");
			wait();
		}

		Recursos rec = buffer.remove(0);

		System.out.println("Recurso consumido " + rec.getId());// notificamos a los demas que ya he producido
		notifyAll();// Notificamos que ya hay espacio para consumir
		return rec;
	}
}

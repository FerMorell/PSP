package cadenaDeMontaje;

import java.util.ArrayList;

public class Buffer {

	private ArrayList<Integer> productos;

	private final int tamanio = 3;

	private ArrayList<Integer> finaales;
	private int puestos = 0;
	private int uno = 0;
	private int dos = 0;
	private int tres = 0;

	public Buffer() {
		productos = new ArrayList<Integer>();

	}

	public synchronized void colocar(int producto) {
		while (productos.size() == tamanio) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
		if (producto == 1) {
			uno++;
		} else if (producto == 2) {
			dos++;
		} else {
			tres++;
		}
		puestos++;
		productos.add(producto);
		int posicion = productos.size() - 1;
		System.out.println("Coloco un producto " + producto + " en la posición " + posicion);

		System.out.println(productos);
		notifyAll();

	}

	public ArrayList<Integer> getFinaales() {
		finaales = new ArrayList<Integer>();
		finaales.add(uno);
		finaales.add(dos);
		finaales.add(tres);
		return finaales;
	}

	public int getPuestos() {
		return puestos;
	}

	public synchronized void imprimirProductos() {
		System.out.println("Productos en la cinta: " + productos);
	}

	public synchronized Integer quitar(int tipo) {

		while (productos.isEmpty() || !productos.contains(tipo)) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return null;
			}
		}
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i) == tipo) {
				int p = productos.remove(i);
				System.out.println("Recogido producto " + p);
				notifyAll();
				return p;
			}
		}
		return null;
	}
}

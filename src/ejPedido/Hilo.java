package ejPedido;

public class Hilo extends Thread {

	Contador c;

	public Hilo(Contador c) {
		this.c = c;
	}

	@Override
	public void run() {
		imprimir(c);
	}

	public void imprimir(Contador c) {

		for (int i = 0; i <= 5000; i++) {
			c.sumar();
		}
		System.out.println(c.getC() + " del hilo");
	}

}

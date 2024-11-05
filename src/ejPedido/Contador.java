package ejPedido;

public class Contador {

	public int c;


	public  void sumar() {
		 c++;
	}


	public int getC() {
		return c;
	}


	public synchronized void setC(int c) {
		this.c = c;
	}
}

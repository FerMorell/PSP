package ejPedido;

public class Main {

	public static void main(String[] args) {

		Contador c = new Contador();
		Hilo h= new Hilo(c);		
		Hilo h2= new Hilo(c);
		Hilo h3= new Hilo(c);
		Hilo h4= new Hilo(c);
		Hilo h5= new Hilo(c);
		
		h.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();


	}

}

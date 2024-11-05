package comidaADomicilio;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer b = new Buffer(4);
		Cocinero c1 = new Cocinero(b, "PIZZA");
		Cocinero c2 = new Cocinero(b, "HAMBURGUESA");

		Repartidor pizza = new Repartidor(b, "PIZZA", "Sara");
		Repartidor hamburguesa = new Repartidor(b, "HAMBURGUESA", "Pedro");
		Repartidor ambos1 = new Repartidor(b, "AMBOS", "Maria");
		Repartidor ambos2 = new Repartidor(b, "AMBOS", "Pepe");

		c1.start();
		c2.start();

		pizza.start();
		hamburguesa.start();
		ambos1.start();
		ambos2.start();
//		if (!b.estaAbierto()) {
//			c1.interrupt();
//			c2.interrupt();
//		}
	}

}

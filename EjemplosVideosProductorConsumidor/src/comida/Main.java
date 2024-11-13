package comida;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurante r = new Restaurante(4);

		Cocinero c1= new Cocinero(r, "HAMBURGUESA");
		Cocinero c2= new Cocinero(r, "PIZZA");
		
		Repartidor r1= new Repartidor(r, "Sara", "PIZZA");
		Repartidor r2= new Repartidor(r, "Amara", "HAMBURGUESA");
		Repartidor r3= new Repartidor(r, "Pepe", "AMBOS");
		Repartidor r4= new Repartidor(r, "Sara", "AMBOS");
		
		
		
		c1.start();
		c2.start();
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		
		
		
	}

}

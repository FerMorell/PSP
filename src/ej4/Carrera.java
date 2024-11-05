package ej4;

public class Carrera {

	private String equipo1;

	private String equipo2;

	public Carrera(String equipo1, String equipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	public void iniciarCarrera() throws InterruptedException {
		Thread corredorEspaniol1 = new Thread(new Corredor("España", "Pepe"));
		Thread corredorEspaniol2 = new Thread(new Corredor("España", "Caro"));
		Thread corredorEspaniol3 = new Thread(new Corredor("España", "Fer"));
		Thread corredorEspaniol4 = new Thread(new Corredor("España", "Rajoy"));

		Thread corredorEEUU1 = new Thread(new Corredor("EEUU", "Chris"));
		Thread corredorEEUU2 = new Thread(new Corredor("EEUU", "Annie"));
		Thread corredorEEUU3 = new Thread(new Corredor("EEUU", "Harry"));
		Thread corredorEEUU4 = new Thread(new Corredor("EEUU", "Peter"));

		corredorEspaniol1.start();
		corredorEEUU1.start();
		corredorEspaniol1.join();
		corredorEEUU1.join();
		corredorEspaniol2.start();
		corredorEEUU2.start();
		corredorEspaniol2.join();
		corredorEEUU2.join();
		corredorEspaniol3.start();
		corredorEEUU3.start();
		corredorEspaniol3.join();
		corredorEEUU3.join();
		corredorEspaniol4.start();
		corredorEEUU4.start();

		System.out.println("Fin del progrma de " + equipo1);

		System.out.println("Fin del programa de " + equipo2);

		System.out.println("Carrera terminada de " + equipo1 + " y " + equipo2);


		

	}
}

package video1;

public class Main {
	public static void main(String[] args) {

		Buffer buf = new Buffer();

		Productor p = new Productor(buf);

		Persona persona1 = new Persona(buf);
		Persona persona2 = new Persona(buf);
		Persona persona3 = new Persona(buf);
		Persona persona4 = new Persona(buf);
		Persona persona5 = new Persona(buf);

		Thread productor = new Thread(p);// atravez de este hilo estamos lanzando un productor
		Thread hilo1 = new Thread(persona1, "Unicornio");
		Thread hilo2 = new Thread(persona2, "Dragon");
		Thread hilo3 = new Thread(persona3, "Capibara");
		Thread hilo4 = new Thread(persona4, "Jirafa");
		Thread hilo5 = new Thread(persona5, "Narval");

		
		productor.start();
	
		hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
		
	}
}
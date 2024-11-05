
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comedero c = new Comedero();
		Dispensador d = new Dispensador(c);
		Animales a1 = new Animales(c, "CAPONTANA", "GALLINA");
		Animales a2 = new Animales(c, "TIRULETA", "GALLINA");
		Animales a3 = new Animales(c, "EL GALLO KIKO", "GALLO");

		d.start();
		a1.start();
		a2.start();
		a3.start();

	}

}

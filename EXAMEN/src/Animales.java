
public class Animales extends Thread {
	private Comedero c;
	private String nombre;
	private int totalComido;
	private String tipo;
	private int totalMaiz;
	private int totalTrigo;

	public Animales(Comedero comedero, String name, String tipo) {
		this.c = comedero;
		this.nombre = name;
		this.tipo = tipo;
	}

	public void comerÑam() {

		while (totalComido < 7 && c.isGallinasComiendo()) {
			if (c.getTotalMaiz() > 0) {
				System.out.println("La gallina o gallo " + nombre + " empieza a buscar maiz");
				int ñam = (int) (Math.random() * 200);
				try {
					sleep(ñam);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.comerMaiz(nombre);
				totalMaiz++;
			} else {
				System.out.println("La gallina o gallo " + nombre + " empieza a buscar trigo");
				int ñam = (int) (Math.random() * 200);
				try {
					sleep(ñam);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.comerTrigo(nombre);
				totalTrigo++;
			}
			totalComido++;

			int zzz = (int) (Math.random() * 500);
			try {
				sleep(zzz);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (totalComido == 5 && tipo.equals("GALLINA")) {
				break;
			}
		}
		System.out.println("================================================================================");
		System.out.println("TOTAL " + nombre + " ha comido " + totalMaiz + " dosis de maiz");
		System.out.println("TOTAL " + nombre + " ha comido " + totalTrigo + " dosis de trigo");
		System.out.println("================================================================================");
		c.terminaComer();
	}

	@Override
	public void run() {
		comerÑam();
	}
}

import java.util.ArrayList;

public class Comedero {

	private final int tamnioTotalComedero = 3;
	private ArrayList<Integer> totalEnComedero;
	private int totalTrigo = 0;
	private int totalMaiz = 0;
	private int totalMaizGallina = 0;
	private int totalTrigoGallina = 0;
	private ArrayList<Integer> recogidos;
	private boolean gallinasComiendo = true;
	private int gallinasEntotal = 3;
	private int gallinasTerminadas;
	private int recogidoMaiz = 0;
	private int recogidoTrigo = 0;
	private int totalDosis = 0;

	public Comedero() {
		totalEnComedero = new ArrayList<Integer>();
	}

	public synchronized void ponerComida(String tipoComida) {
		while (totalEnComedero.size() >= tamnioTotalComedero && isGallinasComiendo()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (isGallinasComiendo()) {
			int posicion;
			if (tipoComida.equals("TRIGO")) {
				totalTrigo++;
				totalEnComedero.add(totalTrigo);
				totalDosis++;
				posicion = totalEnComedero.size() - 1;
			} else {
				totalMaiz++;
				totalEnComedero.add(totalMaiz);
				totalDosis++;
				posicion = totalEnComedero.size() - 1;
			}
			System.out.println("El dispensador ha puesto una dosis de " + tipoComida + " en la posicion " + posicion);
			System.out.println(totalEnComedero);
			notifyAll();

		}

	}

	public synchronized void comerMaiz(String nombre) {

		while (totalEnComedero.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		recogidoMaiz++;

		for (int i = 0; i < totalEnComedero.size(); i++) {
			if (totalMaiz > 0) {
				totalEnComedero.remove(i);
				System.out.println("La gallina o gallo " + nombre + " ha comido una dosis de maiz");
				notifyAll();
			}

		}

	}

	public synchronized void comerTrigo(String nombre) {

		while (totalEnComedero.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		recogidoTrigo++;

		for (int i = 0; i < totalEnComedero.size(); i++) {
			if (totalTrigo > 0 && isGallinasComiendo()) {
				totalEnComedero.remove(i);
				System.out.println("La gallina o gallo " + nombre + " ha comido una dosis de trigo");
				notifyAll();

			}

		}

	}

	public ArrayList<Integer> getrecogidos() {
		recogidos = new ArrayList<Integer>();
		recogidos.add(recogidoMaiz);
		recogidos.add(recogidoTrigo);
		return recogidos;
	}

	public int getTotalMaizGallina() {
		return totalMaizGallina;
	}

	public int getTotalTrigoGallina() {
		return totalTrigoGallina;
	}

	public int getTotalTrigo() {
		return totalTrigo;
	}

	public int getTotalMaiz() {
		return totalMaiz;
	}

	public ArrayList<Integer> getTotalEnComedero() {
		return totalEnComedero;
	}

	public boolean isGallinasComiendo() {
		return gallinasComiendo;
	}

	public synchronized void terminaComer() {
		gallinasTerminadas++;
		if (gallinasTerminadas == gallinasEntotal) {
			cerrarComedero();
		}
	}

	private synchronized void cerrarComedero() {
		gallinasComiendo = false;
		System.out.println("Las gallinas han acabado de comer. PARAMOS EL DISPENSADOR");
		System.out.println("Quedan en las huecos del comedor: " + totalEnComedero);
		System.out.println("Total dosis que han caido en total: " + totalDosis);
		System.out.println("Recogidos por tipo: " + getrecogidos());
		notifyAll();
	}

}

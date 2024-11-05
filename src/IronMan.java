
public class IronMan extends Thread {

	private PersonasEj2 p;

	public IronMan(PersonasEj2 p) {
	
		this.p = p;
	}

	public  void bici() {
		System.out.println("El participante con nombre: " + p.getNombre() + " empieza la prueba de bici.");
		int distancia = 180;
		double tiempo =  (distancia / p.getVelocidadBici());
		try {
			Thread.sleep((long) (tiempo * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(p.getNombre() + " ha terminado de andar en bici. ");
	}

	public  void nadar() {
		System.out.println("El participante con nombre: " + p.getNombre() + " empieza la prueba de nadar.");
		int distancia = 4000;
		double tiempo = (int) (distancia / p.getVelocidadNadar());
		try {
			Thread.sleep((long) (tiempo * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(p.getNombre() + " ha terminado de nadar. ");
	}

	public  void marathon() {
		System.out.println("El participante con nombre: " + p.getNombre() + " empieza la prueba de correr.");
		int distancia = 42;
		double tiempo = (int) (distancia / p.getVelocidadCorrer());
		try {
			Thread.sleep((long) (tiempo * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(p.getNombre() + " ha terminado de nadar. ");

	}

	@Override
	public void run() {
		bici();
		marathon();
		nadar();
		System.out.println("IronMan terminado por el participante: "+p.getNombre());
		
	}
}

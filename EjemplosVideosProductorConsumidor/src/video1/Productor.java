package video1;

public class Productor extends Thread {

	private Buffer buffer;

	public Productor(Buffer b) {
		this.buffer = b;
	}

	@Override
	public void run() {
		// aqui empezara a generar productos

		try {
			for (int i = 0; i <= 10; i++) {
				Recursos r = new Recursos(i);
				buffer.producir(r);
				sleep(4000);
			}
		} catch (InterruptedException e) {
//			e.printStackTrace();
			currentThread().interrupt();//esto normalmente para interrumpir el hilo
		}
	}

}

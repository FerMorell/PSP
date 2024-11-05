
public class Reloj extends Thread {

	String palabra;

	public Reloj(String a) {
		palabra = a;
	}

	public void imprimir() {
//		while(true) {
		for (int i=0;i<50;i++) {
			
			try {
				sleep(100);//porque es un metodo estático
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(palabra);
		}
	}

	

	@Override
	public void run() {
		this.imprimir();
	}

}

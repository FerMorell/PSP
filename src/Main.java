
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reloj tic = new Reloj("TIC");
		Reloj tac = new Reloj("TAC");

		tic.start();
		try {
			tic.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tac.start();
		// con join decimos hasta que no acabe el siguiente no sigas
		// Lo que pasa es que el join espera hasta que el hilo termine para seguir con
		// el anterior
	}

}

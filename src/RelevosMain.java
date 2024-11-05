
public class RelevosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Relevos r = new Relevos("Pepe", "España");
		Relevos r2 = new Relevos("Maria", "España");
		Relevos r3 = new Relevos("Marta", "España");
		Relevos r4 = new Relevos("Juan", "España");

		Thread t = new Thread(r);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t4.start();
	}

}

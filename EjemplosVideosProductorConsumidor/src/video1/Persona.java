package video1;

public class Persona extends Thread{

	private Buffer buffer;
	
	
	public Persona(Buffer b) {
		// TODO Auto-generated constructor stub
	this.buffer=b;
	}
	
	@Override
	public void run() {
	try {
		buffer.consumir();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

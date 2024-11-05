package aereopuerto;


public class Main {

	public static void main(String[] args) {
		Aeropuerto ae= new Aeropuerto();	
			for(int i=0;i <5;i++) {
				Aeroplanos a= new Aeroplanos(ae,i);
				a.start();

			}
			
			
	}

}

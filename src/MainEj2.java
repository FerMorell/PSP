
public class MainEj2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonasEj2 p= new PersonasEj2("Pedro", 20,  6,1000);
		PersonasEj2 p2= new PersonasEj2("Vicente", 18, 7, 2000);
		PersonasEj2 p3= new PersonasEj2("Juan", 30, 6, 1000);
		IronMan i= new IronMan(p);
		IronMan i2= new IronMan(p2);
		IronMan i3= new IronMan(p3);
		
		i.start();
		i2.start();
		i3.start();

	}

}

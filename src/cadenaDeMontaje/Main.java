package cadenaDeMontaje;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Buffer b = new Buffer();

		RobotColocador r = new RobotColocador(b);
		RobotEmpaquetador r1 = new RobotEmpaquetador(1, b);
		RobotEmpaquetador r2 = new RobotEmpaquetador(2, b);
		RobotEmpaquetador r3 = new RobotEmpaquetador(3, b);

		r.start();

		r1.start();
		r2.start();
		r3.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.interrupt();

		r1.interrupt();
		r2.interrupt();
		r3.interrupt();
		System.out.println("Total de colocados: " + b.getPuestos());
		b.imprimirProductos();
		System.out.println("Recogidos por tipo: " + b.getFinaales());
	}

}

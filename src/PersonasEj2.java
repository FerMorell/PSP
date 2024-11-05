
public class PersonasEj2 {
	private String nombre;
	private double velocidadBici;
	private double velocidadNadar;
	private	double velocidadCorrer;

	public PersonasEj2(String nombre, double velocidadBici, double velocidadNadar, double velocidadCorrer) {
		super();
		this.nombre = nombre;
		this.velocidadBici = velocidadBici;
		this.velocidadNadar = velocidadNadar;
		this.velocidadCorrer = velocidadCorrer;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getVelocidadBici() {
		return velocidadBici;
	}

	public void setVelocidadBici(double velocidadBici) {
		this.velocidadBici = velocidadBici;
	}

	public double getVelocidadNadar() {
		return velocidadNadar;
	}

	public void setVelocidadNadar(double velocidadNadar) {
		this.velocidadNadar = velocidadNadar;
	}

	public double getVelocidadCorrer() {
		return velocidadCorrer;
	}

	public void setVelocidadCorrer(double velocidadCorrer) {
		this.velocidadCorrer = velocidadCorrer;
	}

}

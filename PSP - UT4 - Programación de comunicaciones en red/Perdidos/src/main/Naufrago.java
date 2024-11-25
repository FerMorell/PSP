package main;

public class Naufrago {

	private int total;

	public Naufrago(int total) {
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public boolean haypelaos() {
		if (total > 0) {
			return true;
		} else {
			return false;
		}
	}
}

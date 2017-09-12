package pkgCore;

public class Die {

	private int DieValue;

	public Die() {
		DieValue = (int) Math.random() * 6 + 1;
	}

	public int getDieValue() {
		return DieValue;
	}
}

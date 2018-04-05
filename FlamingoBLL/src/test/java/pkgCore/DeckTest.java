package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eSuit;

public class DeckTest {

	@Test
	public void TestDeck() {

		Deck d = new Deck();
		d.Draw();
		d.Draw();
		d.Draw();
		
	}

}

package pkgCore;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeckTest {

	@Test
	public void TestDeckSize() {

		
		int iExpectedSize = 52;
		
		Deck d = new Deck();
		int iActualSize = d.NbrOfCards();
		
		assertEquals(iExpectedSize,iActualSize);
		
		
		
		
	}

}

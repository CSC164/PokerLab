package pkgCore;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class DeckTest {

	@Test
	public void TestDeckSize_1() {

		
		int iExpectedSize = 52;
		
		Deck d = new Deck(1);
		int iActualSize = d.NbrOfCards();
		
		assertEquals(iExpectedSize,iActualSize);
		
	}
	
	@Test
	public void TestDeckSize_2() {

		
		int iExpectedSize = 52 * 6;
		
		Deck d = new Deck();
		int iActualSize = d.NbrOfCards();
		
		assertEquals(iExpectedSize,iActualSize);
		
	}	

	@Test
	public void TestDeckSize_3() {

		ArrayList<Card> WildCards = new ArrayList<Card>();
		WildCards.add(new Card(eSuit.CLUBS, eRank.TWO));
		WildCards.add(new Card(eSuit.DIAMONDS, eRank.TWO));
		WildCards.add(new Card(eSuit.HEARTS, eRank.TWO));
		WildCards.add(new Card(eSuit.SPADES, eRank.TWO));
		
		int iExpectedSize = 52;
		
		Deck d = new Deck(1, WildCards);
		int iActualSize = d.NbrOfCards();
		
		assertEquals(iExpectedSize,iActualSize);
		
		for (int a = 0; a<52; a++)
		{
			Card c = d.Draw();
			if (c.geteRank() == eRank.TWO)
			{
				if (!c.isWild())
				{
					fail("Two should be wild");
				}
			}
		}
		
	}	
	
}

package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void RoyalFlush_Test() {
		//	10-J-Q-K-A
	}
	
	@Test
	public void StraightFlush_Test1() {
	
		//	A-2-3-4-5
	}

	@Test
	public void StraightFlush_Test2() {
	
		//	2-3-4-5-6
	}
	@Test
	public void FourOfAKind_Test1() {
	
		//	A-A-A-A-2
	}
	@Test
	public void FourOfAKind_Test2() {
	
		//	2-2-2-2-A
	}

	@Test
	public void FullHouse_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FullHouse, hsp.geteHandStrength());
		assertEquals(eRank.TEN, hsp.getHiCard().geteRank());
		assertEquals(eRank.EIGHT, hsp.getLoCard().geteRank());
		assertTrue(hsp.getKickers().size() == 0);
		
		
	}
	
	@Test
	public void FullHouse_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FullHouse, hsp.geteHandStrength());
		assertEquals(eRank.EIGHT, hsp.getHiCard().geteRank());
		assertEquals(eRank.TEN, hsp.getLoCard().geteRank());
		assertTrue(hsp.getKickers().size() == 0);
		
		
	}
}

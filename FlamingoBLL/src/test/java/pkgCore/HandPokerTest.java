package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void AcesAndEights_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.SPADES, eRank.EIGHT));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.AcesAndEights, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertEquals(eRank.EIGHT, hsp.getLoCard().geteRank());
		assertTrue(hsp.getKickers().size() == 1);
		
		
	}
	@Test
	public void AcesAndEights_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.SPADES, eRank.EIGHT));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.AcesAndEights, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertEquals(eRank.EIGHT, hsp.getLoCard().geteRank());
		assertTrue(hsp.getKickers().size() == 1);
		
		
	}
	@Test
	public void RoyalFlush_Test() {
		
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.RoyalFlush, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertNull(hsp.getLoCard());
	}
	
	@Test
	public void RoyalFlush_Test_2() {
		
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.StraightFlush, hsp.geteHandStrength());
		assertEquals(eRank.FIVE, hsp.getHiCard().geteRank());
		assertNull(hsp.getLoCard());
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
	
	
	@Test
	public void Straight_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Straight, hsp.geteHandStrength());
		assertEquals(eRank.SIX, hsp.getHiCard().geteRank());
		assertNull(hsp.getLoCard());
		
		
	}
	
	@Test
	public void Straight_Test2()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Straight, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertNull(hsp.getLoCard());
		
		
	}
	
	
	@Test
	public void Straight_Test3()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Straight, hsp.geteHandStrength());
		assertEquals(eRank.FIVE, hsp.getHiCard().geteRank());
		assertNull(hsp.getLoCard());
	}
	
	@Test
	public void Straight_Test4()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertNull(hsp.getLoCard());
	}
	
	
	@Test
	public void Flush_Test1()
	{
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			fail("not enough cards in hand");
		}
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Flush, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertNull(hsp.getLoCard());
	}
}

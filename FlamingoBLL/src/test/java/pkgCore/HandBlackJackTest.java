package pkgCore;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandBlackJackTest {

	public HandScoreBlackJack HandHelper(ArrayList<Card> cards) {

		HandScoreBlackJack result = null;

		try {
			
			//	c = structure of class 'Hand'
			Class<?> c = Class.forName("pkgCore.HandBlackJack");

			//	the arguements for 'AddCard' is a instance of Card
			Class[] cArgsAddCard = new Class[1];
			cArgsAddCard[0] = pkgCore.Card.class;

			//	Create an instance of Hand
			Object inst = c.newInstance();

			//	Find the method 'AddCard' in Hand
			Method mAddCard = c.getDeclaredMethod("AddCardToHand", cArgsAddCard);
			
			//	Make the private method accessible 
			mAddCard.setAccessible(true);
			 
			//	Invoke the AddCard method for each card passed into this method
			for (Card card: cards)
			{
				mAddCard.invoke(inst, card);
			}
			
			//	Find the method 'ScoreHand' in 'Hand'
			Method mScore = c.getDeclaredMethod("ScoreHand", null);
			
			//	Invoke 'ScoreHand'.  It returns an array of integers
			result = (HandScoreBlackJack) mScore.invoke(inst, null);

			//	easy way to see each score.  not necessary.. but helps
			for (int i : result.getNumericScores()) {
				System.out.println(i);
			}

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void test1() {
		

		ArrayList<Card> cards = new ArrayList<Card>();
		
		
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		cards.add(new Card(eSuit.CLUBS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.FOUR));
		
		HandScoreBlackJack score = HandHelper(cards);
		
		assertEquals(9,score.getNumericScores().get(0).intValue());		
	}

	@Test
	public void test2() {
		

		ArrayList<Card> cards = new ArrayList<Card>();
		
		
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		
		HandScoreBlackJack score = HandHelper(cards);
		
		assertEquals(score.getNumericScores().size(),2);
		assertEquals(11,score.getNumericScores().get(0).intValue());		
		assertEquals(21,score.getNumericScores().get(1).intValue());
	}
	
	@Test
	public void test3() {
		

		ArrayList<Card> cards = new ArrayList<Card>();
		
		
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		
		HandScoreBlackJack score = HandHelper(cards);
		
		assertEquals(score.getNumericScores().size(),3);
		assertEquals(12,score.getNumericScores().get(0).intValue());		
		assertEquals(22,score.getNumericScores().get(1).intValue());
		assertEquals(32,score.getNumericScores().get(2).intValue());
	}
	
	@Test
	public void test4() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
				
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		
		HandScoreBlackJack score = HandHelper(cards);
		
		assertEquals(score.getNumericScores().size(),4);
		assertEquals(13,score.getNumericScores().get(0).intValue());		
		assertEquals(23,score.getNumericScores().get(1).intValue());
		assertEquals(33,score.getNumericScores().get(2).intValue());
		assertEquals(43,score.getNumericScores().get(3).intValue());
	}	
}

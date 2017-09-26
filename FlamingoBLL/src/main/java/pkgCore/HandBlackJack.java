package pkgCore;

import java.util.Collections;
import java.util.LinkedList;

public class HandBlackJack extends Hand {

	@Override
	public HandScore ScoreHand() {

		LinkedList<Integer> iScores = new LinkedList<Integer>();

		HandScoreBlackJack HS = new HandScoreBlackJack();
		Collections.sort(super.getCards());
		iScores.add(0);
		
		for (Card c : super.getCards()) {
			switch (c.geteRank()) {
			case TWO:
			case THREE:
			case FOUR:
			case FIVE:
			case SIX:
			case SEVEN:
			case EIGHT:
			case NINE:
			case TEN:
				ChangeScore(iScores,c.geteRank().getiRankNbr());
				break;
			case JACK:
			case QUEEN:
			case KING:
				ChangeScore(iScores,10);
				break;				
			case ACE:
				ChangeScore(iScores,1);				
				iScores.add(new Integer(iScores.getLast() + 10));
			}

		}
		
		HS.setNumericScores(iScores);

		super.setHS(HS);
		return HS;
	}
	
	private void ChangeScore(LinkedList<Integer> iScores, int iAddValue)
	{
		for (int i = 0; i < iScores.size(); i++)
		{
			int iValue = iScores.get(i) + iAddValue;
			iScores.set(i,iValue);
		}
	}
	
	private void AddCardToHand(Card c)
	{
		super.AddCard(c);
	}

	@Override
	protected HandScoreBlackJack getHS() {
		return (HandScoreBlackJack)super.getHS();
	}
	
	

}

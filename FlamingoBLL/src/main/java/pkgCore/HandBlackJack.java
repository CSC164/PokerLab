package pkgCore;

import java.util.Collections;
import java.util.LinkedList;

import pkgEnum.eRank;

public class HandBlackJack extends Hand {

	@Override
	public HandScore ScoreHand() {

		LinkedList<Integer> iScores = new LinkedList<Integer>();
		HandScoreBlackJack HS = new HandScoreBlackJack();
		Collections.sort(super.getCards());
		iScores.add(0);
		
		for (Card c : super.getCards()) {
			if (c.geteRank()== eRank.ACE)
			{
				ChangeScore(iScores,c.geteRank().getiCardValue());				
				iScores.add(new Integer(iScores.getLast() + c.geteRank().getiCardValueMax() -1 ));
			}
			else
			{
				ChangeScore(iScores,c.geteRank().getiCardValue());	
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

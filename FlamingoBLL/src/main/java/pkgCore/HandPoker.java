package pkgCore;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import pkgConstants.*;
import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.HandException;

public class HandPoker extends Hand {

	private ArrayList<CardRankCount> CRC = null;
	private HandScorePoker HSP;

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}

	public HandScorePoker getHSP() {
		return (HandScorePoker) this.getHS();

	}

	@Override
	public HandScore ScoreHand() throws Exception {

		Collections.sort(super.getCards());
		Frequency();
		HSP = new HandScorePoker();

		if (super.getCards().size() != 5) {
			throw new HandException("Not five cards", this);
		}
 
		try {
			Class<?> c = Class.forName("pkgCore.HandPoker");

			for (eHandStrength hstr : eHandStrength.values()) {
				Method meth = c.getDeclaredMethod(hstr.getEvalMethod(), null);
				meth.setAccessible(true);
				Object o = meth.invoke(this, null);

				// If o = true, that means the hand evaluated- skip the rest of
				// the evaluations
				if ((Boolean) o) {
					break;
				}
			}

			Method methGetHandScorePoker = c.getDeclaredMethod("getHSP", null);
			HSP = (HandScorePoker) methGetHandScorePoker.invoke(this, null);

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
		}

		return HSP;
	}

	//TODO: Finish this method
	private boolean isRoyalFlush() {
		boolean bIsRoyalFlush = false;

		if ((isFlush()) && (isStraight()) && (isAce()))

		{
			bIsRoyalFlush = true;
		}

		return bIsRoyalFlush;
	}

	//TODO: Finish this method
	private boolean isAce() {
		boolean bIsAce = false;

		if (super.getCards().get(0).geteRank() == eRank.ACE) {
			bIsAce = true;
		}

		return bIsAce;
	}

	//TODO: Finish this method
	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;

		if ((isFlush()) && (isStraight()))

		{
			bisStraightFlush = true;
		}

		return bisStraightFlush;
	}

	//TODO: Finish this method
	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;
		return bisFourOfAKind;
	}

	//TODO: Finish this method
	public boolean isFullHouse() {
		boolean bisFullHouse = false;

		if ((getCRC().size() == 2) && 
				(getCRC().get(0).getiCnt() == 3) &&
				(getCRC().get(1).getiCnt() == 2)) 
		{
			bisFullHouse = true;			
			HandScorePoker HS = getHSP();
			HS.seteHandStrength(eHandStrength.FullHouse);
			HS.setHiCard(getCards().get(getCRC().get(0).getiCardPosition()));
			HS.setLoCard(getCards().get(getCRC().get(1).getiCardPosition()));
			HS.setKickers(FindTheKickers(getCRC()));			
		}
		
		return bisFullHouse;

	}

	//TODO: Finish this method
	public boolean isFlush() {

		boolean bisFlush = false;
		int iCnt = 0;
		for (eSuit suit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (c.geteSuit() == suit) {
					iCnt++;
				}
			}

			switch (iCnt) {
			case 5:
				bisFlush = true;
				return bisFlush;
			case 0:
				break;
			default:
				bisFlush = false;
				return bisFlush;
			}
		}

		return bisFlush;
	}

	//TODO: Finish this method
	public boolean isStraight() {
		boolean bisStraight = false;
		
		//	A-2-3-4-5		
		//	2-3-4-5-6
		//	3-4-5-6-7
		//	10-J-Q-K-A
		
		//	I would use a loop....!  
		
		return bisStraight;
	}

	//TODO: Finish this method
	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;


		return bisThreeOfAKind;
	}

	//TODO: Finish this method
	
	public boolean isTwoPair() {
		boolean bisTwoPair = false;

		return bisTwoPair;
	}

	//TODO: Finish this method
	public boolean isPair() {
		boolean bisPair = false;

		
		return bisPair;
	}

	//TODO: Finish this method
	
	public boolean isHighCard() {
		boolean bisHighCard = false;

		return bisHighCard;
	}

	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC) {
		ArrayList<Card> kickers = new ArrayList<Card>();

		for (CardRankCount crcCheck : CRC) {
			if (crcCheck.getiCnt() == 1) {
				kickers.add(this.getCards().get(crcCheck.getiCardPosition()));
			}
		}

		return kickers;
	}

	private void Frequency() {
		CRC = new ArrayList<CardRankCount>();
		int iCnt = 0;
		int iPos = 0;
		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
			}
		}
		Collections.sort(CRC);
	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRank() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRank() == eRank) {
				break;
			}
		}
		return iPos;
	}

}

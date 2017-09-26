package pkgCore;

public class HandPoker extends Hand {

	
	public HandPoker()
	{
		this.setHS(new HandScorePoker());
	}
	
	@Override
	public HandScore ScoreHand() {
		return null;
	}
	
	public boolean isRoyalFlush()
	{
		boolean bIsRoyalFlush = false;
		return bIsRoyalFlush;
	}
	public boolean isStraightFlush()
	{
		boolean bisStraightFlush = false;
		return bisStraightFlush;
	}
	public boolean isFourOfAKind()
	{
		boolean bisFourOfAKind = false;
		return bisFourOfAKind;
	}
	public boolean isFullHouse()
	{
		boolean bisFullHouse = false;
		return bisFullHouse;
	}
	public boolean isFlush()
	{
		boolean bisFlush = false;
		return bisFlush;
	}

	public boolean isStraight()
	{
		boolean bisStraight = false;
		return bisStraight;
	}
	public boolean isThreeOfAKind()
	{
		boolean bisThreeOfAKind = false;
		return bisThreeOfAKind;
	}
	public boolean isTwoPair()
	{
		boolean bisTwoPair = false;
		return bisTwoPair;
	}
	public boolean isPair()
	{
		boolean bisPair = false;
		return bisPair;
	}
	public boolean isHighCard()
	{
		boolean bisHighCard = false;
		return bisHighCard;
	}	
	
}

package pkgCore;

public class HandPoker extends Hand {

	
	public HandPoker()
	{
		this.setHS(new HandScorePoker());
	}
	
	@Override
	public HandScore ScoreHand() {
		//TODO : Implement this method...  call each of the 'is' methods (isRoyalFlush, etc) until
		//		one of the hands is true, then score the hand
		return null;
	}
	
	public boolean isRoyalFlush()
	{
		boolean bIsRoyalFlush = false;
		//TODO : Implement this method
		return bIsRoyalFlush;
	}
	public boolean isStraightFlush()
	{
		boolean bisStraightFlush = false;
		//TODO : Implement this method
		return bisStraightFlush;
	}
	public boolean isFourOfAKind()
	{
		boolean bisFourOfAKind = false;
		//TODO : Implement this method
		return bisFourOfAKind;
	}
	public boolean isFullHouse()
	{
		boolean bisFullHouse = false;
		//TODO : Implement this method
		return bisFullHouse;
	}
	public boolean isFlush()
	{
		boolean bisFlush = false;
		//TODO : Implement this method
		return bisFlush;
	}

	public boolean isStraight()
	{
		boolean bisStraight = false;
		//TODO : Implement this method
		return bisStraight;
	}
	public boolean isThreeOfAKind()
	{
		boolean bisThreeOfAKind = false;
		//TODO : Implement this method
		return bisThreeOfAKind;
	}
	public boolean isTwoPair()
	{
		boolean bisTwoPair = false;
		//TODO : Implement this method
		return bisTwoPair;
	}
	public boolean isPair()
	{
		boolean bisPair = false;
		//TODO : Implement this method
		return bisPair;
	}
	public boolean isHighCard()
	{
		boolean bisHighCard = false;
		//TODO : Implement this method
		return bisHighCard;
	}	
	
}

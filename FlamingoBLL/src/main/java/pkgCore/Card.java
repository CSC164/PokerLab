package pkgCore;
import pkgEnum.*;
public class Card implements Comparable {

	private eSuit eSuit;
	private eRank eRank;
	

	public Card(eSuit eSuit, eRank eRank) {
		this.eSuit = eSuit;
		this.eRank = eRank;
	}


	//	TODO: Card has two attributes, eRank and eSuit, add these attributes
	
	
	//	TODO: Build a constructor for Card passing in eRank and eSuit
	
	
	//	TODO: Add a public 'getter' method for eRank and eSuit.  
	//			Add a private 'setter' method for eRank and eSuit
	
	@Override
	public int compareTo(Object o) {
		Card c = (Card) o;
		return 0;
		//return c.geteRank().compareTo(this.geteRank());

}
	
}

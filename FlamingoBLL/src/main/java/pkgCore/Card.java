package pkgCore;

import pkgEnum.*;

public class Card implements Comparable {

	private eSuit eSuit;
	private eRank eRank;
	private boolean isWild = false;

	public Card(pkgEnum.eSuit eSuit, pkgEnum.eRank eRank) {
		super();
		this.eSuit = eSuit;
		this.eRank = eRank;
	}
	
	public Card(pkgEnum.eSuit eSuit, pkgEnum.eRank eRank, boolean isWild) {
		super();
		this.eSuit = eSuit;
		this.eRank = eRank;
		this.isWild = isWild;
	}	

	public eRank geteRank() {
		return eRank;
	}

	public eSuit geteSuit() {
		return eSuit;
	}

	private void seteSuit(eSuit eSuit) {
		this.eSuit = eSuit;
	}

	private void seteRank(eRank eRank) {
		this.eRank = eRank;
	}

	public boolean isWild() {
		return isWild;
	}


	 void setWild(boolean isWild) {
		this.isWild = isWild;
	}

	@Override
	public int compareTo(Object o) {
		Card c = (Card) o;		
		return c.geteRank().compareTo(this.geteRank());
	} 
}

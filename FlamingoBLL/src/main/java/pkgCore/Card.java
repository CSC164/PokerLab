package pkgCore;

import pkgEnum.*;

public class Card implements Comparable {

	private eSuit eSuit;
	private eRank eRank;

	public Card(pkgEnum.eSuit eSuit, pkgEnum.eRank eRank) {
		super();
		this.eSuit = eSuit;
		this.eRank = eRank;
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

	@Override
	public int compareTo(Object o) {
		Card c = (Card) o;
		return this.geteRank().compareTo(c.geteRank());
	}
}

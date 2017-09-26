package pkgCore;

import java.util.ArrayList;
import pkgEnum.eHandStrength;

public class HandScorePoker extends HandScore {
	private eHandStrength eHandStrength;
	private Card HiCard;
	private Card LoCard;
	private ArrayList<Card> kickers = new ArrayList<Card>();

	
	protected eHandStrength geteHandStrength() {
		return eHandStrength;
	}
	protected void seteHandStrength(eHandStrength eHandStrength) {
		this.eHandStrength = eHandStrength;
	}
	protected Card getHiCard() {
		return HiCard;
	}
	protected void setHiCard(Card hiCard) {
		HiCard = hiCard;
	}
	protected Card getLoCard() {
		return LoCard;
	}
	protected void setLoCard(Card loCard) {
		LoCard = loCard;
	}
	protected ArrayList<Card> getKickers() {
		return kickers;
	}
	protected void setKickers(ArrayList<Card> kickers) {
		this.kickers = kickers;
	}
}

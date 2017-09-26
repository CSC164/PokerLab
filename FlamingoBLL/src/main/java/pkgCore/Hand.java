package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Hand {

	private ArrayList<Card> cards;
	private HandScore HS;

	public Hand() {
		cards = new ArrayList<Card>();
	}

	protected ArrayList<Card> getCards() {
		return cards;
	}

	public void Draw(Deck d) {
		cards.add(d.Draw());
	}
	
	protected HandScore getHS() {
		return HS;
	}

	protected void setHS(HandScore hS) {
		HS = hS;
	}

	public abstract HandScore ScoreHand();

	protected void AddCard(Card c) {
		cards.add(c);
	}
	

}

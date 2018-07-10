package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	private static int iNbrOfDecks = 6;

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck(int iNbrOfDecks) {
		this(iNbrOfDecks, null);
		
	}

	public Deck() {
		this(iNbrOfDecks, null);
	}
	
	public Deck(int iNbrOfDecks, ArrayList<Card> WildCards)
	{
		if (WildCards == null)
			WildCards = new ArrayList<Card>();
		
		for (int a = 0; a < iNbrOfDecks; a++) {

			for (eSuit eSuit : eSuit.values()) {
				for (eRank eRank : eRank.values()) {
					Card c = new Card(eSuit, eRank);
					
					boolean b = 
							WildCards.stream().
							filter(x -> x.geteRank() == c.geteRank()).
							filter(y -> y.geteSuit() == c.geteSuit()).count() > 0;
					c.setWild(b);
					
					cardsInDeck.add(c);
				}
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() {
		return cardsInDeck.remove(0);
	}

	public int NbrOfCards() {
		return cardsInDeck.size();
	}
}

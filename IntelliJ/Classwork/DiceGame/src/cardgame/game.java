package cardgame;

public class game {
	public static void main(String[] args) {
		cardDeck playingDeck = new cardDeck();
		playingDeck.newDeck();
		playingDeck.examineDeck();
		playingDeck.shuffleDeck();
//		playingDeck.examineDeck();
		playingDeck.dealCards(5);
		playingDeck.dealCards(50);
	}
}


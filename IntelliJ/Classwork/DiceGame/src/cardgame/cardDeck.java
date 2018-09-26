package cardgame;


import java.util.ArrayList;
import java.util.Collections;

public class cardDeck {
	public static final int NCARDS = 52;
	public static int currentCard = 0;
	protected Card[] cards = new Card[NCARDS];
	ArrayList<Card> newCardDeck = new ArrayList<Card>();

	public void cardDeck() {
		newDeck();
	}

	public void newDeck() {
		int cardCount = 0;
		for (char suit = 0; suit < 4; suit++) {
			for (int num = 2; num < 15; num++) {
//				Card newCard = new Card(suit, num);
				Card newCard = new Card(suit, num); //Can also be done inline
				newCardDeck.add(newCard); //ArrayList implementation
				newCard.setNumber(num);
				switch (suit) {
					case 0: //Set Spades
						newCard.setSuit('S');
						break;
					case 1: //Set Hearts
						newCard.setSuit('H');
						break;
					case 2: //Set Clubs
						newCard.setSuit('C');
						break;
					case 3: //Set Diamonds
						newCard.setSuit('D');
						break;
				}
//				newCard.setName();
//				cards[cardCount] = newCard;
//				cardCount += 1;
//				Use ArrayList instead of simple array


			}
		}
	}

	public void shuffleDeck() {
		Collections.shuffle(newCardDeck);

	}

	public void examineDeck() {
		System.out.println("There are " + NCARDS + " in the deck.\n");
		for (int i = 0; i < NCARDS; i++) {
			System.out.println("Card at position " + (i) + " is " + newCardDeck.get(i).getName());


		}
		System.out.println();
	}

	public Card getCard(int position) {
		return newCardDeck.get(position);
	}

	public void dealCards(int count) {
		System.out.println("The next card in the deck is: " + newCardDeck.get(currentCard).getName() + "\n");
		if (currentCard + count > NCARDS) {
			System.out.println("There are not enough cards in the deck to meet the request");
		} else {
			for (int i = 0; i < count; i++) {
				System.out.println("Dealing Card: " + newCardDeck.get(currentCard + i).getName());
				currentCard++;
			}
		}
	}
}



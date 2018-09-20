package cardgame;

public class Deck {
	public static void shuffleDeck(){};

	public static void createDeck() {
		for (char suit = 0; suit < 4; suit++) {
			for (int num = 2; num < 15; num++) {
				Card newCard = new Card(suit, num);

//				newCard.setNumber(num);
//				switch (suit) {
//					case 0: //Set Spades
//						newCard.setSuit('S');
//						break;
//					case 1: //Set Hearts
//						newCard.setSuit('H');
//						break;
//					case 2: //Set Clubs
//						newCard.setSuit('C');
//						break;
//					case 3: //Set Diamonds
//						newCard.setSuit('D');
//						break;
				}

			}
		}
	}



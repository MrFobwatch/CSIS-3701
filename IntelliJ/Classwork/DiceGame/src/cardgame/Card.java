package cardgame;

public class Card {
	protected int cardNumber;
	protected char name;
	protected char suit;
	protected Boolean cardPulled;

	public Card(char Suit, int Number) {
		cardPulled = false;
		setSuit(Suit);
		setNumber(Number);
		name = setName();

	}


	public char setName() {
		int Number = cardNumber;
		if (Number >= 10) {
			if (Number == 10) {
				name = ('T');
			} else if (Number == 11) {
				name = ('J');
			} else if (Number == 12) {
				name = ('Q');
			} else if (Number == 13) {
				name = ('K');
			} else if (Number == 14) {
				name = ('A');
			}
			return name;
		} else {
			return (char)(Number + '0');
		}

	}


	public void setSuit(char suit) {
		this.suit = suit;
	}

	public void setNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void printName(){
		System.out.println(this.name + " of " + this.suit);

	}

	public String getName(){
		return this.name + " of " + this.suit;
	}
}
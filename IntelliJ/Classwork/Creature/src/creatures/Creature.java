package creatures;

public class Creature {
	private static int FOOD = 4;
	private static int FUN = 3;
	private String name;
	private int hunger;
	private int boredom;

	public Creature(String name) {
		this.name = name;
		hunger = 0;
		boredom = 0;
	}

	public String getName() {
		return name;
	}

	public void feed() {
		hunger -= FOOD;
		if (hunger < 0) {
			hunger = 0;
		}
		timePass();
	}

	public void timePass() {
		hunger++;
		boredom++;
	}

	public void play() {
		boredom -= FUN;
		if (boredom < 0) {
			boredom = 0;
		}
		timePass();
	}

	public String getMood() {
		int unhappiness = hunger + boredom;

		if (unhappiness < 5) {
			return "happy";
		}
		if (unhappiness < 10) {
			return "okay";
		}
		if (unhappiness < 15) {
			return "frustrated";
		}
		return "mad";
	}
}




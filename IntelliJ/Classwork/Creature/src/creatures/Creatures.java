package creatures;

public class Creatures {
	public static void main(String[] args) {
		Creature c1 = new Creature("Pluto");
		System.out.println(c1.getName());

		System.out.println(c1.getMood());

		c1.timePass();
		c1.timePass();
		c1.timePass();
		c1.timePass();

		System.out.println(c1.getMood());

		c1.timePass();
		c1.timePass();
		c1.timePass();
		c1.timePass();

		System.out.println(c1.getMood());

		c1.feed();
		c1.feed();
//		c1.feed();
//		c1.feed();
		c1.play();
		c1.play();

		System.out.println(c1.getMood());

	}
}

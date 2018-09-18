package circledemo;

public class Sphere extends Circle {
	/**
	 * The Sphere class with radius r
	 *
	 * @param r The radius
	 */

	public Sphere(int r) {
		super(r);
	}

	/**
	 * Gets the Volume of the Sphere
	 * @return the volume of a sphere
	 */
	public double getVolume() {
		return Math.PI * Math.pow(radius, 3) * 4 / 3;
	}

	/**
	 * gets the Surface Area of the Sphere
	 * @return the surface area of a sphere
	 */

	public double getArea() {
		return Math.PI * Math.pow(radius, 2) * 4;
	}

}

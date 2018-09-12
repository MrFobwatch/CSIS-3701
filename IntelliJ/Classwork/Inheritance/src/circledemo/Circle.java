package circledemo;

public class Circle {
	protected int radius;

	public Circle(int r) {
		radius = r;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int r) {
		radius = r;
	}

	public int getDiameter() {
		return radius * 2;
	}

	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}

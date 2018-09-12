package circledemo;

public class Cylinder extends Circle {
	protected int height;

	public Cylinder(int r, int h) {
		super(r);
		height = h;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int h) {
		height = h;
	}

	public double getVolume() {
		return getArea() * height;
	}
}


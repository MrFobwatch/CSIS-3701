package circledemo;

public class CircleDemo {
	public static void main(String[] args) {
		Cylinder myCylinder = new Cylinder(4, 4);
		Sphere mySphere = new Sphere(6);
//		System.out.println("The height is: " + myCylinder.getHeight());
//		System.out.println("The volume is: " + myCylinder.getVolume());

		System.out.println("The volume is: " + mySphere.getVolume());
		System.out.println("The area is: " + mySphere.getArea());
	}
}

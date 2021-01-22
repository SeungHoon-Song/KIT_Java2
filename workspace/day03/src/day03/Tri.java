package day03;

public class Tri extends Shape {

	@Override
	public double getArea(double w, double h) {
		area = w*h/2;
		return area;
	}

}

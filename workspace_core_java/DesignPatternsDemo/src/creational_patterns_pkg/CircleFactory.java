package creational_patterns_pkg;

public class CircleFactory implements ShapeFactory{
	@Override
	public Shape createShape() {
		return new Circle();
	}
}

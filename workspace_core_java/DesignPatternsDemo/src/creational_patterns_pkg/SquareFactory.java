package creational_patterns_pkg;

public class SquareFactory implements ShapeFactory{

	@Override
	public Shape createShape() {
		return new Square();
	}
}

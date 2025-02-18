package mainpkg;

import creational_patterns_pkg.Circle;
import creational_patterns_pkg.CircleFactory;
import creational_patterns_pkg.Person;
import creational_patterns_pkg.ShapeFactory;
import creational_patterns_pkg.SingletonClass;
import creational_patterns_pkg.Square;
import creational_patterns_pkg.SquareFactory;
import structural_design_patterns.Apple;
import structural_design_patterns.AppleAdapter;
import structural_design_patterns.Orange;

public class MainClass {

	public static void main(String[] args) {
		
		Apple apple = new Apple("Red");
		apple.printData();
		
		Orange orange = new Orange("Green");
		AppleAdapter ad = new AppleAdapter(orange);
		ad.printData();
//		ad.getFruitColor();
		
		
		
//		SingletonClass singleton = SingletonClass.getInstance();
//		
//		singleton.showMessage();
		
//		ShapeFactory squareFactory = new SquareFactory();
//		Square square = (Square) squareFactory.createShape();
//		square.draw();
//		
//		ShapeFactory circleFactory = new CircleFactory();
//		Circle circle = (Circle) circleFactory.createShape(); 
//		circle.draw();
		
		//Person person = new Person.PersonBuilder(1, "Prithvi", "Raj", 25)
			//		.buildPerson();
		
//		Person person = new Person.PersonBuilder("Prithvi", "Raj")
//				.id(1)
//				.age(25)
//				.buildPerson();
//		
//		System.out.println(person.toString());
	}

}

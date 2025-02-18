package mainpkg;

import bahavioral_patterns.ChannelIterator;
import bahavioral_patterns.ChannelOperations;
import bahavioral_patterns.ChannelOperationsImpl;
import bahavioral_patterns.Channels;
import bahavioral_patterns.FM_Stations;
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

	private static ChannelOperations populateChannels() {
		ChannelOperations channels= new ChannelOperationsImpl();
		channels.addChannel(new Channels(91.1, FM_Stations.RADIOCITY));
		channels.addChannel(new Channels(93.5, FM_Stations.REDFM));
		channels.addChannel(new Channels(92.7, FM_Stations.BIG_FM));
		channels.addChannel(new Channels(98.3, FM_Stations.RADIO_MIRCHI));
		channels.addChannel(new Channels(102.9, FM_Stations.VIVIDH_BHARATHI));
		channels.addChannel(new Channels(94.3, FM_Stations.RADIO_ONE));
		channels.addChannel(new Channels(104.0, FM_Stations.FEVER));
		
		return channels;
	}
	public static void main(String[] args) {
		ChannelOperations channels = populateChannels();
		
		ChannelIterator iterator = channels.iterateChannels(FM_Stations.ALL);
		
		while(iterator.hasNext()) {
			Channels c = iterator.next();
			System.out.println(c.toString());
		}
		
//		iterator = channels.iterateChannels(FM_Stations.FEVER);
//		while(iterator.hasNext()) {
//			Channels c = iterator.next();
//			System.out.println(c.toString());
//		}
//		
//		Apple apple = new Apple("Red");
//		apple.printData();
//		
//		Orange orange = new Orange("Green");
//		AppleAdapter ad = new AppleAdapter(orange);
//		ad.printData();
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

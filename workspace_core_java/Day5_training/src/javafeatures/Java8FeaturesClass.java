package javafeatures;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
//import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Java8FeaturesClass {
	
	public void datetimeApiDemo() {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		LocalDate ld1 = LocalDate.parse(str);
		System.out.println(ld1);
		LocalDate ld = LocalDate.now();
//		Date date = new Date();
		System.out.println("Today: " + ld);
		
		System.out.println(ld.plusDays(5));
		
	}
	
	public void streamApiDemo2() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(101, "Pen", 23.00));
		products.add(new Product(104, "Pencil", 19.00));
		products.add(new Product(103, "Eraser", 25.00));
		products.add(new Product(106, "Notebook", 34.00));
		products.add(new Product(107, "A4 sheet", 10.00));
		products.add(new Product(102, "Writing Pad", 40.00));
	
		List<Product> filteredProducts = 
				products.stream()
					.filter(p -> p.getPrice() >= 20 && p.getPrice() <= 30)
					.collect(Collectors.toList());
		
		System.out.println(filteredProducts);
	
	}
	
	public void streamAPIDemo() {
//		List<Integer> numbers = new ArrayList<Integer>();
//		for(int i = 0; i < 10; i++) {
//			numbers.add(i + 1);
//		}
		
//		int max = numbers.get(0);
//		for(int i = 0; i < 10; i++) {
//			if(numbers.get(i)>max) {
//				max = numbers.get(i);
//			}
//		}
//		System.out.println("Max Number: " + max);
		
		
//		int max = numbers.stream().max(Integer :: compare).get();
//		System.out.println("Max Number: " + max);
		List<String> names = Arrays.asList("Prithvi", "Deepa", "Manoj", 
				"Seema", "Divyansh", "Pranav", "Kamal");
		List<String> filtered = names.stream()
						.filter(name -> name.startsWith("D"))
						.collect(Collectors.toList());
		
		System.out.println(filtered);
		
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> oddNumbers = new ArrayList<Integer>();
		List<Integer> evenNumbers = new ArrayList<Integer>();
		
		
		for(int i = 0; i < 10; i++) {
			numbers.add(i + 1);
		}
		
		evenNumbers = numbers.stream().filter(n -> n%2 == 0)
				.collect(Collectors.toList());
		
		oddNumbers = numbers.stream().filter(n -> n%2 != 0)
				.collect(Collectors.toList());
		
		System.out.println("Odd: " + oddNumbers);
		System.out.println("Even: " + evenNumbers);
	}
	
	public void forEachDemo() {
		
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			numbers.add(i + 1);
		}
		
//		ListIterator<Integer> itr =  numbers.listIterator();
//		while(itr.hasNext()) {
//			System.out.print(itr.next() + " ");
//		}
		
		numbers.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("forEach: " + t);
			}
			
		});
	}
	
}

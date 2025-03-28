package collectionspkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;

public class CollectionsDemo {
	
	public void hashmapDemo() {
		HashMap<Integer, Product> products = new HashMap<Integer, Product>();
		products.put(101, new Product(101, "Pencil", 12.00));
		products.put(102, new Product(102, "Gel Pen", 10.00));
		products.put(103, new Product(103, "Dot Pen", 12.00));
		products.put(104, new Product(104, "Eraser", 18.00));
		
		System.out.println(products);
		
		Set<Integer> keys = products.keySet();
		System.out.println("Keys: " + keys);
		System.out.println("Values: " + products.values());
		
		for(Entry<Integer, Product> entry:products.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue().toString());
		}
	}
	
	public void hashSetDemo() {
		HashSet<Integer> numberset = new HashSet<Integer>();
		numberset.add(12);
		numberset.add(1);
		numberset.add(34);
		numberset.add(10);
		numberset.add(1);
		
		System.out.println(numberset);
//		System.out.println(numberset.remove(1));
//		System.out.println(numberset);
		
		HashSet<Integer> numbers = new HashSet<Integer>();
		numbers.add(11);
		numbers.add(4);
		numbers.add(34);
		numbers.add(10);
		
		System.out.println(numbers);
		
	//	numberset.addAll(numbers);
//		numberset.retainAll(numbers);
		numberset.removeAll(numbers);
		System.out.println(numberset);
		
		
	}
	
	public void treesetDemo() {
		TreeSet<Integer> numbers = new TreeSet<Integer>();
		numbers.add(10);
		numbers.add(1);
		numbers.add(20);
		numbers.add(13);
		numbers.add(19);
		numbers.add(40);
		
		System.out.println(numbers);
		
//		int ele = numbers.ceiling(34);
//		System.out.println(ele);
		
		SortedSet<Integer> from = numbers.tailSet(18);
		System.out.println(from);
		
		SortedSet<Integer> to = numbers.headSet(18);
		System.out.println(to);
		
	}
	
	public void arrayListDemo() {
	//	List<String> names = new ArrayList<String>();
		ArrayList<String> words = new ArrayList<String>();
		words.add("Java");
		words.add("Firebase");
		words.add("Kotlin");
		words.add(1, "Spring");
		if(words.isEmpty()) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		System.out.println("Initial List: " + words);
		words.addLast("Hibernate");
		words.addFirst("C#");
		System.out.println("List now: " + words);
		
		String word = words.get(3);
		System.out.println(word);
		
		
		ListIterator<String> itr = words.listIterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		

		
	}
	
	public void linkedListDemo() {
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		Iterator<Integer> itr = numbers.descendingIterator();
		
		//rest of the methods are the same as ArrayList
	}
	
	public void pqDemo() {
		PriorityQueue<Integer> numbers = new PriorityQueue<Integer>();
		
		numbers.add(3);
		numbers.add(12);
		numbers.add(1);
		numbers.add(37);
		numbers.add(10);
		
		System.out.println(numbers);
		int ele = numbers.remove();
		System.out.println("removed element: " + ele);
		System.out.println(numbers);
		
	}
}

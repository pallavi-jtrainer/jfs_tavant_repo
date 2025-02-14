package javafeatures;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Java9Features {
	public void streamsApiDemo() {
		List<Integer> numbers = Arrays.asList(2,3,4,1,5,1,7,7,10,9);
		
		List<Integer> takenNumbers = numbers.stream().takeWhile(n -> n < 5)
			.collect(Collectors.toList());
		System.out.println(takenNumbers);
		
		List<Integer> droppedNumbers = numbers.stream().dropWhile(n -> n < 5)
			.collect(Collectors.toList());
		
		System.out.println(droppedNumbers);
	}
	
	public void immutableCollectionsDemo() {
		List<Integer> immutableList = List.of(10, 1, 34,23,56,0, 9);
		System.out.println(immutableList);
//		immutableList.add(324);
//		
//		System.out.println(immutableList);
		
		Set<Integer> immutableSet = Set.of(12, 2,6,4,21);
		System.out.println(immutableSet);
		
		Map<Integer, String> immutableMap = Map.of(1, "one", 2, "two", 3, "three");
		System.out.println(immutableMap);
	}
}

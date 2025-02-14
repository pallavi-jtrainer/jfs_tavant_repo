package javafeatures;

import java.util.ArrayList;
import java.util.Optional;

public class Java10Features {

	public void varDemo() {
		var num = new ArrayList<Integer>();
		num.add(23);
		num.add(34);
	}
	
	public void optionalDemo() {
		Optional<String> val = Optional.of("Java");
		
		String str = val.orElseThrow();
		System.out.println(str);
		
		Optional<String> s = Optional.empty();
		
		try {
			s.orElseThrow();
			System.out.println(s);
		} catch(Exception e) {
			System.out.println("Empty Optional");
		}
	}
}

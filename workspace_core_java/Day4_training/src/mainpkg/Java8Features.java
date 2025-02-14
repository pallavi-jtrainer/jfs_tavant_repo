package mainpkg;

import java.util.ArrayList;
import java.util.List;

public class Java8Features {

	public void show() {
//		FunctionalInterface1 obj = 
//				(String msg) -> {
//						System.out.println(msg);
//					};
//		obj.greet("Hello");
		
		FunctionalInterface1 obj = 
				(int a, int b, int c) -> {
					return a + b + c;
				};
		int ans = obj.add(1, 2, 3);
		System.out.println(ans);
	}
	
	public void forEachDemo() {
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			numbers.add(1 + i);
		}
		
		numbers.forEach(null);
		
	}
	
}

package mainpkg;

import java.io.IOException;

import collectionspkg.CollectionsDemo;
import exceptionspkg.ExceptionDemo;
import exceptionspkg.InvalidAgeException;

public class MainClass {
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
//		CollectionsDemo cd = new CollectionsDemo();
		//cd.arrayListDemo();
//		cd.pqDemo();
//		cd.hashSetDemo();
//		cd.treesetDemo();
//		cd.hashmapDemo();
		
		int[] arr = new int[5];
		
		for(int i = 0; i < 5; i++) {
			arr[i] = 2 * i;
		}
		
		ExceptionDemo demo = new ExceptionDemo();
		try {
//			demo.exception2(arr);
//			demo.writeAndReadFromFile();
			demo.checkAge(15);
		} catch(ArrayIndexOutOfBoundsException | InvalidAgeException  ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.println("Executed everytime");
		}
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			demo.divide(1, 0);
//		} catch(ArithmeticException ex) {
//			System.out.println(ex.getMessage());
//		}
		
	}

}

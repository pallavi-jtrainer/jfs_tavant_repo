package exceptionspkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExceptionDemo {
	
	public void checkAge(int age) throws InvalidAgeException {
		if(age < 18) {
			throw new InvalidAgeException("Not eligible to vote");
		}
		System.out.println("Eligible to vote");
	}
	
	
	
	public void writeAndReadFromFile() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		
		str = br.readLine();
		System.out.println(str);
	}
	
	
	public void divide(int a, int b) {
		//int c;
//		try {
//			int c = a / b;
//			System.out.println(c);
//		} catch (ArithmeticException ex) {
//			System.out.println(ex.getMessage());
//		}
		
		
		if(b <= 0) {
			throw new ArithmeticException("Denominator cannot be zero");
		}
		
		System.out.println(a / b);
	}
	
	public void exception2(int arr[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the index of the element: ");
		int index = sc.nextInt();
		sc.close();
		if(index >=0 && index < arr.length) {
			System.out.println(arr[index]);
		} else {
			throw new ArrayIndexOutOfBoundsException(index + " is beyond the array boundary");
		}
		
	}
	
	
}

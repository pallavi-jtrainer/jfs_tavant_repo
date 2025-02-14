package mainpkg;

public class StringsDemo {

	public void stringDemo() {
		String str = "First String";
		str = "Second String";
		
		System.out.println(str);
		
	}
	
	public void stringBufferDemo() {
		StringBuffer sb = new StringBuffer("Hello");
		sb.append(" World");
		System.out.println(sb);
		sb.insert(4, "New");
		System.out.println(sb);
		
	}
}

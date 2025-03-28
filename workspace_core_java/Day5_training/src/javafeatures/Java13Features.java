package javafeatures;

public class Java13Features {
	public void yieldDemo() {
		String day = "Valentine's Day";
		
		int res = switch(day) {
		case "Monday", "Friday", "Sunday" -> 6;
		case "Tuesday" -> 7;
		case "Thursday", "Saturday" -> 8;
		case "Wednesday" -> {
			int len = day.length();
			yield len;
		}
		default -> throw new IllegalArgumentException("Invalid Day: " + day);
		
		};
		
		System.out.println(res);
	}
}

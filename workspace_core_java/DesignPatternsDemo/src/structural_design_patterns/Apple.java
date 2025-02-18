package structural_design_patterns;

public class Apple {
	private String color;
	
	public Apple() {}
	
	public Apple(String color) {
		this.color = color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void printData() {
		System.out.println("Color of apple is " + color);
	}
	
}

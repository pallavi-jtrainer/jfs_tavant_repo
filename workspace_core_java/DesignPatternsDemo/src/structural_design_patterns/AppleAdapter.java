package structural_design_patterns;

public class AppleAdapter extends Apple {

	private Orange orange;
	
//	public AppleAdapter(String color) {
//		super(color);
//	}
	
	public AppleAdapter(Orange orange) {
//		super();
		this.orange = orange;
		this.setColor(orange.getColor());
	}
	
	public void getFruitColor() {
		System.out.println(orange.getColor());
	}

}

package srpExample;

public class Book {
	private String name;
	private String author_name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public Book(String name, String author_name) {
		this.name = name;
		this.author_name = author_name;
	}
	
}

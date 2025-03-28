package srpExample;

public class PrintBookDetails {
	Book book;
	public void print() {
		System.out.println("Name: " + book.getName());
		System.out.println("Author Name: " + book.getAuthor_name());
	}
}

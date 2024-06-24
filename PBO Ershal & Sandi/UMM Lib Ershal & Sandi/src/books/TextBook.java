package books;
public class TextBook extends Book{
	
	String category = "Novel";

	public TextBook(int stock, String author, String bookId, String title) {
		super(stock, author, bookId, title);
		this.setCategory(category);
		// TODO Auto-generated constructor stub
	}
}

package books;
public class StoryBook extends Book{
	
	String category = "Cerita";

	public StoryBook(int stock, String author, String bookId, String title) {
		super(stock, author, bookId, title);
		this.setCategory(category);
		// TODO Auto-generated constructor stub
	}
}

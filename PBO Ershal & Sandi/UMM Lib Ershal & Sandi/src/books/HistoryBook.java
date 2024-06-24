package books;
public class HistoryBook extends Book {
	
	String category = "Sejarah";

	public HistoryBook(int stock, String author, String bookId, String title) {
		super(stock, author, bookId, title);
		this.setCategory(category);
		// TODO Auto-generated constructor stub
	}

}

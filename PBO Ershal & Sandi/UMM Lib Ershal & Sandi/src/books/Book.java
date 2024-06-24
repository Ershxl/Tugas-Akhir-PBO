package books;

public class Book {
	
    private int duration;
    private int stock;
    private String author;
    private String bookId;
    private String title;
    private String category;

    public Book(int stock, String author, String bookId, String title) {
        this.stock = stock;
        this.author = author;
        this.bookId = bookId;
        this.title = title;

    }
    
    // setter getter
	public void setDuration(int duration) {
    	this.duration = duration;
    } 
    public void setStock(int stock) {
    	this.stock = stock;
    }
    public void setAuthor(String author) {
    	this.author = author;
    }
    public void setBookId(String bookId) {
    	this.bookId = bookId;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public void setCategory(String category) {
    	this.category = category;
    }
    
    public int getDuration() {
    	return duration;
    }
    
    public int getStock() {
    	return stock;
    }
    
    public String getAuthor() {
    	return author;
    }
    
    public String getBookId() {
    	return bookId;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public String getCategory() {
    	return category;
    }
    
    @Override
    public String toString() {
    	return title;
    }
    
}

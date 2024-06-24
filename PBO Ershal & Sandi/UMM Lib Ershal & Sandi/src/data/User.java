package data;

import books.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {
    private static ObservableList<Book> bookList =  FXCollections.observableArrayList();
    private String password;  // Add password field

    public static ObservableList<Book> getBookList() {
        return bookList;
    }
    
    public static void addBookList(Book book) {
    	bookList.add(book);
    }
    public String getPassword() {  // Add getter for password
        return password;
    }

    public void setPassword(String password) {  // Add setter for password
        this.password = password;
    }
}

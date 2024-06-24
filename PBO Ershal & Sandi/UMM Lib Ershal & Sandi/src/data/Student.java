package data;

import java.util.ArrayList;
import books.Book;

public class Student extends User {
    private String name;
    private String faculty;
    private String nim;
    private String programStudi;
    private String imageSrc;
    private ArrayList<Book> borrowedBooks;

    public Student(String name, String nim, String faculty, String programStudi, String password, String imageSrc) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.programStudi = programStudi;
        this.imageSrc = imageSrc;
        this.setPassword(password);  
        borrowedBooks = new ArrayList<Book>();
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for faculty
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    // Getter and Setter for nim
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Getter and Setter for programStudi
    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    // Getter and Setter for imageSrc
    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
    
    public ArrayList<Book> getBorrowedBooks(){
    	return borrowedBooks;
    }
    
    public void setBorrowedBooks(Book book) {
    	borrowedBooks.add(book);
    }
}

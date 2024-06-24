package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Optional;

import books.Book;
import data.Admin;
import data.Student;
import data.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminController {
	
	Stage stage;
	Scene scene;
	Parent root;

    @FXML
    private HBox data_form;
    
    @FXML 
    private HBox chart_homeForm;

    @FXML
    private AnchorPane crudStudent_form;

    @FXML
    private TableView<Student> studenTable_fix;

    @FXML
    private TableColumn<Student, String> name_stdTableFix;

    @FXML
    private TableColumn<Student, String> nim_stdTableFix;

    @FXML
    private TableColumn<Student, String> faculty_stdTableFix;
    
    @FXML 
    private TableColumn<Student, String> major_stdTableFix;
    
    @FXML
    private TextField nameInput;

    @FXML
    private TextField nimInput;

    @FXML
    private ComboBox<String> facultyCbox;

    @FXML
    private ComboBox<String> majorCbox;

    @FXML
    private TableView<Student> studentTable_temporary;

    @FXML
    private TableColumn<Student, String> name_stdTableTemp;

    @FXML
    private TableColumn<Student, String> nim_stdTableTemp;

    @FXML
    private TableColumn<Student, String> faculty_stdTableTemp;

    @FXML
    private TableColumn<Student, String> major_stdTableTemp;
    
    @FXML
    private Button addTempStudent_btn;

    @FXML
    private Button addAllStudent_btn;

    @FXML
    private Button deleteAllStudent_btn;

    @FXML
    private Button chooseDeleteStudent_btn;


    @FXML
    private Button deleteChoosenStudent_btn;

    @FXML
    private AnchorPane crudBook_form;

    @FXML
    private TableView<Book> booksTable_fix;

    @FXML
    private TableColumn<Book, String> id_bkTablefix;

    @FXML
    private TableColumn<Book, String> title_bkTablefix;

    @FXML
    private TableColumn<Book, String> author_bkTablefix;

    @FXML
    private TableColumn<Book, String> kategori_bkTablefix;

    @FXML
    private TableColumn<Book, Integer> stock_bkTablefix;
    
    @FXML
    private TextField bookId_input;

    @FXML
    private TextField bookAuthor_input;

    @FXML
    private ComboBox<String> bookCategory_input;

    @FXML
    private TableView<Book> bookTable_temp;

    @FXML
    private TableColumn<Book, String> id_bkTableTemp;

    @FXML
    private TableColumn<Book, String> title_bkTableTemp;

    @FXML
    private TableColumn<Book, String> author_bkTableTemp;

    @FXML
    private TableColumn<Book, String> kategori_bkTableTemp;
    
    @FXML
    private TableColumn<Book, Integer> stock_bkTableTemp;

    @FXML
    private TextField bookTitle_input;

    @FXML
    private TextField stockBook_input;

    @FXML
    private Button deleteChoosenBook_btn;

    @FXML
    private Button chooseDeleteBook_btn;

    @FXML
    private Button deleteAllBook_btn;

    @FXML
    private Button addAllBook_btn;

    @FXML
    private Button addTempBook_btn;

    @FXML
    private Button crudStudents_btn;

    @FXML
    private Button crudBooks_btn;

    @FXML
    private Button home_btn;
    
    @FXML
    private Group keteranganStd_text;
    
    @FXML
    private Group keteranganBook_text;

    private ObservableList<Student> tempStudents = FXCollections.observableArrayList();
    private ObservableList<Book> tempBooks = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
    	ObservableList<Student> student = FXCollections.observableArrayList(Admin.getStudentList());
    	ObservableList<Book> books = FXCollections.observableArrayList(User.getBookList());
        // Set up the columns in the studentTable_fix
        name_stdTableFix.setCellValueFactory(new PropertyValueFactory<>("name"));
        nim_stdTableFix.setCellValueFactory(new PropertyValueFactory<>("nim"));
        faculty_stdTableFix.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        major_stdTableFix.setCellValueFactory(new PropertyValueFactory<>("programStudi"));

        // Set up the columns in the booksTable_fix
        id_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        title_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("title"));
        author_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("author"));
        kategori_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("category"));
        stock_bkTablefix.setCellValueFactory(new PropertyValueFactory<>("stock"));

        // Set up the columns in the temporary student table
        name_stdTableTemp.setCellValueFactory(new PropertyValueFactory<>("name"));
        nim_stdTableTemp.setCellValueFactory(new PropertyValueFactory<>("nim"));
        faculty_stdTableTemp.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        major_stdTableTemp.setCellValueFactory(new PropertyValueFactory<>("programStudi"));

        // Set up the columns in the temporary book table
        id_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        title_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("title"));
        author_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("author"));
        kategori_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("category"));
        stock_bkTableTemp.setCellValueFactory(new PropertyValueFactory<>("stock"));

        // Populate ComboBoxes with example data
        facultyCbox.setItems(FXCollections.observableArrayList("Science", "Engineering", "Arts"));
        majorCbox.setItems(FXCollections.observableArrayList("Physics", "Computer Science", "Fine Arts"));
        bookCategory_input.setItems(FXCollections.observableArrayList("Fiction", "Non-Fiction", "Science", "Art"));
        
        studenTable_fix.setItems(student);
        booksTable_fix.setItems(books);
    }

    @FXML
    private void switchForm(ActionEvent e) {
        if (e.getSource() == home_btn) {
            home_btn.setStyle("-fx-background-color: #08203E");
            crudStudents_btn.setStyle("-fx-background-color: transparent");
            crudBooks_btn.setStyle("-fx-background-color: transparent");

            data_form.setVisible(true);
            chart_homeForm.setVisible(true);
            crudStudent_form.setVisible(false);
            crudBook_form.setVisible(false);
        } else if (e.getSource() == crudStudents_btn) {
            crudStudents_btn.setStyle("-fx-background-color: #08203E");
            home_btn.setStyle("-fx-background-color: transparent");
            crudBooks_btn.setStyle("-fx-background-color: transparent");

            data_form.setVisible(false);
            chart_homeForm.setVisible(false);
            crudStudent_form.setVisible(true);
            crudBook_form.setVisible(false);
        } else if (e.getSource() == crudBooks_btn) {
            crudBooks_btn.setStyle("-fx-background-color: #08203E");
            crudStudents_btn.setStyle("-fx-background-color: transparent");
            home_btn.setStyle("-fx-background-color: transparent");

            data_form.setVisible(false);
            chart_homeForm.setVisible(false);
            crudStudent_form.setVisible(true);
            crudBook_form.setVisible(true);
        }
    }

    @FXML
    private void addTempStudent(ActionEvent event) {
        String name = nameInput.getText();
        String nim = nimInput.getText();
        String faculty = facultyCbox.getValue();
        String major = majorCbox.getValue();

        if (name.isEmpty() || nim.isEmpty() || faculty == null || major == null) {
            // Show error message (implementation not shown)
            return;
        }

        Student student = new Student(name, nim, faculty, major, "", "");
        tempStudents.add(student);
        studentTable_temporary.setItems(tempStudents);
        clearStudentForm();
    }

    @FXML
    private void addAllStudents(ActionEvent event) {
        for (Student student : tempStudents) {
            Admin.addStudentList(student);
        }
        tempStudents.clear();
        studentTable_temporary.setItems(tempStudents);
        refreshStudentTable();
    }

    private void refreshStudentTable() {
        studenTable_fix.setItems(Admin.getStudentList());
    }
    
    @FXML
    private void deleteAllStudents(ActionEvent event) {
        tempStudents.clear();
        studentTable_temporary.setItems(tempStudents);
    }
    
    @FXML
    private void chooseDeleteStudent(ActionEvent event) {
    	keteranganStd_text.setVisible(true);
    	deleteChoosenStudent_btn.setVisible(true);
    }

    @FXML
    private void deleteSelectedStudent(ActionEvent event) {
        Student selectedStudent = studentTable_temporary.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            tempStudents.remove(selectedStudent);
            studentTable_temporary.setItems(tempStudents);
            keteranganStd_text.setVisible(false);
        	deleteChoosenStudent_btn.setVisible(false);
        }
    }

    @FXML
    private void addTempBook(ActionEvent event) {
        String bookId = bookId_input.getText();
        String title = bookTitle_input.getText();
        String author = bookAuthor_input.getText();
        String category = bookCategory_input.getValue();
        int stock;

        try {
            stock = Integer.parseInt(stockBook_input.getText());
        } catch (NumberFormatException e) {
            // Show error message (implementation not shown)
            return;
        }

        if (bookId.isEmpty() || title.isEmpty() || author.isEmpty() || category == null || stock <= 0) {
            // Show error message (implementation not shown)
            return;
        }

        Book book = new Book(stock, author, bookId, title);
        book.setCategory(category);
        tempBooks.add(book);
        bookTable_temp.setItems(tempBooks);
        clearBookForm();
    }
    
    @FXML
    private void chooseDeleteBook(ActionEvent event) {
    	keteranganBook_text.setVisible(true);
    	deleteChoosenBook_btn.setVisible(true);
    }

    @FXML
    private void addAllBooks(ActionEvent event) {
        for (Book book : tempBooks) {
            User.addBookList(book);
        }
        tempBooks.clear();
        bookTable_temp.setItems(tempBooks);
        // Refresh the main book table (implementation not shown)
    }

    @FXML
    private void deleteAllBooks(ActionEvent event) {
        tempBooks.clear();
        bookTable_temp.setItems(tempBooks);
    }

    @FXML
    private void deleteSelectedBook(ActionEvent event) {
        Book selectedBook = bookTable_temp.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            tempBooks.remove(selectedBook);
            bookTable_temp.setItems(tempBooks);
            keteranganBook_text.setVisible(false);
        	deleteChoosenBook_btn.setVisible(false);
        }
    }
    
    @FXML
    private void logout(ActionEvent event) {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("You are about to logout!");
        alert.setContentText("Are you sure you want to logout?");

        // Capture the user's response
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void clearStudentForm() {
        nameInput.clear();
        nimInput.clear();
        facultyCbox.setValue(null);
        majorCbox.setValue(null);
    }

    private void clearBookForm() {
        bookId_input.clear();
        bookTitle_input.clear();
        bookAuthor_input.clear();
        bookCategory_input.setValue(null);
        stockBook_input.clear();
    }
}

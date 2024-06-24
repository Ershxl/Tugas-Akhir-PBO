package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import books.Book;
import data.Admin;
import data.Student;
import data.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StudentController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Student student; // Add a student instance

    @FXML
    private AnchorPane profileForm;

    @FXML
    private ImageView studentImage;
    
    private Image studentImageSrc;

    @FXML
    private Label namaMahasiswa;

    @FXML
    private Label nim;

    @FXML
    private Label fakultas;

    @FXML
    private Label prodi;

    @FXML
    private BarChart<?, ?> grafikPeminjaman;

    @FXML
    private AnchorPane inputForm;

    @FXML
    private AnchorPane pinjamForm;

    @FXML
    private AnchorPane returnForm;

    @FXML
    private TableView<Book> tabelPinjam;

    @FXML
    private TableColumn<Book, Integer> noTabel_pinjam;

    @FXML
    private TableColumn<Book, String> idTabel_pinjam;

    @FXML
    private TableColumn<Book, String> namaTabel_pinjam;

    @FXML
    private TableColumn<Book, String> authorTabel_pinjam;

    @FXML
    private TableColumn<Book, String> kategoriTabel_pinjam;

    @FXML
    private TableColumn<Book, Integer> durasiTabel_pinjam;

    @FXML
    private HBox isPinjam;

    @FXML
    private TableView<Book> tabelListBuku;

    @FXML
    private TableColumn<Book, Integer> noTabel_list;

    @FXML
    private TableColumn<Book, String> idTabel_list;

    @FXML
    private TableColumn<Book, String> namaTabel_list;

    @FXML
    private TableColumn<Book, String> authorTabel_list;

    @FXML
    private TableColumn<Book, String> kategoriTabel_list;

    @FXML
    private TableColumn<Book, Integer> stokTabel_list;

    @FXML
    private ComboBox<Integer> comboBoxDurasiPinjam;

    @FXML
    private Button profilBtn;

    @FXML
    private Button pinjamBtn;

    @FXML
    private Button returnBtn;

    @FXML
    private Button logOutBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Fetch the student details from the Admin class
        student = Admin.getStudentLog(); // Assuming you're loading the first student for this example

        // Set student profile details
        namaMahasiswa.setText(student.getName());
        nim.setText(student.getNim());
        fakultas.setText(student.getFaculty());
        prodi.setText(student.getProgramStudi());
        studentImageSrc = new Image(getClass().getResourceAsStream(student.getImageSrc()));
        studentImage.setImage(studentImageSrc);

        // Initialize the book list and the borrowed books table
        initializeBookList();
        initializeBorrowedBooksTable();

        // Initialize the duration ComboBox
        comboBoxDurasiPinjam.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));
    }

    private void initializeBookList() {
        ObservableList<Book> bookList = FXCollections.observableArrayList(User.getBookList());

        noTabel_list.setCellValueFactory(new PropertyValueFactory<>("stock"));
        idTabel_list.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        namaTabel_list.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorTabel_list.setCellValueFactory(new PropertyValueFactory<>("author"));
        kategoriTabel_list.setCellValueFactory(new PropertyValueFactory<>("category"));
        stokTabel_list.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tabelListBuku.setItems(bookList);
    }

    private void initializeBorrowedBooksTable() {
        noTabel_pinjam.setCellValueFactory(new PropertyValueFactory<>("duration"));
        idTabel_pinjam.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        namaTabel_pinjam.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorTabel_pinjam.setCellValueFactory(new PropertyValueFactory<>("author"));
        kategoriTabel_pinjam.setCellValueFactory(new PropertyValueFactory<>("category"));
        durasiTabel_pinjam.setCellValueFactory(new PropertyValueFactory<>("duration"));

        tabelPinjam.setItems(FXCollections.observableArrayList(student.getBorrowedBooks()));
    }

    @FXML
    private void switchForm(ActionEvent e) {
        if (e.getSource() == profilBtn) {
            profilBtn.setStyle("-fx-background-color: #830c0c");
            pinjamBtn.setStyle("-fx-background-color: transparent");
            returnBtn.setStyle("-fx-background-color: transparent");

            inputForm.setVisible(false);
            profileForm.setVisible(true);
            pinjamForm.setVisible(false);
            returnForm.setVisible(false);
        } else if (e.getSource() == pinjamBtn) {
            pinjamBtn.setStyle("-fx-background-color: #830c0c");
            profilBtn.setStyle("-fx-background-color: transparent");
            returnBtn.setStyle("-fx-background-color: transparent");

            inputForm.setVisible(true);
            profileForm.setVisible(true);
            pinjamForm.setVisible(true);
            returnForm.setVisible(false);
        } else if (e.getSource() == returnBtn) {
            returnBtn.setStyle("-fx-background-color: #830c0c");
            profilBtn.setStyle("-fx-background-color: transparent");
            pinjamBtn.setStyle("-fx-background-color: transparent");

            inputForm.setVisible(true);
            profileForm.setVisible(true);
            pinjamForm.setVisible(true);
            returnForm.setVisible(true);
        }
    }

    @FXML
    private void borrowBook(ActionEvent event) {
    	Book selectedBook = tabelListBuku.getSelectionModel().getSelectedItem();
        Integer duration = comboBoxDurasiPinjam.getValue();

        if (selectedBook != null && duration != null) {
            selectedBook.setDuration(duration);
            student.getBorrowedBooks().add(selectedBook);
            initializeBorrowedBooksTable();
            isPinjam.setVisible(false);
            tabelPinjam.setVisible(true);
        } 
    }

    @FXML
    private void returnBook(ActionEvent event) {
        Book selectedBook = tabelPinjam.getSelectionModel().getSelectedItem();

        if (selectedBook != null && student.getBorrowedBooks().contains(selectedBook)) {
            student.getBorrowedBooks().remove(selectedBook);
            initializeBorrowedBooksTable();
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
                stage.setFullScreen(true);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

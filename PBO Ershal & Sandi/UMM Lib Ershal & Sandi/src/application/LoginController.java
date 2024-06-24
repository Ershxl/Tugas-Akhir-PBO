package application;

import java.net.URL;
import java.util.ResourceBundle;

import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import data.Admin;
import data.Student;
import data.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private UserType userType;

    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private Text message;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	User.addBookList(new HistoryBook(3, "Anies Baswedan", "B001", "Cara Masuk Surga"));
        User.addBookList(new StoryBook(3, "Jokowi", "B002", "Tutorial Ayam-Ayamin MK"));
        User.addBookList(new TextBook(2, "Cak Imin", "B003", "SLEPET"));
        Admin.addStudentList(new Student("Sandi Fariz Ahmadi", "202310370311076", "Teknik", "Informatika", "password", "/images/Sandi.jpg"));
        
    }
    
    public void login(ActionEvent event) {
        if (userType.equals(UserType.ADMIN)) {
            if (Admin.isAdmin(usernameInput.getText(), passwordInput.getText())) {
                loadScene(event, "Admin");
            } else {
                message.setText("Invalid Username or Password");
            }
        } else if (userType.equals(UserType.STUDENT)) {
            for (Student student : Admin.getStudentList()) {
                if (student.getNim().equals(usernameInput.getText()) && student.getPassword().equals(passwordInput.getText())) {
                	Admin.setStudentLog(student);
                    loadScene(event, "Student");
                    return;
                }
            }
            message.setText("Invalid Username or Password");
        }
    }

    public void loadScene(ActionEvent event, String fxml) {
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/" + fxml + ".fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            //stage.setFullScreen(true);
            stage.show();
        } catch (Exception e) {
            message.setText("Failed to load the " + fxml + " file.");
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleBackMenuClicked(MouseEvent event) {
    	try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setFullScreen(true);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

}

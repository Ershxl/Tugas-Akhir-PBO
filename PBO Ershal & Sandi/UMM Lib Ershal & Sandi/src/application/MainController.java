package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button register_btn;

    @FXML
    private Button admin_loginbtn;

    @FXML
    private Button student_loginbtn;
    
    public void adminButtonAction(ActionEvent event) {
        loadLoginScene(event, UserType.ADMIN, "Login");
    }

    public void studentButtonAction(ActionEvent event) {
        loadLoginScene(event, UserType.STUDENT, "Login");
    }
    
    public void registerButtonAction(ActionEvent event) {
        loadLoginScene(event, UserType.REGISTER, "Register");
    }

    private void loadLoginScene(ActionEvent event, UserType userType, String fxName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + fxName + ".fxml"));
            root = loader.load();

            LoginController loginController = loader.getController();
            loginController.setUserType(userType);
            
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            //stage.setFullScreen(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

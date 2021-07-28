package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SigninAdmin {

    @FXML private Label lblUsername = new Label();

    @FXML private Label lblPassword = new Label();

    @FXML private Button btnEnter = new Button();

    @FXML private TextField txtUsername = new TextField();

    @FXML private TextField txtPassword = new TextField();

    @FXML
    void pressEnter(ActionEvent event) throws IOException {
        String userName[] = {"reza" , "arshia" , "admin"};
        String passWord[] = {"123" , "mokhles" , "admin"};
        String userInput = txtUsername.getText();
        String passInput = txtPassword.getText();
        boolean checkUsername = false;
        boolean checkPassword = false;

        for (int i = 0; i<userName.length; i++){
            if (userInput.equals(userName[i])){
                checkUsername = true;
                if (passInput.equals(passWord[i])){
                    checkPassword = true;
                    error.setInfo("Access Granted");
                    Stage stage = (Stage) btnEnter.getScene().getWindow();
                    stage.close();
                    Stage primaryStage = new Stage();
                    AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminFirstPage.fxml"));
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    break;
                }
                if (checkUsername == true && checkPassword == false){
                    error.setError("Password is wrong!");
                    break;
                }
            }
            if (i == userName.length-1){
                error.setError("Username is wrong!");
                break;
            }
        }

    }

}
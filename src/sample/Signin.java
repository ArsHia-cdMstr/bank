package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Signin {

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPassword;

    @FXML
    private Button btnEnter;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label lblshow;

    @FXML
    void pressEnter(ActionEvent event) throws IOException {
        String userName[] = {"reza" , "ai"};
        String passWord[] = {"123" , "32l1"};
        String userInput = txtUsername.getText();
        String passInput = txtPassword.getText();
        boolean checkUsername = false;
        boolean checkPassword = false;

        for (int i = 0; i<userName.length; i++){
            if (userInput.equals(userName[i])){
                checkUsername = true;
                if (passInput.equals(passWord[i])){
                    checkPassword = true;
                    lblshow.setText("Access Granted");
                    Stage stage =(Stage) btnEnter.getScene().getWindow();
                    stage.close();
                    Stage primaryStage=new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                    primaryStage.setScene(new Scene(root));
                    primaryStage.show();
                    break;
                }
                if (checkUsername == true && checkPassword == false){
                    lblshow.setText("Password is wrong!");
                    break;
                }
            }
            if (i == userName.length-1){
                lblshow.setText("Username is wrong!");
                break;
            }
        }

    }

}
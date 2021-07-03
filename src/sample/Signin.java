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
import java.util.ArrayList;

import server.*;

public class Signin {

    @FXML private Label lblUsername;

    @FXML private Label lblPassword;

    @FXML private Button btnEnter;

    @FXML private TextField txtUsername;

    @FXML private TextField txtPassword;

    @FXML private Label lblshow;

    @FXML
    void pressEnter(ActionEvent event) throws IOException {

        // check that username is right and
        //give the users info
        User user = DataBase.readUser(txtUsername.getText());
        if ( user == null )
            return;

        String userName = user.NationalCode;
        String passWord = user.Password;
        String userInput = txtUsername.getText();
        String passInput = txtPassword.getText();

        if (passInput.equals(passWord)) {
            error.setInfo("Access Granted" + "\n" + "please select an account");

            //go to account management page
            Stage stage = (Stage) btnEnter.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AccountManagement.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            return;
        } else{
            error.setError("Password is wrong!");
            return;
        }
    }
}



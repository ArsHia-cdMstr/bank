package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import server.*;

public class Signin  implements Initializable {

    @FXML private Label lblUsername;

    @FXML private Label lblPassword;

    @FXML private Button btnEnter;

    @FXML public TextField txtUsername = new TextField();

    @FXML private TextField txtPassword;

    private int count;


    @FXML
    void pressEnter(ActionEvent event) throws IOException {


        // check that username is right and
        //give the users info
        User user = DataBase.readUser(txtUsername.getText());
        if ( user == null )
            return;
        DataBase.userSaver(user);
        // we always call signUps
        // user so when we wanna
        //SignIn we should do this

        String passWord = DataBase.user.Password;
        String passInput = txtPassword.getText();

        if (passInput.equals(passWord)) {
            System.out.println("DataBase.user.NumberOfUserAccount = " + DataBase.user.NumberOfUserAccount);
            count = DataBase.user.NumberOfUserAccount;

            if (count == 0){
                error.setInfo("Access Granted" + "\n" + "please create an account");
                Stage stage = (Stage) btnEnter.getScene().getWindow();
                stage.close();
                Stage primaryStage=new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("OpeningAccount.fxml"));
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
            else {
                //go to account management page
                error.setInfo("Access Granted" + "\n" + "please select an account");
                Stage stage = (Stage) btnEnter.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("AccountManagement.fxml"));
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
                return;
            }

        } else{
            error.setError("Password is wrong!");
            return;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

    }
}



/**
 * Sample Skeleton for 'SignUp.fxml' Controller Class
 */

package sample;

import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUp {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtFirstName"
    private TextField txtFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="btnExit"
    private Button btnExit; // Value injected by FXMLLoader

    @FXML // fx:id="txtLastName"
    private TextField txtLastName; // Value injected by FXMLLoader

    @FXML // fx:id="txtNationalCode"
    private TextField txtNationalCode; // Value injected by FXMLLoader

    @FXML // fx:id="txtPhone"
    private TextField txtPhone; // Value injected by FXMLLoader

    @FXML // fx:id="txtEmail"
    private TextField txtEmail; // Value injected by FXMLLoader

    @FXML // fx:id="btnBack"
    private Button btnBack; // Value injected by FXMLLoader

    @FXML // fx:id="btnNext"
    private Button btnNext; // Value injected by FXMLLoader


    @FXML // fx:id="txtPassword1"
    private TextField txtPassword1; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassword2"
    private TextField txtPassword2; // Value injected by FXMLLoader

    @FXML // fx:id="checkShowPass"
    private CheckBox checkShowPass; // Value injected by FXMLLoader

    @FXML
    void pressBack(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void pressNext(ActionEvent event) {

        ArrayList<User> users = new ArrayList<>();

        //check that the passwords are the same or not
        boolean isThePasswordsTheSame = txtPassword1.getText().equals(txtPassword2);
        if(!isThePasswordsTheSame)
           /* Classname error .setErorr("the password aren't the same") */ ;

           //check that the gmail is correct or not
            isEmailCorrect(txtEmail.getText());

            //creating a user account
        users.add(new User(txtFirstName.getText(), txtLastName.getText(),txtPassword1.getText()
                ,txtNationalCode.getText(),txtEmail.getText(),txtPhone.getText()));



    }

    void isEmailCorrect (String Email){

        boolean isTheEndOfEmailCorrect = Email.substring(Email.lastIndexOf("@")).equals("@gmail.com");
        if (!isTheEndOfEmailCorrect)
            // erorr calssname .setErorr (" you havn't write the \'@gmail.com\' correct ");

            Email = "https://WWW." + Email;
        try {
            java.net.URL url = new java.net.URL(Email);
            Scanner input = new Scanner(url.openStream());
            System.out.println("google");
        } catch (Exception e) {
            // erorr calssname .setErorr (" the gmail isn't correct");
        }

    }

}





/**
 * Sample Skeleton for 'SignUp.fxml' Controller Class
 */

package sample;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import server.*;


public class SignUp {

    @FXML private TextField txtFirstName;

    @FXML private Button btnExit;

    @FXML private TextField txtLastName;

    @FXML private TextField txtNationalCode;

    @FXML private TextField txtPhone;

    @FXML private TextField txtEmail;

    @FXML private Button btnBack;

    @FXML private Button btnNext;

    @FXML private TextField txtPassword1;

    @FXML private TextField txtPassword2;

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
    void pressNext(ActionEvent event) throws IOException {

        //make sure that Users directory exists
        File UserDir = new File("Users");
        if (!UserDir.exists())
            UserDir.mkdir();

        if (!signUpIsCorrect())
            return;

        //creating a user account
        new User(txtFirstName.getText(), txtLastName.getText(),txtPassword1.getText()
                ,txtNationalCode.getText(),txtEmail.getText(),txtPhone.getText());

        // go to next page
        Stage stage =(Stage) btnNext.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("OpeningAccount.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    boolean signUpIsCorrect(){

        //check that the passwords are the same or not
        boolean isThePasswordsTheSame = txtPassword1.getText().equals(txtPassword2.getText());
        if(!isThePasswordsTheSame) {
             error.setError("the passwords aren't the same");
            return false;
        }

        //check that the gmail is correct or not
        if (!isEmailCorrect(txtEmail.getText()))
            return false;

        //check the user have already signed up or not
        if ( DataBase.isNationalCodeExist(txtNationalCode.getText()) )
            return false;

        // check that national number has only 10 index
        if (!nationalNumHas10Index(txtNationalCode.getText()))
            return false;

        //check that first/last name are only letters
        if (!(isonlyLetter(txtFirstName.getText()) && isonlyLetter(txtLastName.getText())))
            return false;

        //check that national code is only numberic
        if (!isOnlyNumber(txtNationalCode.getText()))
            return false;

        return true;
    }

    boolean isonlyLetter (String name){

        for (int i = 0; i < name.length(); i++) {

            if(!Character.isLetter(name.charAt(i))){
             error.setError("the first name of last name aren't letters \n pleas enter only letters ");
                return false;
            }
        }
        return true;
    }
    boolean isOnlyNumber (String code){

        for (int i = 0; i < code.length(); i++) {
            if(!isNumber(code.charAt(i))) {
                error.setError("the national code isn't fully numberic ");
                return false;
            }
        }
        return true;
    }
    boolean isNumber(char ch){
        return  ('0' <= (int)ch && (int)ch <= '9');
    }
    boolean nationalNumHas10Index (String nationalNum){
              if (nationalNum.length() == 10)
                  return  true;
              else {
                  error.setError("natioanl number haven't 10 index");
                    return false;
              }
    }
    boolean isEmailCorrect (String Email){

        try {
            // at the end of the
            boolean isTheEndOfEmailCorrect = Email.substring(Email.lastIndexOf(".")).equals(".com") &&
                    Email.contains("@");
            if (!isTheEndOfEmailCorrect) {
                error.setError(" you havn't write '@' or the '.com' ");
                return false;
            }
        }catch (IndexOutOfBoundsException e){
            error.setError("the gmail isn't correct");
            return false;
        }
//            Email = "https://WWW." + Email;
//        try {
//            java.net.URL url = new java.net.URL(Email);
//            Scanner input = new Scanner(url.openStream());
//        } catch (Exception e) {
//            return false;
//        }

        return true;
    }

}





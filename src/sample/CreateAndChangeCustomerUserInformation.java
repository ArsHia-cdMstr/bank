package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.DataBase;
import server.User;

import java.io.IOException;

public class CreateAndChangeCustomerUserInformation {

    @FXML
    private AnchorPane pene;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnDone;

    @FXML
    private TextField txtUsername;

    @FXML
    private Text txtFirstName;

    @FXML
    private Text txtLastName;

    @FXML
    private Text txtPhone;

    @FXML
    private Text txtEmail;

    @FXML
    private Text txtPassword;

    @FXML
    private TextField txtNewFirstName;

    @FXML
    private TextField txtNewLastName;

    @FXML
    private TextField txtNewPhone;

    @FXML
    private TextField txtNewEmail;

    @FXML
    private TextField txtNewPassword;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnBack;

    User user;
    @FXML
    void pressBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminFirstPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressSearch(ActionEvent event) {

        user = DataBase.readUser(txtUsername.getText());
        txtNewFirstName.setText(user.FirstName);
        txtNewLastName.setText(user.LastName);
        txtNewEmail.setText(user.Email);
        txtNewPassword.setText(user.Password);
        txtNewPhone.setText(user.Phone);

    }

    @FXML
    void pressDone(ActionEvent event) {

        user = DataBase.readUser(txtUsername.getText());
        user.FirstName = txtNewFirstName.getText();
        user.LastName = txtNewLastName.getText();
        user.Email = txtNewEmail.getText();
        user.Password = txtNewPassword.getText();
        user.Phone = txtNewPhone.getText();

    }

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

}



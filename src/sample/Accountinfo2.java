package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Accountinfo2 implements Initializable {

    @FXML
    private Button btnEnter = new Button();

    @FXML
    private PasswordField txtPassword = new PasswordField();

    @FXML
    private Label lblAlias = new Label();

    @FXML
    private Label lblAccNumber = new Label();

    @FXML
    private Button btnBack = new Button();

    @FXML
    void pressEnter(ActionEvent event) throws IOException {
        if (!(txtPassword.getText().equals(AccountManagement.choosenAccount.AccountPassword))) {
            error.setError("password is invalid!");
            return;
        }

        Stage stage = (Stage) btnEnter.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @FXML
    void pressBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AccountManagement.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lblAlias.setText(AccountManagement.choosenAccount.alias);
        lblAccNumber.setText(String.valueOf(AccountManagement.choosenAccount.AccountNum));
    }
}

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Accountinfo2 implements Initializable {

    @FXML
    private Button btnEnter;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblAlias;

    @FXML
    private Label lblAccNumber;

    @FXML
    void pressEnter(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnEnter.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


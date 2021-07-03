package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OpeningAccount implements Initializable {

    @FXML private Button btnExit = new Button();

    @FXML private ChoiceBox Ch1 = new ChoiceBox();

    @FXML private Button btnBack;

    @FXML private Button btnNext;


    @FXML
    void pressBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressNext(ActionEvent event) throws IOException {
        ///////////check////////////////


        error.setInfo("Welcome" + "\n" + "Your account opening has been successfully!");
        Stage stage = (Stage) btnNext.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AccountManagement.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void pressExit(ActionEvent event) throws IOException {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Ch1.getItems().add("Current account");
        Ch1.getItems().add("Long term account");
        Ch1.getItems().add("Short term account");
    }


    public void SelectType() throws IOException {
        String choice = (String) Ch1.getValue();
    }
}











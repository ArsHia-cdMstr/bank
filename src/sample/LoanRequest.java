package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoanRequest {

    @FXML private AnchorPane pene;

    @FXML private Button btnExit;

    @FXML private Button btnBack;

    @FXML private Button btnLoan1;

    @FXML private Button btnLoan2;

    @FXML private Button btnLoan3;

    @FXML private Button btnLoan4;

    @FXML void pressBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pressLoan1(ActionEvent event) {

    }

    @FXML
    void pressLoan2(ActionEvent event) {

    }

    @FXML
    void pressLoan3(ActionEvent event) {

    }

    @FXML
    void pressLoan4(ActionEvent event) {

    }

}

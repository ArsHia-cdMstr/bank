package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class List implements Initializable {

    @FXML private Button btnExit = new Button();

    @FXML private Button btnBack= new Button();

    @FXML private Label lbl = new Label();

    @FXML
    void pressBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Accountinfo3.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lbl.setText(String.valueOf(AccountManagement.choosenAccount.moneyTransfersList));
    }
}

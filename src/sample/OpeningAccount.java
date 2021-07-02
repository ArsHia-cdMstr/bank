package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class OpeningAccount implements Initializable {

    @FXML
    private Button btnExit;

    @FXML
    private ChoiceBox Ch1;


    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Ch1.getItems().add("Current account");
        Ch1.getItems().add("Long term account");
        Ch1.getItems().add("Short term account");
    }
}

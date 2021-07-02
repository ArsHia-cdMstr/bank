package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AccountInfo {

    @FXML // fx:id="btnExit"
    private Button btnExit; // Value injected by FXMLLoader

    @FXML // fx:id="btnacc1"
    private Button btnacc1; // Value injected by FXMLLoader

    @FXML // fx:id="btnacc3"
    private Button btnacc3; // Value injected by FXMLLoader

    @FXML // fx:id="btnacc2"
    private Button btnacc2; // Value injected by FXMLLoader

    @FXML // fx:id="btnacc5"
    private Button btnacc5; // Value injected by FXMLLoader

    @FXML // fx:id="btnacc4"
    private Button btnacc4; // Value injected by FXMLLoader

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pressacc1(ActionEvent event) {

    }

    @FXML
    void pressacc2(ActionEvent event) {

    }

    @FXML
    void pressacc3(ActionEvent event) {

    }

    @FXML
    void pressacc4(ActionEvent event) {

    }

    @FXML
    void pressacc5(ActionEvent event) {

    }

}

package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainPage {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnExit"
    private Button btnExit; // Value injected by FXMLLoader

    @FXML // fx:id="btnAccountManagement"
    private Button btnAccountManagement; // Value injected by FXMLLoader

    @FXML // fx:id="btnLoanRequest"
    private Button btnLoanRequest; // Value injected by FXMLLoader

    @FXML // fx:id="btnPayingBorrow"
    private Button btnPayingBorrow; // Value injected by FXMLLoader

    @FXML // fx:id="btnFundTransfers"
    private Button btnFundTransfers; // Value injected by FXMLLoader

    @FXML // fx:id="btnFrequentlyUsedAccounts"
    private Button btnFrequentlyUsedAccounts; // Value injected by FXMLLoader

    @FXML // fx:id="btnAccountInformation"
    private Button btnAccountInformation; // Value injected by FXMLLoader

    @FXML // fx:id="btnCloseAnAccount"
    private Button btnCloseAnAccount; // Value injected by FXMLLoader

    @FXML
    void pressAccountInformation(ActionEvent event) {

    }

    @FXML
    void pressAccountManagement(ActionEvent event) {

    }

    @FXML
    void pressCloseAnAccount(ActionEvent event) {

    }

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pressFrequentlyUsedAccounts(ActionEvent event) {

    }

    @FXML
    void pressFundTransfers(ActionEvent event) {

    }

    @FXML
    void pressLoanRequest(ActionEvent event) {

    }

    @FXML
    void pressPayingBorrow(ActionEvent event) {

    }
}

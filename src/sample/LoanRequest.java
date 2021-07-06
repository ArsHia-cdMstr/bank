package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import server.Loan;
import sun.swing.AccumulativeRunnable;

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

        Loan loan = new Loan (1.15, 1000 , 6 , AccountManagement.choosenAccount.AccountNum);
    }

    @FXML
    void pressLoan2(ActionEvent event) {

        Loan loan = new Loan(1.25, 15000, 12, AccountManagement.choosenAccount.AccountNum);
    }

    @FXML
    void pressLoan3(ActionEvent event) {
        Loan loan = new Loan( 1.20,12500, 8, AccountManagement.choosenAccount.AccountNum );
    }

    @FXML
    void pressLoan4(ActionEvent event) {
        Loan loan = new Loan(1.24, 20000, 24, AccountManagement.choosenAccount.AccountNum);
    }

}

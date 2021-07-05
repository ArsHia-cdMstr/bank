package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class PayingBorrow {


    @FXML
    private AnchorPane pene;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnProcessing;

    @FXML
    private Button btnPay;

    @FXML
    private TextField txtBillID;

    @FXML
    private TextField txtpaymentID;

    @FXML
    private Text txtAmount;

    private boolean checkPay = false;
    private boolean checkProcessing = true;

    @FXML
    void pressBack(ActionEvent event) throws IOException {
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
    void pressPay(ActionEvent event) throws IOException {
        if (checkPay) {
            error.setInfo("Your bill has been paid!"+"\n"+
                    txtAmount.getText() + "$ has been deducted from your account" );
            Stage stage = (Stage) btnPay.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    }
    @FXML
    void pressProcessing(ActionEvent event) {
        if (checkProcessing) {
            char ch1, ch2;
            if (txtpaymentID.getText().length() != 6) {
                error.setError("payment ID haven't 6 index!");
                return;
            }
            if (txtBillID.getText().length() != 6) {
                error.setError("bill ID haven't 6 index!");
                return;
            }

            for (int i = 0; i < 6; i++) {
                ch1 = txtpaymentID.getText().charAt(i);
                ch2 = txtBillID.getText().charAt(i);
                if (!('0' <= (int) ch1 && (int) ch1 <= '9')) {
                    error.setError("payment ID is incorrect!");
                    return;
                }
                if (!('0' <= (int) ch2 && (int) ch2 <= '9')) {
                    error.setError("bill ID is incorrect!");
                    return;
                }
            }

            checkPay = true;
            checkProcessing = false;
            Random rand = new Random();
            txtAmount.setText(String.valueOf(rand.nextInt(151) + 50));
        }
    }

}

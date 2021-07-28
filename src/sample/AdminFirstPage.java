package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class AdminFirstPage {

    @FXML
    private AnchorPane pene = new AnchorPane();

    @FXML
    private Button btnBalance = new Button();

    @FXML
    private Button btnTransfer = new Button();

    @FXML
    private Button btnView = new Button();

    @FXML
    private Button btnChangeInfo = new Button();

    @FXML
    private Button btnOpenClose = new Button();

    @FXML
    private Button btnExit = new Button();

    @FXML
    void PressView(ActionEvent event) {
        error.setError("under construction");
    }

    @FXML
    void pressBalance(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBalance.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("ChangeAccountBalance.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressChangeInfo(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnChangeInfo.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("CreateAndChangeCustomerUserInformation.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pressOpenClose(ActionEvent event) {

        error.setError("under construction");
    }

    @FXML
    void pressTransfer(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnTransfer.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("TransferFundsBetweenAccounts.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

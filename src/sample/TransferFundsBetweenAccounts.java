package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import server.Account;
import server.DataBase;

import java.io.IOException;

public class TransferFundsBetweenAccounts {

    @FXML
    private AnchorPane pene;

    @FXML
    private Button btnDone= new Button();

    @FXML
    private Button btnExit= new Button();

    @FXML
    private TextField txtOrigin= new TextField();

    @FXML
    private TextField txtDistination= new TextField();

    @FXML
    private TextField txtAmount= new TextField();

    @FXML
    private Button btnBack= new Button();

    @FXML
    void pressBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminFirstPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressDone(ActionEvent event) throws IOException {

        error.setInfo("trandfer done!");

        Account a1 = DataBase.readAccount(Integer.parseInt(txtOrigin.getText()));
        Account a2 = DataBase.readAccount(Integer.parseInt(txtDistination.getText()));
        int amount = Integer.parseInt(txtAmount.getText());
        a1.withdraw(amount);
        a2.Deposit(amount);
        DataBase.printnewAccount(a1);
        DataBase.printnewAccount(a2);


        Stage stage = (Stage) btnDone.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminFirstPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

}

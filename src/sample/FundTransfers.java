package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import server.Account;
import server.DataBase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FundTransfers implements Initializable {

    @FXML private AnchorPane pene = new AnchorPane();

    @FXML private Button btnExit = new Button();

    @FXML private TextField txtDistination = new TextField();

    @FXML private PasswordField txtPassword = new PasswordField();

    @FXML private ChoiceBox boxDistination = new ChoiceBox();

    @FXML private Button btnBack= new Button();

    @FXML private TextField txtAmount = new TextField();

    @FXML private Button btnSend= new Button();

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
    void pressSend(ActionEvent event) {
//        if (!(boxDistination.getValue().equals(null))){
//            txtDistination.setText((String) boxDistination.getValue());
//        }
        Account account;
        account = DataBase.readAccount(Integer.valueOf(txtDistination.getText()));
        if (!(AccountManagement.choosenAccount.AccountPassword.equals(txtPassword.getText()))){
            error.setError("your password is invalid!");
            return;
        }
        AccountManagement.choosenAccount.withdraw(Integer.parseInt(txtAmount.getText()));
        System.out.println(Integer.parseInt(txtAmount.getText()));
        System.out.println(txtAmount.getText());
        account.Deposit(Integer.parseInt(txtAmount.getText()));
        DataBase.printnewAccount(account);
        DataBase.printnewAccount(AccountManagement.choosenAccount);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // insert Choice box value
    }
}

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
import server.UsedAccount;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    int choosenUsedAccount = 0;

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
    void pressSend(ActionEvent event) throws IOException {
//        if (!(boxDistination.getValue().equals(null))){
//            txtDistination.setText((String) boxDistination.getValue());
//        }


        Account account;
        account = DataBase.readAccount(Integer.valueOf(txtDistination.getText()));
        if (account == null)
            return;

        if (!(AccountManagement.choosenAccount.AccountPassword.equals(txtPassword.getText()))){
            error.setError("your password is invalid!");
            return;
        }
        AccountManagement.choosenAccount.withdraw(Integer.parseInt(txtAmount.getText()));
        account.Deposit(Integer.parseInt(txtAmount.getText()));

        account.usedAccount.add(new UsedAccount(Integer.parseInt(txtAmount.getText())));
        DataBase.printnewAccount(account);
        DataBase.printnewAccount(AccountManagement.choosenAccount);

        error.setInfo("Transfer completed successfully!");
        Stage stage = (Stage) btnSend.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<UsedAccount> usedAccount = AccountManagement.choosenAccount.usedAccount;
        int sizeOfArrayList = usedAccount.size();
        switch (sizeOfArrayList) {
            case 0:
                break;
            case 1:
                boxDistination.getItems().add(usedAccount.get(sizeOfArrayList - 1).Alias);
                break;
            case 2:
                boxDistination.getItems().add(usedAccount.get(sizeOfArrayList - 1).Alias);
                boxDistination.getItems().add(usedAccount.get(sizeOfArrayList - 2).Alias);
                break;
            default:
                boxDistination.getItems().add(usedAccount.get(sizeOfArrayList - 1).Alias);
                boxDistination.getItems().add(usedAccount.get(sizeOfArrayList - 2).Alias);
                boxDistination.getItems().add(usedAccount.get(sizeOfArrayList - 3).Alias);
                break;
        }

        if (boxDistination.getValue() != null){
            String destionationNumber = (String) boxDistination.getValue();

            if (destionationNumber == usedAccount.get(sizeOfArrayList - 1).Alias){
                choosenUsedAccount = usedAccount.get(sizeOfArrayList - 1).usedAccountNumber;
            }else if (destionationNumber == usedAccount.get(sizeOfArrayList - 2).Alias) {
                choosenUsedAccount = usedAccount.get(sizeOfArrayList - 1).usedAccountNumber;
            }else if (destionationNumber == usedAccount.get(sizeOfArrayList - 3).Alias) {
                choosenUsedAccount = usedAccount.get(sizeOfArrayList - 1).usedAccountNumber;
            }

            if(choosenUsedAccount != 0)
                txtDistination.setText(String.valueOf(choosenUsedAccount));
        }
    }
}

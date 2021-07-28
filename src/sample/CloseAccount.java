package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CloseAccount implements Initializable {

    @FXML private AnchorPane pene = new AnchorPane();

    @FXML private Button btnExit;

    @FXML private Text txtBalance;

    @FXML private TextField txtDistination;

    @FXML private PasswordField txtPassword;

    @FXML private ChoiceBox boxDistination = new ChoiceBox();;

    @FXML private Button btnBack;

    @FXML private Button btnNext;

    private int balance;
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

    int choosenUsedAccount ;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        balance = AccountManagement.choosenAccount.getBalance();

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


        if (boxDistination.getValue() != null) {
            String destionationNumber = (String) boxDistination.getValue();

            if (destionationNumber == usedAccount.get(sizeOfArrayList - 1).Alias) {
                choosenUsedAccount = usedAccount.get(sizeOfArrayList - 1).usedAccountNumber;
            } else if (destionationNumber == usedAccount.get(sizeOfArrayList - 2).Alias) {
                choosenUsedAccount = usedAccount.get(sizeOfArrayList - 1).usedAccountNumber;
            } else if (destionationNumber == usedAccount.get(sizeOfArrayList - 3).Alias) {
                choosenUsedAccount = usedAccount.get(sizeOfArrayList - 1).usedAccountNumber;
            }

            if (choosenUsedAccount != 0)
                txtDistination.setText(String.valueOf(choosenUsedAccount));
        }
        txtBalance.setText(String.valueOf(balance));
        if (balance == 0) {
            error.setInfo("please enter your password account!");
            pene.getChildren().remove(txtDistination);
            pene.getChildren().remove(boxDistination);
        } else {
            error.setInfo("please enter your distination acount and your password account!");
        }
    }

    @FXML
    void pressNext(ActionEvent event) throws IOException {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to close the account?");
        alert.showAndWait();

        if (alert.getResult().getText().equals("OK")){

            Account account;
            account = DataBase.readAccount(Integer.valueOf(txtDistination.getText()));
            if (!(account.AccountPassword.equals(txtPassword.getText()))){
                error.setError("your password is invalid!");
                return;
            }

            account.Deposit(balance);
            account.usedAccount.add(new UsedAccount(balance));

            DataBase.deleteAccount(AccountManagement.choosenAccount);
            DataBase.printnewAccount(account);

            Stage stage = (Stage) btnNext.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AccountManagement.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }

    }
}


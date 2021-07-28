package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import server.DataBase;
import server.UsedAccount;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FrequentlyUsedAccounts implements Initializable {


    @FXML
    private Button btnExit = new Button();

    @FXML
    private Button btnBack = new Button();

    @FXML
    private ChoiceBox Ch1 = new ChoiceBox();

    @FXML
    private TextField txtNewAlias = new TextField();

    @FXML
    private Button btnDone = new Button();

    int indexOfChoosenAccount = -1 ;
    ArrayList<UsedAccount> usedAccount;


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
    void pressDone(ActionEvent event) throws IOException {

        if (indexOfChoosenAccount == -1){
            error.setError("please choose an account");
            return;
        }

        DataBase.changeDestinationAlias(usedAccount,usedAccount.get(indexOfChoosenAccount).usedAccountNumber
        ,usedAccount.get(indexOfChoosenAccount).Alias);

        DataBase.printnewAccount(AccountManagement.choosenAccount);



        error.setInfo("Your distination acount seted");
        Stage stage = (Stage) btnDone.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usedAccount  = AccountManagement.choosenAccount.usedAccount;
        int sizeOfArrayList = usedAccount.size();
        switch (sizeOfArrayList) {
            case 0:
                break;
            case 1:
                Ch1.getItems().add(usedAccount.get(sizeOfArrayList - 1).Alias);
                break;
            case 2:
                Ch1.getItems().add(usedAccount.get(sizeOfArrayList - 1).Alias);
                Ch1.getItems().add(usedAccount.get(sizeOfArrayList - 2).Alias);
                break;
            default:
                Ch1.getItems().add(usedAccount.get(sizeOfArrayList - 1).Alias);
                Ch1.getItems().add(usedAccount.get(sizeOfArrayList - 2).Alias);
                Ch1.getItems().add(usedAccount.get(sizeOfArrayList - 3).Alias);
                break;
        }

        if (Ch1.getValue() != null){
            String destionationNumber = (String) Ch1.getValue();

            if (destionationNumber == usedAccount.get(sizeOfArrayList - 1).Alias){
                indexOfChoosenAccount = sizeOfArrayList-1;
            }else if (destionationNumber == usedAccount.get(sizeOfArrayList - 2).Alias) {
                indexOfChoosenAccount = sizeOfArrayList-2;
            }else if (destionationNumber == usedAccount.get(sizeOfArrayList - 3).Alias) {
                indexOfChoosenAccount = sizeOfArrayList-3;
            }

        }
    }
}

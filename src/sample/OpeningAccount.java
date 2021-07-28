package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import server.DataBase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import server.*;


public class OpeningAccount extends Signin implements Initializable {

    @FXML
    private Button btnExit = new Button();

    @FXML
    private ChoiceBox Ch1 = new ChoiceBox();

    @FXML
    private Button btnBack = new Button();

    @FXML
    private Button btnNext = new Button();

    @FXML
    private TextField txtPassword1 = new TextField();

    @FXML
    private TextField txtPassword2 = new TextField();

    @FXML
    private TextField txtAlias = new TextField();

    @FXML
    private TextField txtInitialBalance = new TextField();

    private char Type;

    @FXML
    void pressBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressNext(ActionEvent event) throws IOException {
//check that passwords are the same or not
        if (!txtPassword1.getText().equals(txtPassword2.getText())) {
            error.setError("passwords aren't the same");
            return;
        }

        // pass needs to have 4 index
        nameXHasNIndex(txtPassword1.getText(), 4);


        try {
            int initialBalance = Integer.parseInt(txtInitialBalance.getText());
        } catch (NumberFormatException e) {
            error.setError("pleas Enter the initial balance correctly!");
            return;
        }

        // the balance hasn't more than 7 digits
        if (!((txtInitialBalance.getText()).length() < 8)){
            error.setError("please enter the balance lower than 10e8 ");
            return;
        }

// check that initial balance isn't null or letter
        try {
            String choice = (String) Ch1.getValue();

            switch (choice) {
                case "Current account":
                    Type = 'c';
                    break;
                case "Long term account":
                    Type = 'l';
                    break;
                case "Short term account":
                    Type = 's';
                    break;
            }
            Account account;
            switch (Type) {
                case 'c':
                    account = new CurrentAccount(Integer.parseInt(txtInitialBalance.getText()), txtPassword1.getText());
                    DataBase.printnewAccount(account);
                    break;
                case 'l':
                    account = new LongTermAccount(Integer.parseInt(txtInitialBalance.getText()), txtPassword1.getText());
                    DataBase.printnewAccount(account);
                    break;
                case 's':
                    account = new ShortTermAccount(Integer.parseInt(txtInitialBalance.getText()), txtPassword1.getText());
                    DataBase.printnewAccount(account);
                    break;
                default:
                    error.setError("please use the type of account");
                    return;
            }

            if (txtAlias.getText().length() > 0) {
                if (!(account.changeAlias(account.alias, txtAlias.getText(), account))) {
                    return;
                }
            }
        } catch (NullPointerException e) {
            error.setError("please select the type of account ");
            return;
        }

        error.setInfo("Welcome" + "\n" + "Your account opening has been successfully!");
        Stage stage = (Stage) btnNext.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AccountManagement.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void pressExit(ActionEvent event) throws IOException {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Ch1.getItems().add("Current account");
        Ch1.getItems().add("Long term account");
        Ch1.getItems().add("Short term account");

    }

    boolean nameXHasNIndex(String name, int indexLimit) {
        if (name.length() == indexLimit)
            return true;
        else {
            error.setError(name + " haven't" + indexLimit + " index");
            return false;
        }
    }

}

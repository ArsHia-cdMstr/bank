package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.omg.CORBA.WCharSeqHelper;
import server.DataBase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import server.*;

public class AccountManagement implements Initializable {

    @FXML public AnchorPane pene1 = new AnchorPane();

    @FXML private Button btnExit;

    @FXML private Button btnacc1;

    @FXML private Button btnacc2;

    @FXML private Button btnacc3;

    @FXML private Button btnacc4;

    @FXML public Button btnacc5;

    @FXML private Button btnOpenNew;

    public static Account choosenAccount;

    private int count;

    ArrayList<String> alias = DataBase.readAlias(DataBase.user.NationalCode);

    public void deleting() {
        if (count == 4) {
            pene1.getChildren().remove(btnacc5);
        } else if (count == 3) {
            pene1.getChildren().remove(btnacc5);
            pene1.getChildren().remove(btnacc4);
        } else if (count == 2) {
            pene1.getChildren().remove(btnacc5);
            pene1.getChildren().remove(btnacc4);
            pene1.getChildren().remove(btnacc3);
        } else if (count == 1) {
            pene1.getChildren().remove(btnacc5);
            pene1.getChildren().remove(btnacc4);
            pene1.getChildren().remove(btnacc3);
            pene1.getChildren().remove(btnacc2);
        }else if (count == 0) {
            pene1.getChildren().remove(btnacc5);
            pene1.getChildren().remove(btnacc4);
            pene1.getChildren().remove(btnacc3);
            pene1.getChildren().remove(btnacc2);
            pene1.getChildren().remove(btnacc1);

        }
    }


    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pressacc1(ActionEvent event) throws IOException {
        choosenAccount = DataBase.readAccount(alias.get(0));
        System.out.println(choosenAccount);
        Stage stage = (Stage) btnacc1.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Accountinfo2.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressacc2(ActionEvent event) throws IOException {
        choosenAccount = DataBase.readAccount(alias.get(1));
        Stage stage = (Stage) btnacc2.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Accountinfo2.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressacc3(ActionEvent event) throws IOException {
        choosenAccount =DataBase.readAccount(alias.get(2));
        Stage stage = (Stage) btnacc3.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Accountinfo2.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressacc4(ActionEvent event) throws IOException {
        choosenAccount =DataBase.readAccount(alias.get(3));
        Stage stage = (Stage) btnacc4.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Accountinfo2.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressacc5(ActionEvent event) throws IOException {
        choosenAccount =DataBase.readAccount(alias.get(4));
        Stage stage = (Stage) btnacc5.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Accountinfo2.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        count = DataBase.user.NumberOfUserAccount;
        deleting();

        Account account ;
        switch (count){
            case 5:
                account = DataBase.readAccount(alias.get(0));
                btnacc1.setText("alias :  " + alias.get(0) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(1));
                btnacc2.setText("alias :  " + alias.get(1) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(2));
                btnacc3.setText("alias :  " + alias.get(2) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(3));
                btnacc4.setText("alias :  " + alias.get(3) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(4));
                btnacc5.setText("alias :  " + alias.get(4) +"\n"+ "acount number :  " + account.AccountNum);
                break;
            case 4:
                account = DataBase.readAccount(alias.get(0));
                btnacc1.setText("alias :  " + alias.get(0) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(1));
                btnacc2.setText("alias :  " + alias.get(1) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(2));
                btnacc3.setText("alias :  " + alias.get(2) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(3));
                btnacc4.setText("alias :  " + alias.get(3) +"\n"+ "acount number :  " + account.AccountNum);
                break;
            case 3:
                account = DataBase.readAccount(alias.get(0));
                btnacc1.setText("alias :  " + alias.get(0) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(1));
                btnacc2.setText("alias :  " + alias.get(1) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(2));
                btnacc3.setText("alias :  " + alias.get(2) +"\n"+ "acount number :  " + account.AccountNum);
                break;
            case 2:
                account = DataBase.readAccount(alias.get(0));
                btnacc1.setText("alias :  " + alias.get(0) +"\n"+ "acount number :  " + account.AccountNum);
                account = DataBase.readAccount(alias.get(1));
                btnacc2.setText("alias :  " + alias.get(1) +"\n"+ "acount number :  " + account.AccountNum);
                break;
            case 1:
                account = DataBase.readAccount(alias.get(0));
                btnacc1.setText("alias :  " + alias.get(0) +"\n"+ "acount number :  " + account.AccountNum);
                break;

        }
    }
    @FXML
    void pressOpenNew(ActionEvent event) throws IOException {
        Stage stage =(Stage) btnOpenNew.getScene().getWindow();
        stage.close();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("OpeningAccount.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
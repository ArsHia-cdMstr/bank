package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.Account;
import server.DataBase;

import java.io.IOException;

public class ChangeAccountBalance {

    @FXML
    private AnchorPane pene;

    @FXML
    private Button btnSearch = new Button();

    @FXML
    private Button btnDone = new Button();

    @FXML
    private Button btnExit = new Button();

    @FXML
    private TextField txtUsername = new TextField();

    @FXML
    private Text txtBalance= new Text();

    @FXML
    private TextField txtNewBalance = new TextField();

    @FXML
    private Button btnBack= new Button();


    @FXML
    void pressDone(ActionEvent event) throws IOException {

        error.setInfo("balance Updated");

        if (txtUsername.getText().length() < 1){
            return;
        }
        Account account = DataBase.readAccount(Integer.parseInt(txtUsername.getText()));


        int n = Integer.parseInt(txtNewBalance.getText());
        account.setBalance(n);
        DataBase.printnewAccount(account);


        Stage stage = (Stage) btnBack.getScene().getWindow();
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
    void pressSearch(ActionEvent event) {
        Account account = DataBase.readAccount(Integer.parseInt(txtUsername.getText()));

        txtBalance.setText(String.valueOf(account.getBalance()));
    }

}

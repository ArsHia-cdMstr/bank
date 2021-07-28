package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import server.DataBase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Accountinfo3 implements Initializable {


        @FXML private AnchorPane pene1;

        @FXML private Button btnExit;

        @FXML private Label txtType = new Label();

        @FXML private Button btnBalance;

        @FXML private Button btnList;

        @FXML private Label txtAcountNum = new Label();

        @FXML private Label txtAlias = new Label();

        @FXML private Button btnBack;

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
        void pressBalance(ActionEvent event) {
                error.setInfo("balance : " + AccountManagement.choosenAccount.getBalance() + "$");
        }

        @FXML
        void pressExit(ActionEvent event) {
                System.exit(0);
        }

        @FXML
        void pressList(ActionEvent event) throws IOException {
                Stage stage = (Stage) btnList.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
                primaryStage.setScene(new Scene(root));
                primaryStage.show();

        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                txtType.setText(AccountManagement.choosenAccount.getClass().getSimpleName());
                txtAcountNum.setText(String.valueOf(AccountManagement.choosenAccount.AccountNum));
                txtAlias.setText(String.valueOf(AccountManagement.choosenAccount.alias));
        }
}
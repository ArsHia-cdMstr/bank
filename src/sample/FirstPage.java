package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import server.Loan;

public class FirstPage implements Initializable {

    @FXML private Button btnSignin;

    @FXML private Button btnExit;

    @FXML private Button btnAdminPortal;

    @FXML private Button btnCreateAccount;

    @FXML
    void pressAdminPortal(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnAdminPortal.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("SigninAdmin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressCreateAccount(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCreateAccount.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressExit(ActionEvent event) throws IOException {
        System.exit(0);
//        Stage stage = (Stage) btnExit.getScene().getWindow();
//        stage.close();
//        Stage primaryStage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("LoanRequest.fxml"));
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
    }

    @FXML
    void pressSignin(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnSignin.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Signin.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

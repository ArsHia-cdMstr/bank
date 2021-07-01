package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FirstPage {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnSignin"
    private Button btnSignin; // Value injected by FXMLLoader

    @FXML // fx:id="btnExit"
    private Button btnExit; // Value injected by FXMLLoader

    @FXML // fx:id="btnAdminPortal"
    private Button btnAdminPortal; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreateAccount"
    private Button btnCreateAccount; // Value injected by FXMLLoader

    @FXML
    void pressAdminPortal(ActionEvent event) {

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
    void pressExit(ActionEvent event) {
        System.exit(0);

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


}

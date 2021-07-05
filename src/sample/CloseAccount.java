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

import java.io.IOException;
import java.net.URL;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int balance = 10;

        boxDistination.getItems().add("15454165");
        boxDistination.getItems().add("16515165");
        boxDistination.getItems().add("45416516");



        txtBalance.setText(String.valueOf(balance));
        if (balance == 0){
            error.setInfo("please enter your password account!");
            pene.getChildren().remove(txtDistination);
            pene.getChildren().remove(boxDistination);
        }
        else{
            error.setInfo("please enter your distination acount and your password account!");
        }
    }

    @FXML
    void pressNext(ActionEvent event) throws IOException {

        if (!boxDistination.getValue().equals(null)){
            txtDistination.setText((String) boxDistination.getValue());
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to close the account?");
        alert.showAndWait();

        if (alert.getResult().getText().equals("OK")){
            Stage stage = (Stage) btnNext.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AccountManagement.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            /////////////////



            //deleting


            ///////////////////
        }

    }
}


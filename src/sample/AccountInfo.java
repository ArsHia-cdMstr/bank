package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Accountinfo implements Initializable {

    @FXML public AnchorPane pene1 = new AnchorPane();

    @FXML private Button btnExit;

    @FXML private Button btnacc1;

    @FXML private Button btnacc2;

    @FXML private Button btnacc3;

    @FXML private Button btnacc4;

    @FXML public Button btnacc5 = new Button();

    int count = 2;

    public Accountinfo() {
        pene1.getChildren().remove(btnacc5);

    }

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
        }
    }


    @FXML
    void pressExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pressacc1(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Accountinfo2.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressacc2(ActionEvent event) throws IOException {

    }

    @FXML
    void pressacc3(ActionEvent event) {

    }

    @FXML
    void pressacc4(ActionEvent event) {

    }

    @FXML
    void pressacc5(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deleting();
    }

}

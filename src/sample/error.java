package sample;

import java.io.IOException;
import javafx.scene.control.Alert;

public class error {

    public static void setError(String Massage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(Massage);
        alert.showAndWait();
    }

    public static void setWarning(String Massage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText(Massage);
        alert.showAndWait();
    }
    public static void setInfo(String Massage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText(Massage);
        alert.showAndWait();
    }
    public static void setConfirm(String Massage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText(Massage);
        alert.showAndWait();
    }

}

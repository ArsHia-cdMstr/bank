package sample;

import java.io.IOException;
import javafx.scene.control.Alert;

public class error {

    public static void setError(String Massage)  {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Erorr: " + Massage);
        alert.showAndWait();
    }

    public static void setWarning(String Massage)  {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText("Warning: " + Massage);
        alert.showAndWait();
    }

}

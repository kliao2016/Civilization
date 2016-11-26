package view;

import javafx.scene.control.Alert;

public class NoActionAlert {

    private static Alert actionAlert;
    private static String message;

    public static void displayAlert() {
        message = new String("You cannot perform this action!");
        actionAlert = new Alert(Alert.AlertType.ERROR, message);
        actionAlert.showAndWait();
    }
}
package view;

import javafx.scene.control.Alert;

public class NoActionAlert {

    private static Alert actionAlert;
    private static String message;

    public static void displayAlert() {
        setMessage(message);
        actionAlert = new Alert(Alert.AlertType.ERROR, message);
        actionAlert.showAndWait();
    }

    public static void setMessage(String newMessage) {
        message = newMessage;
    }
}
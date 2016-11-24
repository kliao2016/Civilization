package view;

import controller.GameController;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Button;

public class NewSettlementPrompt {

    private static TextInputDialog settle = new TextInputDialog();

    public static void newSettlementAlert() {
        settle.setTitle("Your New Settlement");
        settle.setHeaderText("You have built a Settlement!");
        settle.setContentText("Enter the name of your first town");
        settle.showAndWait();
    }

    public static TextInputDialog getText() {
        return settle;
    }

    public static Button getDialogButton() {
        return (Button) settle.getDialogPane().lookupButton(ButtonType.OK);
    }
}
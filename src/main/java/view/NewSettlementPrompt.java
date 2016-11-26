package view;

import javafx.scene.control.TextInputDialog;

public class NewSettlementPrompt {

    private static TextInputDialog settle;

    public static void newSettlementAlert() {
        settle = new TextInputDialog();
        settle.setTitle("Your New Settlement");
        settle.setHeaderText("You have built a Settlement!");
        settle.setContentText("Enter the name of your first town");
        settle.showAndWait();
    }

    public static TextInputDialog getText() {
        return settle;
    }
}
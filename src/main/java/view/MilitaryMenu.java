package view;

import controller.GameController;
import javafx.scene.control.Button;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {

    private Button attackButton = new Button("Attack");
    private Button moveButton = new Button("Move");
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        attackButton.setOnMousePressed(e -> {
                GameController.attacking();
                if (GameController.getGameState()
                    != GameController.GameState.NEUTRAL) {
                    NoActionAlert.displayAlert();
                }
                GameController.updateResourcesBar();
            });

        moveButton.setOnMousePressed(e -> {
                GameController.moving();
                if (GameController.getGameState()
                    != GameController.GameState.NEUTRAL) {
                    NoActionAlert.displayAlert();
                }
            });
        addMenuItem(attackButton);
        addMenuItem(moveButton);
    }
}

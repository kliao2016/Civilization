package view;

import controller.GameController;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import model.MapObject;
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
                MapObject occup = GameController.getLastClicked().getTile()
                                                                 .getOccupant();
                GameController.attacking();
                GameController.getLastClicked().getOverlay()
                                               .setStroke(Color.RED);
                GameController.updateResourcesBar();
            });

        moveButton.setOnMousePressed(e -> {
                MapObject occup = GameController.getLastClicked().getTile()
                                                                 .getOccupant();
                GameController.getLastClicked().getOverlay()
                                               .setStroke(Color.LIME);
                GameController.moving();
            });
        attackButton.setStyle("-fx-base: #FF0000;");
        moveButton.setStyle("-fx-base: #00FF00");
        addMenuItem(attackButton);
        addMenuItem(moveButton);
    }
}

package view;

import controller.GameController;
import javafx.scene.control.Button;
import model.MapObject;
import model.MilitaryUnit;

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
                if (occup.isMilitaryUnit()
                    && !((MilitaryUnit) occup).getCanAttack()){
                    NoActionAlert.displayAlert();
                }
                GameController.updateResourcesBar();
            });

        moveButton.setOnMousePressed(e -> {
                MapObject occup = GameController.getLastClicked().getTile()
                                                                 .getOccupant();
                GameController.moving();
                if (occup.isMilitaryUnit()
                    && !((MilitaryUnit) occup)
                    .canMove(((MilitaryUnit) occup).getBaseEndurance())) {
                    NoActionAlert.displayAlert();
                }
            });
        addMenuItem(attackButton);
        addMenuItem(moveButton);
    }
}

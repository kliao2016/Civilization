package view;

import controller.GameController;
import javafx.scene.control.Button;
import model.Building;
import model.Settlement;
import model.MapObject;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {

    private Button investButton = new Button("Invest");
    private Button demolishButton = new Button("Demolish");
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        investButton.setOnMousePressed(e -> {
                MapObject occup = GameController.getLastClicked()
                                                .getTile()
                                                .getOccupant();
                if (GameController.getCivilization().getTreasury().getCoins()
                    < 25) {
                    NoActionAlert.displayAlert();
                } else {
                    ((Settlement) occup).invest();
                    GameController.updateResourcesBar();
                }
            });
        demolishButton.setOnMousePressed(e -> {
                MapObject occup = GameController.getLastClicked()
                                                .getTile()
                                                .getOccupant();
                if (GameController.getCivilization().getNumSettlements() <= 1) {
                    NoActionAlert.displayAlert();
                } else {
                    if (GameController.getLastClicked().getTile().getOccupant()
                        instanceof Settlement) {
                        ((Building) occup).demolish();
                    } else {
                        NoActionAlert.displayAlert();
                    }
                }
            });
        addMenuItem(investButton);
        addMenuItem(demolishButton);
    }
}

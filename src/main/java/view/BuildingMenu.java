package view;

import controller.GameController;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import model.Building;
import model.MapObject;
import model.Settlement;

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
                    GameController.getLastClicked().getOverlay()
                                                   .setStroke(Color.GREEN);
                    ((Building) occup).invest();
                    GameController.getCivilization().getTreasury().spend(25);
                    GameController.updateResourcesBar();
                }
            });
        demolishButton.setOnMousePressed(e -> {
                MapObject occup = GameController.getLastClicked()
                                                .getTile()
                                                .getOccupant();
                if (GameController.getCivilization().getNumSettlements() <= 1
                    && occup instanceof Settlement) {
                    NoActionAlert.displayAlert();
                } else {
                    if (occup instanceof Settlement) {
                        ((Settlement) occup).demolish();
                        GameController.getLastClicked().getTile()
                                                       .setOccupant(null);
                        GameController.getCivilization()
                                      .decrementNumSettlements();
                        GameController.getLastClicked().updateTileView();
                        GameController.setLastClicked(
                                            GameController.getLastClicked());
                        GameController.updateResourcesBar();
                    } else {
                        ((Building) occup).demolish();
                        GameController.getLastClicked().getTile()
                                                       .setOccupant(null);
                        GameController.getLastClicked().updateTileView();
                        GameController.setLastClicked(
                                            GameController.getLastClicked());
                        GameController.updateResourcesBar();
                    }
                }
            });
        investButton.setStyle("-fx-base: #00FF00;");
        demolishButton.setStyle("-fx-base: #FF0000");
        addMenuItem(investButton);
        addMenuItem(demolishButton);
    }
}

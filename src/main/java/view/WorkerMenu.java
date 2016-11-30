package view;

import controller.GameController;
import controller.TileType;
import model.Convertable;
import model.MapObject;
import model.TerrainTile;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {

    private Button moveButton = new Button("Move");
    private Button convertButton = new Button("Convert");
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        moveButton.setOnMousePressed(e -> {
                MapObject occup = GameController.getLastClicked().getTile()
                                                                 .getOccupant();
                GameController.moving();
                GameController.getLastClicked().getOverlay()
                                               .setStroke(Color.LIME);
            });
        convertButton.setOnMousePressed(e -> {
                TerrainTile tile = GameController.getLastClicked().getTile();
                MapObject occupant = tile.getOccupant();
                TileType type = tile.getType();
                if (occupant.isWorker()
                    && ((Convertable) occupant).canConvert(type)) {
                    tile.setOccupant(((Convertable) occupant).convert());
                    GameController.setLastClicked(
                                        GameController.getLastClicked());
                    GameController.getLastClicked().updateTileView();
                } else {
                    NoActionAlert.setMessage("Could not convert. "
                                             + "Please make sure "
                                             + "the unit is on the correct "
                                             + "terrain.");
                    NoActionAlert.displayAlert();
                }
                GameController.updateResourcesBar();
            });
        moveButton.setStyle("-fx-base: #00FF00");
        convertButton.setStyle("-fx-base: #FF00FF");
        addMenuItem(moveButton);
        addMenuItem(convertButton);
    }
}

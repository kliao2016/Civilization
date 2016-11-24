package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private BorderPane gameLayout = new BorderPane();
    private static GridFX gameGrid = GridFX.getInstance();
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        gameLayout.setCenter(gameGrid);
    }

    /**
     * This method should update the gridfx and the resource bar
     */
    public void update() {
      //TODO
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return null;
    }

    public BorderPane getGameLayout() {
        return gameLayout;
    }

    public static GridFX getGameGrid() {
        return gameGrid;
    }
    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
       //TODO
    }
}

package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private BorderPane gameLayout = new BorderPane();
    private GridFX gameGrid = GridFX.getInstance();
    private static ResourcesMenu menuBar = new ResourcesMenu();
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        gameLayout.setTop(menuBar.getRootNode());
        gameLayout.setCenter(gameGrid);
    }

    /**
     * This method should update the gridfx and the resource bar
     */
    public void update() {
        gameGrid.update();
    }
    /**
    * this method should return the resource menu
    * @return resource menu
    */
    public static ResourcesMenu getResources() {
        return menuBar;
    }

    public BorderPane getGameLayout() {
        return gameLayout;
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

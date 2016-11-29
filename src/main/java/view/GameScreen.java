package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private static ResourcesMenu menuBar = new ResourcesMenu();
    private static MilitaryMenu milMenu = new MilitaryMenu();
    private static WorkerMenu workMenu = new WorkerMenu();
    private static RecruitMenu recMenu = new RecruitMenu();
    private static BuildingMenu buildMenu = new BuildingMenu();
    private static StatusMenu statMenu = new StatusMenu();
    private static VBox mainMenu = new VBox();
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        this.setTop(menuBar.getRootNode());
        this.setCenter(GridFX.getInstance());
        switchMenu(GameController.getGameState());
        this.setLeft(mainMenu);
    }

    /**
     * This method should update the gridfx and the resource bar
     */
    public void update() {
        GridFX.update();
    }
    /**
    * this method should return the resource menu
    * @return resource menu
    */
    public static ResourcesMenu getResources() {
        return menuBar;
    }

    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        switch (state) {
        case MILITARY:
            mainMenu.getChildren().clear();
            mainMenu.getChildren().addAll(milMenu.getRootNode());
            break;
        case WORKER:
            mainMenu.getChildren().clear();
            mainMenu.getChildren().addAll(workMenu.getRootNode());
            break;
        case RECRUITING:
            mainMenu.getChildren().clear();
            mainMenu.getChildren().addAll(recMenu.getRootNode());
            break;
        case BUILDING:
            mainMenu.getChildren().clear();
            mainMenu.getChildren().addAll(buildMenu.getRootNode());
            break;
        case NEUTRAL:
            mainMenu.getChildren().clear();
            mainMenu.getChildren().addAll(statMenu.getRootNode());
            break;
        default: break;
        }
    }
}

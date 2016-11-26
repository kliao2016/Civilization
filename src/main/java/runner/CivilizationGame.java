package runner;

import controller.GameController;
import view.CivEnum;
import view.GameScreen;
import view.GridFX;
import view.NewSettlementPrompt;
import view.StartScreen;
import model.Bandit;
import model.Egypt;
import model.QinDynasty;
import model.RomanEmpire;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    private Stage stage = new Stage();

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        stage.setTitle("CS1331 Civilization");
        stage.setScene(startGame());
        primaryStage = stage;
        primaryStage.show();
    }

    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */
    public Scene startGame() {
        StartScreen startScreen = new StartScreen();
        Scene start = new Scene(startScreen.getStartLayout());
        startScreen.getStartButton().setOnMousePressed(e -> {
                NewSettlementPrompt.newSettlementAlert();
                CivEnum selected = startScreen.getCivList().getSelectionModel()
                                                           .getSelectedItem();
                if (selected == CivEnum.ANCIENT_EGYPT) {
                    Egypt egypt = new Egypt();
                    String name = NewSettlementPrompt.getText().getResult();
                    GridFX.getMap().putSettlement(name, egypt, 5, 5);
                    GridFX.getMap().addEnemies(new Bandit(), 3);
                    GameController.setCivilization(egypt);
                } else if (selected == CivEnum.QIN_DYNASTY) {
                    QinDynasty qin = new QinDynasty();
                    String name = NewSettlementPrompt.getText().getResult();
                    GridFX.getMap().putSettlement(name, qin, 5, 5);
                    GridFX.getMap().addEnemies(new Bandit(), 3);
                    GameController.setCivilization(qin);
                } else {
                    RomanEmpire rome = new RomanEmpire();
                    String name = NewSettlementPrompt.getText().getResult();
                    GridFX.getMap().putSettlement(name, rome, 5, 5);
                    GridFX.getMap().addEnemies(new Bandit(), 3);
                    GameController.setCivilization(rome);
                }
                GameScreen gameScreen = new GameScreen();
                gameScreen.update();
                Scene game = new Scene(gameScreen.getGameLayout());
                stage.setScene(game);
            });
        return start;
    }
}

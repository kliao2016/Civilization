package runner;

import controller.GameController;
import view.NewSettlementPrompt;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Bandit;
import model.Egypt;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CS1331 Civilization");
        primaryStage.setScene(startGame());
        NewSettlementPrompt.getDialogButton().setOnAction(e -> {
            GameScreen gameScreen = new GameScreen();
            Scene game = new Scene(gameScreen.getGameLayout());
            primaryStage.setScene(game);
        });
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
        startScreen.getStartButton().setOnMousePressed(e -> {
            NewSettlementPrompt.newSettlementAlert();
            if (startScreen.getCivList().getSelectionModel().getSelectedItem()
                == CivEnum.ANCIENT_EGYPT) {
                Egypt egypt = new Egypt();
                String settleName = NewSettlementPrompt.getText().getResult();
                GameScreen.getGameGrid().getMap()
                                        .putSettlement(settleName, egypt, 5, 5);
                GameController.setCivilization(egypt);
            } else if (startScreen.getCivList().getSelectionModel()
                       .getSelectedItem()== CivEnum.QIN_DYNASTY) {
                QinDynasty qin = new QinDynasty();
                String settleName = NewSettlementPrompt.getText().getResult();
                GameScreen.getGameGrid().getMap()
                                        .putSettlement(settleName, qin, 5, 5);
                GameController.setCivilization(qin);
            } else {
                RomanEmpire rome = new RomanEmpire();
                String settleName = NewSettlementPrompt.getText().getResult();
                GameScreen.getGameGrid().getMap()
                                        .putSettlement(settleName, rome, 5, 5);
                GameController.setCivilization(rome);
            }
        });
        Scene start = new Scene(startScreen.getStartLayout());
        return start;
    }
}

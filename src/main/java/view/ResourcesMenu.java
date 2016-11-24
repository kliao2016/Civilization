package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;

public class ResourcesMenu {

    private HBox resBox = new HBox(8);
    private Civilization playerCiv = GameController.getCivilization();
    private Text strat = new Text();
    private Text res = new Text();
    private Text settle = new Text();
    private Text money = new Text();
    private Text food = new Text();
    private Text happy = new Text();

    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        strat.setText("Strat Level: "
                              + playerCiv.getStrategy().getStrategyLevel());
        res.setText("Resources: " + playerCiv.getResources());
        settle.setText("Settlements: " + playerCiv.getNumSettlements());
        money.setText("Money: " + playerCiv.getTreasury().getCoins());
        food.setText("Food: " + playerCiv.getFood());
        happy.setText("Happiness: " + playerCiv.getHappiness());
        resBox.getChildren().addAll(strat, res, settle, money, food, happy);
    }
    /**
    * should update all the resource values to the current
    * state of your resource values
    */
    public void update() {
        strat.setText("Strat Level: "
                              + playerCiv.getStrategy().getStrategyLevel());
        res.setText("Resources: " + playerCiv.getResources());
        settle.setText("Settlements: " + playerCiv.getNumSettlements());
        money.setText("Money: " + playerCiv.getTreasury().getCoins());
        food.setText("Food: " + playerCiv.getFood());
        happy.setText("Happiness: " + playerCiv.getHappiness());
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        return resBox;
    }
}
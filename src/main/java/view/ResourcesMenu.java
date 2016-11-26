package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;

public class ResourcesMenu {

    private HBox resBox = new HBox(15);
    private Civilization playerCiv = GameController.getCivilization();
    private Text strat;
    private Text res;
    private Text settle;
    private Text money;
    private Text food;
    private Text happy;

    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        strat = new Text("Strat Level: "
                         + playerCiv.getStrategy().getStrategyLevel());
        res = new Text("Resources: " + playerCiv.getResources());
        settle = new Text("Settlements: " + playerCiv.getNumSettlements());
        money = new Text("Money: " + playerCiv.getTreasury().getCoins());
        food = new Text("Food: " + playerCiv.getFood());
        happy = new Text("Happiness: " + playerCiv.getHappiness());
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
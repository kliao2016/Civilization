package view;

import controller.GameController;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Civilization;
import model.Unit;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {

    private static final String MELEE = new String("Melee Unit");
    private static final String RANGED = new String("Ranged Unit");
    private static final String HYBRID = new String("Hybrid Unit");
    private static final String SIEGE = new String("Siege Unit");
    private static final String SETTLE = new String("Settlers");
    private static final String FARMERS = new String("Farmers");
    private static final String COALS = new String("Coal Miners");
    private static final String ANGLERS = new String("Anglers");
    private static final String MASTERS = new String("Master Builders");
    private ListView<String> recruitItems = new ListView<>();
    private Civilization owner = GameController.getCivilization();
    private Button selectButton = new Button("Select");
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        recruitItems.getItems().addAll(MELEE, RANGED, HYBRID, SIEGE, SETTLE,
            FARMERS, COALS, ANGLERS, MASTERS);
        selectButton.setOnMousePressed(e -> {
                String sel = recruitItems.getSelectionModel().getSelectedItem();
                if (sel.equals(MELEE)) {
                    Unit recruit = owner.getMeleeUnit();
                    if (!recruit.isAffordable()) {
                        NoActionAlert.displayAlert();
                    } else {
                        recruit.applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            owner.getMeleeUnit());
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }
                } else if (sel.equals(RANGED)) {
                    Unit recruit = owner.getRangedUnit();
                    if (!recruit.isAffordable()) {
                        NoActionAlert.displayAlert();
                    } else {
                        recruit.applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            owner.getRangedUnit());
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }
                } else if (sel.equals(HYBRID)) {
                    Unit recruit = owner.getHybridUnit();
                    if (!recruit.isAffordable()) {
                        NoActionAlert.displayAlert();
                    } else {
                        recruit.applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            owner.getHybridUnit());
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }
                } else if (sel.equals(SIEGE)) {
                    Unit recruit = owner.getSiegeUnit();
                    if (!recruit.isAffordable()) {
                        NoActionAlert.displayAlert();
                    } else {
                        recruit.applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            owner.getSiegeUnit());
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }
                } else if (sel.equals(SETTLE)) {
                    Unit recruit = owner.getSettlerUnit("");
                    if (!recruit.isAffordable()) {
                        NoActionAlert.displayAlert();
                    } else {
                        recruit.applyInitialCosts();
                        NewSettlementPrompt.newSettlementAlert();
                        String name = NewSettlementPrompt.getText().getResult();
                        GameController.getLastClicked().getTile().setOccupant(
                            owner.getSettlerUnit(name));
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }
                } else if (sel.equals(FARMERS)) {
                    if (!owner.getFarmerUnit().isAffordable()) {
                        NoActionAlert.displayAlert();
                    } else {
                        owner.getFarmerUnit().applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            owner.getFarmerUnit());
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }
                } else if (sel.equals(COALS)) {
                    Unit recruit = owner.getSiegeUnit();
                    if (!recruit.isAffordable()) {
                        NoActionAlert.displayAlert();
                    } else {
                        recruit.applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            owner.getCoalMinerUnit());
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }
                } else if (sel.equals(ANGLERS)) {
                    if (!owner.getAnglerUnit().isAffordable()) {
                        NoActionAlert.displayAlert();
                    } else {
                        owner.getAnglerUnit().applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            owner.getAnglerUnit());
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }
                } else {
                    if (!owner.getMasterBuilderUnit().isAffordable()) {
                        NoActionAlert.displayAlert();
                    } else {
                        owner.getMasterBuilderUnit().applyInitialCosts();
                        GameController.getLastClicked().getTile().setOccupant(
                            owner.getMasterBuilderUnit());
                        GameController.getLastClicked().updateTileView();
                        GameController.updateResourcesBar();
                    }
                }
            });
        selectButton.setStyle("-fx-base: #0000FF");
        addMenuItem(recruitItems);
        addMenuItem(selectButton);
    }
}

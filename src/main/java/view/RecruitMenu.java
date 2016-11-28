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

    private static final String MELEE = "Melee Unit";
    private static final String RANGED = "Ranged Unit";
    private static final String HYBRID = "Hybrid Unit";
    private static final String SIEGE = "Siege Unit";
    private static final String SETTLE = "Settlers";
    private static final String FARMERS = "Farmers";
    private static final String COALS = "Coal Miners";
    private static final String ANGLERS = "Anglers";
    private static final String MASTERS = "Master Builders";
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
                if (sel == null) {
                    NoActionAlert.displayAlert();
                } else {
                    recruit(sel);
                }
            });
        selectButton.setStyle("-fx-base: #0000FF");
        addMenuItem(recruitItems);
        addMenuItem(selectButton);
    }

    //Helper method for constructor
    public void recruit(String selected) {
        Unit recruit;
        switch (selected) {
        case MELEE:
            recruit = owner.getMeleeUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getMeleeUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case RANGED:
            recruit = owner.getRangedUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getRangedUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case HYBRID:
            recruit = owner.getRangedUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getRangedUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case SIEGE:
            recruit = owner.getSiegeUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getSiegeUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case SETTLE:
            recruit = owner.getSettlerUnit("");
            if (!recruit.isAffordable()) {
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                NewSettlementPrompt.newSettlementAlert();
                String name = NewSettlementPrompt.getText().getResult();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getSettlerUnit(name));
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case FARMERS:
            if (!owner.getFarmerUnit().isAffordable()) {
                NoActionAlert.displayAlert();
            } else {
                owner.getFarmerUnit().applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getFarmerUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case COALS:
            recruit = owner.getSiegeUnit();
            if (!recruit.isAffordable()) {
                NoActionAlert.displayAlert();
            } else {
                recruit.applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getCoalMinerUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case ANGLERS:
            if (!owner.getAnglerUnit().isAffordable()) {
                NoActionAlert.displayAlert();
            } else {
                owner.getAnglerUnit().applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getAnglerUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        case MASTERS:
            if (!owner.getMasterBuilderUnit().isAffordable()) {
                NoActionAlert.displayAlert();
            } else {
                owner.getMasterBuilderUnit().applyInitialCosts();
                GameController.getLastClicked().getTile().setOccupant(
                    owner.getMasterBuilderUnit());
                GameController.setLastClicked(
                                    GameController.getLastClicked());
                GameController.getLastClicked().updateTileView();
                GameController.updateResourcesBar();
            }
            break;
        default: break;
        }
    }
}

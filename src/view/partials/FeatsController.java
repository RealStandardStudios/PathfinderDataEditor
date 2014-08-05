package view.partials;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jefXif.WindowController;
import pathfinder.data.Effects.*;
import pathfinder.data.Effects.Actions.*;
import pathfinder.data.Effects.NonValued.*;
import pathfinder.data.Feats.Feat;

public class FeatsController extends WindowController {

	@FXML
	TableView<Feat> tableFeats;

	@FXML
	Button btnEdit;
	/**
	 * A list of default effects to use in the selection of effects for the Feat
	 */
	ComboBox<Effect> effects = new ComboBox<>(
			FXCollections.observableArrayList());

	@FXML
	TableColumn<Feat, String> featNameColumn;
	@FXML
	TableColumn<Feat, Feat> prerequisiteColumn;
	@FXML
	TableColumn<Feat, String> benifitColumn;
	@FXML
	TableColumn<Feat, Effect> effectColumn;

	ObservableList<Feat> feats = FXCollections.observableArrayList();

	public FeatsController() {
		feats.add(new Feat("Test Feat", new Feat(), "Get's tested"));

		effects.itemsProperty().get().add(new AbilityEffect());
		effects.itemsProperty().get().add(new ArmorClassEffect());
		effects.itemsProperty().get().add(new AttackBonusEffect());
		effects.itemsProperty().get().add(new CasterLevelModifierEffect());
		effects.itemsProperty().get().add(new CombatManeuverBonusEffect());
		effects.itemsProperty().get().add(new CombatManeuverDefenseEffect());
		effects.itemsProperty().get().add(new CritBonusEffect());
		effects.itemsProperty().get().add(new InitiativeEffect());
		effects.itemsProperty().get().add(new NaturalArmorEffect());
		effects.itemsProperty().get().add(new ResistanceBonusEffect());
		effects.itemsProperty().get().add(new SaveAttributeEffect());
		effects.itemsProperty().get().add(new SavingThrowEffect());
		effects.itemsProperty().get().add(new SkillEffect());
		effects.itemsProperty().get().add(new SpeedEffect());
		effects.itemsProperty().get().add(new SpellResistanceEffect());
		effects.itemsProperty().get().add(new ActionToFreeEffect());
		effects.itemsProperty().get().add(new ActionToImmediateEffect());
		effects.itemsProperty().get().add(new ActionToMoveEffect());
		effects.itemsProperty().get().add(new ActionToSwiftEffect());
		effects.itemsProperty().get().add(new FeintActionEffect());
		effects.itemsProperty().get().add(new TripActionEffect());
		effects.itemsProperty().get().add(new MiscEffect());
		effects.itemsProperty().get().add(new OnCritEffect());
	}

	@Override
	public void initialize() {
		tableFeats.setItems(feats);
		featNameColumn.setCellValueFactory(cellData -> cellData.getValue()
				.nameProperty());
		prerequisiteColumn.setCellValueFactory(cellData -> cellData.getValue()
				.prerequisitePropety());
		benifitColumn.setCellValueFactory(cellData -> cellData.getValue()
				.benifitProperty());
		effectColumn.setCellValueFactory(cellData -> cellData.getValue().effectProperty());
	}

}

package view.partials.dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jefXif.DialogController;
import pathfinder.data.Effects.AbilityEffect;
import pathfinder.data.Effects.ArmorClassEffect;
import pathfinder.data.Effects.AttackBonusEffect;
import pathfinder.data.Effects.CasterLevelModifierEffect;
import pathfinder.data.Effects.CombatManeuverBonusEffect;
import pathfinder.data.Effects.CombatManeuverDefenseEffect;
import pathfinder.data.Effects.CritBonusEffect;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.InitiativeEffect;
import pathfinder.data.Effects.NaturalArmorEffect;
import pathfinder.data.Effects.ResistanceBonusEffect;
import pathfinder.data.Effects.SaveAttributeEffect;
import pathfinder.data.Effects.SavingThrowEffect;
import pathfinder.data.Effects.SkillEffect;
import pathfinder.data.Effects.SpeedEffect;
import pathfinder.data.Effects.SpellResistanceEffect;
import pathfinder.data.Effects.Actions.ActionToFreeEffect;
import pathfinder.data.Effects.Actions.ActionToImmediateEffect;
import pathfinder.data.Effects.Actions.ActionToMoveEffect;
import pathfinder.data.Effects.Actions.ActionToSwiftEffect;
import pathfinder.data.Effects.Actions.FeintActionEffect;
import pathfinder.data.Effects.Actions.TripActionEffect;
import pathfinder.data.Effects.NonValued.MiscEffect;
import pathfinder.data.Effects.NonValued.OnCritEffect;
import pathfinder.data.Feats.Feat;

public class FeatEditDialogController extends DialogController {
	Boolean okayClicked = false;
	ObservableList<Feat> prerequistes;
	ObservableList<Effect> effects;
	Feat feat;

	@FXML
	TextField txtFeatName;
	@FXML
	ComboBox<Feat> cboPrerequisiteFeat;
	@FXML
	TextArea txtaBenifit;
	@FXML
	ComboBox<Effect> cboEffect;
	@FXML
	private void handleChangedEffect(ActionEvent event) {
		Effect selectedEffect = cboEffect.getValue();
		System.out.println(selectedEffect.getClass().toString());
	}
	@FXML
	private void handleCancel(ActionEvent event) {
		getDialogStage().close();
	}
	
	@FXML
	private void handleOkay() {
		feat.nameProperty().setValue(txtFeatName.getText());
		feat.benifitProperty().setValue(txtaBenifit.getText());
		feat.prerequisitePropety().setValue(cboPrerequisiteFeat.getValue());
		okayClicked = true;
		this.getDialogStage().close();
	}
	
	/**
	 * @return the feat
	 */
	public Feat getFeat() {
		return feat;
	}

	/**
	 * @param feat the feat to set
	 */
	public void setFeat(Feat feat) {
		this.feat = feat;
		
		txtFeatName.setText(feat.getName());
		txtaBenifit.setText(feat.getBenefit());
	}
	
	public FeatEditDialogController() {
		effects = FXCollections.observableArrayList();
		effects.add(new AbilityEffect());
		effects.add(new ArmorClassEffect());
		effects.add(new AttackBonusEffect());
		effects.add(new CasterLevelModifierEffect());
		effects.add(new CombatManeuverBonusEffect());
		effects.add(new CombatManeuverDefenseEffect());
		effects.add(new CritBonusEffect());
		effects.add(new InitiativeEffect());
		effects.add(new NaturalArmorEffect());
		effects.add(new ResistanceBonusEffect());
		effects.add(new SaveAttributeEffect());
		effects.add(new SavingThrowEffect());
		effects.add(new SkillEffect());
		effects.add(new SpeedEffect());
		effects.add(new SpellResistanceEffect());
		effects.add(new ActionToFreeEffect());
		effects.add(new ActionToImmediateEffect());
		effects.add(new ActionToMoveEffect());
		effects.add(new ActionToSwiftEffect());
		effects.add(new FeintActionEffect());
		effects.add(new TripActionEffect());
		effects.add(new MiscEffect());
		effects.add(new OnCritEffect());
	}
	
	@Override
	public void initialize() {
		cboEffect.setItems(effects);
	}
	public boolean isOkayClicked() {
		return this.okayClicked;
	}
	public void setPrerequisites(ObservableList<Feat> feats) {
		this.prerequistes = FXCollections.observableArrayList();
		for (Feat feat : feats) {
			if(!feat.equals(this.feat))
				prerequistes.add(feat);
		}
		prerequistes.add(0, Feat.NullFeat);
		cboPrerequisiteFeat.setItems(prerequistes);
		cboPrerequisiteFeat.selectionModelProperty().getValue().select((Feat) feat.prerequisitePropety().getValue());
	}
}

package view.partials.dialogs;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import jefXif.DialogController;
import jefXif.PartialLoader;
import jefXif.WindowController;
import pathfinder.data.FeatPrerequisite;
import pathfinder.data.Feats.Feat;
import view.partials.dialogs.featDialogPartials.EffectPartialController;

import com.sun.istack.internal.logging.Logger;

public class FeatEditDialogController extends DialogController implements
		PartialLoader {

	String[] partials = { "MiscEffect", "ArmorClassEffect",
			"CombatManeuverBonusEffect", "InitiativeEffect",
			"SaveAttributeEffect", "SkillEffect", "ActionEffect", "ActionToFreeEffect",
			"ActionToSwiftEffect", "ActionToMoveEffect", "FeintActionEffect",
			"MiscEffect", "OnCritEffect", "DamageEffect", "DamageEffect",
			"DamageMultiplierEffect", "ItemCreationEffect", "MetaMagicEffect" };

	Boolean okayClicked = false;
	ObservableList<FeatPrerequisite> prerequistes;
	ObservableList<String> effects;
	HashMap<String, EffectPartialController> effectPartials;
	Feat feat;

	@FXML
	AnchorPane EffectPartialPane;

	@FXML
	TextField txtFeatName;
	@FXML
	ComboBox<FeatPrerequisite> cboPrerequisiteFeat;
	@FXML
	TextArea txtaBenifit;
	@FXML
	ComboBox<String> cboEffect;

	@FXML
	private void handleChangedEffect(ActionEvent event) {
		if (cboEffect.getValue() != "" || !cboEffect.getValue().equals(null))
			EffectPartialPane.getChildren().setAll(
					effectPartials.get(cboEffect.getValue()).getNode());
	}

	@FXML
	private void handleCancel(ActionEvent event) {
		getDialogStage().close();
	}

	@FXML
	private void handleOkay() {
		feat.nameProperty().setValue(txtFeatName.getText());
		feat.benifitProperty().setValue(txtaBenifit.getText());
		if (feat.prerequisitePropety().getValue().getClass()
				.isInstance(Feat.class))
			feat.prerequisitePropety().setValue(cboPrerequisiteFeat.getValue());
		okayClicked = true;
		this.feat.effectProperty().set(effectPartials.get(cboEffect.getValue()).getEffect());;
		this.getDialogStage().close();
	}

	/**
	 * @return the feat
	 */
	public Feat getFeat() {
		return feat;
	}

	/**
	 * @param feat
	 *            the feat to set
	 */
	public void setFeat(Feat feat) {
		this.feat = feat;

		txtFeatName.setText(feat.getName());
		txtaBenifit.setText(feat.getBenefit());
	}

	public FeatEditDialogController() {
		effects = FXCollections.observableArrayList();
		for (String s : partials) {
			effects.add(s);
		}
	}

	@Override
	public void initialize() {
		cboEffect.setItems(effects);
		effectPartials = new HashMap<>();
		// this doesnt apear to work properly cause there were only 4 things
		try {
			for (String string : partials) {
				this.effectPartials.put(string, (EffectPartialController) loadPartial(string));
			}
		} catch (IOException e) {
			Logger.getLogger(getClass()).log(Level.SEVERE, e.getMessage());
		}
	}

	private WindowController loadPartial(String name) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(
				"featDialogPartials/" + name + "Partial.fxml"));

		Node node = loader.load();
		WindowController controller = loader.getController();
		controller.setNode(node);
		return controller;
	}

	public boolean isOkayClicked() {
		return this.okayClicked;
	}

	public void setData(ObservableList<Feat> feats) {
		this.prerequistes = FXCollections.observableArrayList();
		// add each feat to the prerequisites except for the chosen feat
		for (Feat feat : feats) {
			if (!feat.equals(this.feat))
				prerequistes.add(feat);
		}
		// add an empty feat for if there is no pre-requisite
		prerequistes.add(0, Feat.NullFeat);
		cboPrerequisiteFeat.setItems(prerequistes);
		// if the prerequisite is a feat
		if (feat.prerequisitePropety().getValue().getClass()
				.isInstance(Feat.class))
			// select the feat from the prerequisite combo box
			cboPrerequisiteFeat.selectionModelProperty().getValue()
					.select((Feat) feat.prerequisitePropety().getValue());
		else
			// there is no feat, don't display the combo box
			cboPrerequisiteFeat.setDisable(true);
		String className = feat.effectProperty().getValue().getClass()
				.toString();
		String[] parts = className.replace('.', ',').split(",");
		// gets the name of the effect used on the feat and moves the partial to view by changing the combo box
		if (parts.length == 5)
			this.cboEffect.selectionModelProperty().getValue().select(parts[4]);
		else
			this.cboEffect.selectionModelProperty().getValue().select(parts[3]);
		// sets the feat on the previously chosen partial
		this.effectPartials.get(cboEffect.getValue()).setEffect(feat.effectProperty().get());
	}
}

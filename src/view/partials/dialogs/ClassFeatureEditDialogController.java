package view.partials.dialogs;

import java.io.IOException;
import java.util.HashMap;

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
import jefXif.WindowController;
import jefXif.interfaces.PartialLoader;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Classes.Objects.Feature;
import pathfinder.data.Effects.Effect;
import view.partials.dialogs.effectDialogPartials.EffectPartialController;

public class ClassFeatureEditDialogController extends DialogController
		implements PartialLoader {

	String[] partials = { "MiscEffect", "ArmorClassEffect",
			"CombatManeuverBonusEffect", "InitiativeEffect",
			"SaveAttributeEffect", "SkillEffect", "ActionEffect",
			"ActionToFreeEffect", "ActionToSwiftEffect", "ActionToMoveEffect",
			"FeintActionEffect", "MiscEffect", "OnCritEffect", "DamageEffect",
			"DamageMultiplierEffect", "ItemCreationEffect", "MetaMagicEffect" };

	ObservableList<String> effects;
	HashMap<String, EffectPartialController> effectPartials;
	Feature feature;

	@FXML
	TextField txtFeatureName;
	@FXML
	TextField txtFeatureType;
	@FXML
	TextArea txtaFeatureDescription;
	@FXML
	AnchorPane EffectPartialPane;
	@FXML
	ComboBox<String> cboEffect;

	public ClassFeatureEditDialogController() {
		effects = FXCollections.observableArrayList();
		for (String s : partials) {
			effects.add(s);
		}
	}

	@Override
	public void initialize() {
		cboEffect.setItems(effects);
		effectPartials = new HashMap<>();
		for (String string : partials) {
			try {
				this.effectPartials.put(string,
						(EffectPartialController) loadPartial(string));
			} catch (IOException e) {
				Dialogs.create().title("Error")
						.masthead("There was an error making this dialog")
						.message(e.getMessage());
				// Logger.getLogger(getClass()).log(Level.SEVERE,
				// e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private WindowController loadPartial(String name) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(
				"effectDialogPartials/" + name + "Partial.fxml"));

		Node node = loader.load();
		WindowController controller = loader.getController();
		controller.setNode(node);
		return controller;
	}

	@FXML
	private void handleChangedEffect(ActionEvent event) {
		if (cboEffect.getValue() != "" || !cboEffect.getValue().equals(null))
			EffectPartialPane.getChildren().setAll(effectPartials.get(cboEffect.getValue()).getNode());
		if (feature.getEffectProperty().get() != null)
			effectPartials.get(cboEffect.getValue()).setEffect(feature.getEffectProperty().get());
		else {
			// feature.getEffectProperty().set();
			Effect effect = null;
			try {
				effect = (Effect) Class.forName(
						"pathfinder.data.Effects." + cboEffect.getValue())
						.newInstance();
			} catch (ClassNotFoundException e) {
				try {
					effect = (Effect) Class.forName(
							"pathfinder.data.Effects.Actions."
									+ cboEffect.getValue()).newInstance();
				} catch (InstantiationException | IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					try {
						effect = (Effect) Class.forName(
								"pathfinder.data.Effects.NonValued."
										+ cboEffect.getValue()).newInstance();
					} catch (InstantiationException | IllegalAccessException
							| ClassNotFoundException e2) {
						e2.printStackTrace();
					}
				}
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			feature.setEffect(effect);
			effectPartials.get(cboEffect.getValue()).setEffect(feature.getEffectProperty().get());
		}
	}

	@FXML
	public void handleOkay(ActionEvent event) {
		feature.setDescription(txtaFeatureDescription.getText());
		feature.setType(txtFeatureType.getText());
		feature.getNameProperty().set(txtFeatureName.getText());
		feature.setEffect(effectPartials.get(
				cboEffect.getSelectionModel().getSelectedItem()).getEffect());
		this.getDialogStage().close();
	}

	public void setFeature(Feature selectedFeature) {
		this.feature = selectedFeature;
		txtFeatureName.setText(feature.getNameProperty().get());
		txtFeatureType.setText(feature.getTypeProperty().get());
		txtaFeatureDescription.setText(feature.getDescriptionProperty().get());
		if (feature.getEffectProperty().get() != null)
			cboEffect.getSelectionModel().select(
					feature.getEffectProperty().get().getName());
		else {
			cboEffect.getSelectionModel().select("MiscEffect");
		}
	}

	public Feature getFeature() {
		return feature;
	}

}

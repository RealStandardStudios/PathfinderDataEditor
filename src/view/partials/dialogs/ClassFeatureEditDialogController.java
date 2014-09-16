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
import jefXif.PartialLoader;
import jefXif.WindowController;
import pathfinder.data.Classes.Objects.Feature;
import view.partials.dialogs.effectDialogPartials.EffectPartialController;

public class ClassFeatureEditDialogController extends DialogController implements PartialLoader{
	
	String[] partials = {"MiscEffect", "ArmorClassEffect",
			"CombatManeuverBonusEffect", "InitiativeEffect",
			"SaveAttributeEffect", "SkillEffect", "ActionEffect",
			"ActionToFreeEffect", "ActionToSwiftEffect", "ActionToMoveEffect",
			"FeintActionEffect", "MiscEffect", "OnCritEffect", "DamageEffect",
			"DamageMultiplierEffect", "ItemCreationEffect", "MetaMagicEffect"};
	
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
				//Logger.getLogger(getClass()).log(Level.SEVERE, e.getMessage());
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
			EffectPartialPane.getChildren().setAll(
					effectPartials.get(cboEffect.getValue()).getNode());
	}
	
	@FXML
	public void handleOkay(ActionEvent event) {
		
	}

	public void setFeature(Feature selectedFeature) {
		// TODO Auto-generated method stub
		
	}

	public Feature getFeature() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

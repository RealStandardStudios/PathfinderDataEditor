package view.partials.dialogs;

import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jefXif.DialogController;
import pathfinder.data.Size;
import pathfinder.data.VisionType;
import pathfinder.data.Attributes.AbilityName;
import pathfinder.data.Effects.AbilityEffect;
import pathfinder.data.Races.Race;

/**
 * the controller for the race traits edit dialog
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class RaceTraitsEditDialogController extends DialogController {
	Race race;
	@FXML
	CheckBox cbDark;
	@FXML
	CheckBox cbNormal;
	@FXML
	CheckBox cbLowLight;
	@FXML
	CheckBox cbSuperiorLowLight;
	@FXML
	CheckBox cbSuperiorDark;
	
	@FXML
	ComboBox<Size> cboSizes;
	
	@FXML
	TextField txtRacialModifiers;
	
	@FXML
	TextField txtSpeed;
	@FXML
	TextArea txtaWeaponFamiliarity;
	@FXML
	TextArea txtaLanguages;
	
	ObservableList<Size> sizes;
	
	HashMap<String,AbilityName>AbilityNames;
	
	/**
	 * @return the race
	 */
	public Race getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(Race race) {
		this.race = race;
		txtSpeed.setText(Integer.toString(race.getSpeed()));
		txtRacialModifiers.setText(race.getRacialModifierString());
		txtaWeaponFamiliarity.setText(race.getWeaponsString());
		txtaLanguages.setText(race.getLanguagesString());
		for (VisionType v : race.getVisionTypes()) {
			switch (v.getName()) {
			case "Normal":
				cbNormal.setSelected(true);
				break;
			case "Low-Light Vision":
				cbLowLight.setSelected(true);
				break;
			case "Darkvision":
				cbDark.setSelected(true);
				break;
			case "Superior Dark Vision":
				cbSuperiorDark.setSelected(true);
				break;
			case "Superior Low-Light Vision":
				cbSuperiorLowLight.setSelected(true);
				break;

			default:
				System.out.println("You forgot: "+v.getName());
				break;
			}
		}
		
		cboSizes.setItems(sizes);
		cboSizes.setValue(race.getSize());
	}
	
	/**
	 * the constructor for the controller
	 */
	@SuppressWarnings("serial")
	public RaceTraitsEditDialogController() {
		sizes = FXCollections.observableArrayList(
				Size.Diminutive,Size.Fine,Size.Tiny,Size.Small,
				Size.Medium,Size.Large,Size.Huge,Size.Colossal,Size.Gargantuan
			);
		
		AbilityNames = new HashMap<String, AbilityName>() {
			{
				put(AbilityName.Charisma.name(), AbilityName.Charisma);
				put(AbilityName.Constitution.name(), AbilityName.Constitution);
				put(AbilityName.Dexterity.name(), AbilityName.Dexterity);
				put(AbilityName.Intelligence.name(), AbilityName.Intelligence);
				put(AbilityName.Strength.name(), AbilityName.Strength);
				put(AbilityName.Wisdom.name(), AbilityName.Wisdom);
			}
		};
	}

	/**
	 * a handle method that saves changes upon pressing the Ok button
	 */
	@FXML
	public void handleOkay(ActionEvent event) {
		race.setSpeed(Integer.parseInt(txtSpeed.getText()));
		race.setSize(cboSizes.getSelectionModel().getSelectedItem());
		String[] parts = txtaLanguages.getText().split(",");
		for (int i = 0; i < parts.length; i++) {
			parts[i] = parts[i].trim();			
		}
		race.setLanguages(parts);
		parts = txtaWeaponFamiliarity.getText().split(",");
		for (int i = 0; i < parts.length; i++) {
			parts[i] = parts[i].trim();			
		}
		race.setWeaponFamiliarity(parts);
		
		String effectName = "Racial Ability Modifier";
		String[] traits = txtRacialModifiers.getText().split(",");
		AbilityEffect[] abilityEffects = new AbilityEffect[traits.length];
		for (int i = 0; i < traits.length; i++) {
			String[] traitParts = traits[i].trim().split(" ");
			abilityEffects[i] = new AbilityEffect(Integer.parseInt(traitParts[0]), effectName, AbilityNames.get(traitParts[1].trim()));
		}
		
		okayClicked = true;
		getDialogStage().close();
	}
}

package view.partials.dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jefXif.DialogController;
import pathfinder.data.Races.Race;
import pathfinder.data.Races.Objects.Size;
import pathfinder.data.Races.Objects.VisionType;

public class RaceTraitsEditDialogController extends DialogController {
	boolean okayClicked = false;
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
	}
	
	public RaceTraitsEditDialogController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	public void handleOkay(ActionEvent event) {
		race.setSpeed(Integer.parseInt(txtSpeed.getText()));
		race.setSize(cboSizes.getSelectionModel().getSelectedItem());
		
		okayClicked = true;
		getDialogStage().close();
	}
	
	@FXML
	public void handleCancel(ActionEvent event) {
		getDialogStage().close();
	}

	public boolean isOkayClicked() {
		return this.okayClicked;
	}
}

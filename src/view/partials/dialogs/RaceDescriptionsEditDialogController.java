package view.partials.dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jefXif.DialogController;
import pathfinder.data.Feats.Feat;
import pathfinder.data.Races.Race;

public class RaceDescriptionsEditDialogController extends DialogController{
	
	@FXML
	TextField txtRaceName;
	@FXML
	TextArea txtaDescription;

	@FXML
	TextArea txtaPDescription;

	@FXML
	TextArea txtaSociety;

	@FXML
	TextArea txtaRelations;

	@FXML
	TextArea txtaReligion;

	@FXML
	TextArea txtaAdventures;
	
	Race race;
	
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
	}

	public RaceDescriptionsEditDialogController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	private void handleCancel(ActionEvent event) {
		getDialogStage().close();
	}

	@FXML
	private void handleOkay() {
		this.race.setName(txtRaceName.getText());
		this.race.setDescription(txtaDescription.getText());
		this.race.setPhysicalDescription(txtaPDescription.getText());
		this.race.setSociety(txtaSociety.getText());
		this.race.setRelations(txtaRelations.getText());
		this.race.setAlignmentAndReligion(txtaReligion.getText());
		//this.getDialogStage().close();
	}
	
	
}

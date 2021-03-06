package view.partials.dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jefXif.view.DialogController;
import pathfinder.data.Races.Race;

/**
 * the controller for the race descriptions edit dialog
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
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
		txtRaceName.setText(race.getName());
		txtaDescription.setText(race.getDescription());
		txtaPDescription.setText(race.getPhysicalDescription());
		txtaSociety.setText(race.getSociety());
		txtaRelations.setText(race.getRelations());
		txtaReligion.setText(race.getAlignmentAndReligion());
		txtaAdventures.setText(race.getAdventures());
	}

	/**
	 * the constructor for the controller
	 */
	public RaceDescriptionsEditDialogController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * a handle method that saves changes upon pressing the Ok button
	 */
	@FXML
	public void handleOkay(ActionEvent event) {
		race.setName(txtRaceName.getText());
		race.setDescription(txtaDescription.getText());
		race.setPhysicalDescription(txtaPDescription.getText());
		race.setSociety(txtaSociety.getText());
		race.setRelations(txtaRelations.getText());
		race.setAlignmentAndReligion(txtaReligion.getText());
		race.setAdventures(txtaAdventures.getText());
		okayClicked = true;
		this.getDialogStage().close();
	}
}

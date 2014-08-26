package view.partials;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import jefXif.DataLoader;
import jefXif.WindowController;
import pathfinder.data.Races.Race;

public class RacesController extends WindowController implements DataLoader{
	@FXML
	Label lblName;
	
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
	
	@FXML
	Button btnEditSheet;
	
	@FXML
	Button btnEditTraits;
	
	ObservableList<Race> races = FXCollections.observableArrayList();
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void handleEditSheet(ActionEvent event) {
		
	}
	
	@FXML
	public void handleEditTraits(ActionEvent event) {
		
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
	}

}

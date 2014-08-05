package view.partials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jefXif.WindowController;
import pathfinder.data.Classes.Class;
import pathfinder.data.Classes.Druid;

public class ClassesController extends WindowController{
	
	@FXML
	private TableView<Class> tableClasses;
	
	@FXML
	private TableColumn<Class, String> columnClassName;
	
	@FXML
	private Label lblDescription;
	
	@FXML
	private Label lblRole;
	
	@FXML
	private Label lblAlignments;
	
	@FXML
	private Label lblHitDice;
	
	@FXML
	private Label lblClassSkills;
	
	@FXML
	private Label lblSkillRanksPerLevel;
	
	@FXML
	private Label lblWeaponProf;
	
	@FXML
	private Label lblArmorProf;
	
	@FXML
	private Label lblStartingWealthD6;
	
	private ObservableList<Class> obsListClasses = FXCollections.observableArrayList();

	/**
	 * Return data as Observable List of Class
	 * @return
	 */
	public ObservableList<Class> getObsListClasses() {
		return obsListClasses;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
		columnClassName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		
		// Dummy test data
		obsListClasses.add(new Druid("Water bender", "Bends water somehow.", "Bends water, of course.", 9001, null, null, 2, 30, null, null, null, null, null, null));
		
		tableClasses.setItems(obsListClasses);
		
		readSummary();
	}
	
	/**
	 * Populate Class Details labels with data from the selected Class
	 * 
	 * @param c : selected Class
	 */
	private void showClassDetails(Class c) {
		if(c != null) {
			lblDescription.setText(c.getName());
			lblRole.setText(c.getRole());
			lblAlignments.setText(c.getAlignments());
			lblHitDice.setText(c.getHitDice().toString());
			lblClassSkills.setText(c.getClassSkillsToString());
			lblSkillRanksPerLevel.setText(c.getSkillRanksToString().toString());
			lblWeaponProf.setText(c.getWeaponProfsToString());
			lblArmorProf.setText(c.getArmorProfsToString());
			lblStartingWealthD6.setText(c.getStartingWealthToString().toString());
		}
	}
	
	/**
	 * Reads class summary data
	 */
	private void readSummary() {
		String[] heading;
		Scanner reader;
		try {
			reader = new Scanner(new FileReader("data/Classes - Class summaries.tsv"));
			String output = reader.nextLine();
			heading = output.split("\t");
			while(reader.hasNextLine()) {
				output = reader.nextLine();
				String[] line = output.split("\t");
				for (int i = 0; i < line.length; i++) {
					System.out.printf("%s: %s \n",heading[i],line[i]); //<heading>: <content>
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(ClassesController.class.toString()).log(Level.SEVERE, null, e);
		}
	}

}

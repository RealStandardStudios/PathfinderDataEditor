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
import pathfinder.data.DiceType;
import pathfinder.data.Character.Alignment;
import pathfinder.data.Character.Alignments;
import pathfinder.data.Classes.Barbarian;
import pathfinder.data.Classes.Class;
import pathfinder.data.Classes.Objects.Feature;
import pathfinder.data.Classes.Objects.LevelTableRow;
import pathfinder.data.Items.ArmorType;
import pathfinder.data.Items.WeaponType;
import pathfinder.data.Skills.Skill;

public class ClassesController extends WindowController {

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

	private ObservableList<Class> obsListClasses = FXCollections
			.observableArrayList();

	/**
	 * Return data as Observable List of Class
	 * 
	 * @return
	 */
	public ObservableList<Class> getObsListClasses() {
		return obsListClasses;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

		// Init the Classes table with the column for class name
		columnClassName.setCellValueFactory(cellData -> cellData.getValue()
				.getNameProperty());

		// Clear person details
		showClassDetails(null);
		//lblDescription.get
		// find the longest label that is not a valued one
		// set the second row of labels X value to the largest + some 'padding' space (probably 10)
		// for each label
		// place second label 10 from the top, move first row label to the center Y of the frist label
		// set 'top' to the bottom of the last 2nd row's label bottom

		// Set data from the observable list of classes to display in the table
		tableClasses.setItems(obsListClasses);

		// Handle changes in selection on Classes table and display appropriate
		// Class data
		tableClasses
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> showClassDetails(newValue));

		readSummary();

	}

	/**
	 * Populate Class Details labels with data from the selected Class
	 * 
	 * @param c
	 *            : selected Class
	 */
	private void showClassDetails(Class c) {
		if (c != null) {
			lblDescription.setText(c.getName());
			lblRole.setText(c.getRole());
			lblRole.setWrapText(true);
			lblAlignments.setText(c.getAlignments());
			lblHitDice.setText("D"+c.getHitDice().toString());
			lblClassSkills.setText(c.getClassSkillsToString());
			lblSkillRanksPerLevel.setText(c.getSkillRanksToString().toString());
			lblWeaponProf.setText(c.getWeaponProfsToString());
			lblArmorProf.setText(c.getArmorProfsToString());
			lblStartingWealthD6.setText(c.getStartingWealthToString()
					.toString());
		} else {
			lblDescription.setText("");
			lblRole.setText("");
			lblAlignments.setText("");
			lblHitDice.setText("");
			lblClassSkills.setText("");
			lblSkillRanksPerLevel.setText("");
			lblWeaponProf.setText("");
			lblArmorProf.setText("");
			lblStartingWealthD6.setText("");
		}
	}

	/**
	 * Reads class summary data
	 */
	private void readSummary() {
		String[] heading;
		Scanner reader;

		try {
			reader = new Scanner(new FileReader(
					"data/Classes - Class summaries.tsv"));
			String readLine = reader.nextLine();

			// Read the first line. The first line contains the HEADINGS. Split
			// by tabs to obtain each heading.
			heading = readLine.split("\t");

			// Continue to read the rest of the file.
			while (reader.hasNextLine()) {
				readLine = reader.nextLine();

				// Make array of Strings to hold all the lines read in.
				String[] lines = readLine.split("\t");

				// className = lines[0];
				// obsListClasses.add(new Class());

				switch (lines[0]) {

				case "Barbarian":
					// barbarian(Classname, description, role, level,
					// requireAlignments, hitDice, startingWealthD6,
					// skillRanksPerLevel, classSkills lines[5], features,
					// weaponProficiencies, armorProficiencies, levelTable)
					obsListClasses.add(new Barbarian(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d12, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(", "),
							new Feature[] { new Feature() },
							new WeaponType[] { WeaponType.Simple },
							new ArmorType[] { ArmorType.LightArmor },
							new LevelTableRow[] { new LevelTableRow() })
					);

					break;

				default:
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(ClassesController.class.toString()).log(
					Level.SEVERE, null, e);
		}
	}
}

package view.partials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jefXif.DataLoader;
import jefXif.WindowController;
import pathfinder.data.DiceType;
import pathfinder.data.Character.Alignments;
import pathfinder.data.Classes.Alchemist;
import pathfinder.data.Classes.Barbarian;
import pathfinder.data.Classes.Bard;
import pathfinder.data.Classes.Cavalier;
import pathfinder.data.Classes.Class;
import pathfinder.data.Classes.Cleric;
import pathfinder.data.Classes.Druid;
import pathfinder.data.Classes.Fighter;
import pathfinder.data.Classes.Gunslinger;
import pathfinder.data.Classes.Inquisitor;
import pathfinder.data.Classes.Magus;
import pathfinder.data.Classes.Monk;
import pathfinder.data.Classes.Ninja;
import pathfinder.data.Classes.Oracle;
import pathfinder.data.Classes.Paladin;
import pathfinder.data.Classes.Ranger;
import pathfinder.data.Classes.Rogue;
import pathfinder.data.Classes.Samurai;
import pathfinder.data.Classes.Sorcerer;
import pathfinder.data.Classes.Summoner;
import pathfinder.data.Classes.Witch;
import pathfinder.data.Classes.Wizard;
import pathfinder.data.Classes.Objects.Feature;
import pathfinder.data.Classes.Objects.LevelTableRow;
import pathfinder.data.Classes.Objects.SpellLevelTableRow;
import pathfinder.data.Spells.Spell;

public class ClassesController extends WindowController implements DataLoader {

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

		//readSummary();

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
			lblSkillRanksPerLevel.setText(Integer.toString(c.getSkillRanksPerLevel()));
			lblWeaponProf.setText(c.getWeaponProfsToString());
			lblArmorProf.setText(c.getArmorProfsToString());
			lblStartingWealthD6.setText(Integer.toString(c.getStartingWealthD6()));
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
		Scanner reader;

		try {
			reader = new Scanner(new FileReader(
					"data/Classes - Class summaries.tsv"));
			String readLine = reader.nextLine();

			// Continue to read the rest of the file.
			while (reader.hasNextLine()) {
				readLine = reader.nextLine();

				// Make array of Strings to hold all the lines read in.
				String[] lines = readLine.split("\t");

				// className = lines[0];
				// obsListClasses.add(new Class());

				switch (lines[0]) {

				case "Barbarian":
					// barbarian(Classname[0], description[1], role[2], level(0),
					// requireAlignments[3], hitDice[4], startingWealthD6[6],
					// skillRanksPerLevel, classSkills lines[5], features,
					// weaponProficiencies[7], armorProficiencies[7], levelTable)
					obsListClasses.add(new Barbarian(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d12, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new LevelTableRow[] { new LevelTableRow() })
					);
					break;
					
				case "Bard":
					obsListClasses.add(new Bard(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new LevelTableRow[] { new LevelTableRow() })
					);
					break;
					
				case "Cleric":
					obsListClasses.add(new Cleric(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Druid":
					obsListClasses.add(new Druid(lines[0], lines[1],
							lines[2], 0, Alignments.AnyNeutral, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Fighter":
					obsListClasses.add(new Fighter(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d10, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new LevelTableRow[] { new LevelTableRow() })
					);
					break;
					
				case "Monk":
					obsListClasses.add(new Monk(lines[0], lines[1],
							lines[2], 0, Alignments.AnyLawful, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new LevelTableRow[] { new LevelTableRow() }, 
							null, 
							null, 
							null, 
							null, 
							null)
					);
					break;
					
				case "Paladin":
					obsListClasses.add(new Paladin(lines[0], lines[1],
							lines[2], 0, Alignments.LawfulGood, DiceType.d10, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Ranger":
					obsListClasses.add(new Ranger(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d10, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Rogue":
					obsListClasses.add(new Rogue(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d10, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new LevelTableRow[] { new LevelTableRow() })
					);
					break;
					
				case "Sorcerer":
					obsListClasses.add(new Sorcerer(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d6, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Wizard":
					obsListClasses.add(new Wizard(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d6, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Alchemist":
					obsListClasses.add(new Alchemist(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Cavalier":
					obsListClasses.add(new Cavalier(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d10, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new LevelTableRow[] { new LevelTableRow() })
					);
					break;
					
				case "Inquisitor":
					obsListClasses.add(new Inquisitor(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Oracle":
					obsListClasses.add(new Oracle(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Summoner":
					obsListClasses.add(new Summoner(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Witch":
					obsListClasses.add(new Witch(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d6, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Magus":
					obsListClasses.add(new Magus(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new HashMap<String,Spell>(),
							new SpellLevelTableRow[] { })
					);
					break;
					
				case "Gunslinger":
					obsListClasses.add(new Gunslinger(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d10, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new LevelTableRow[] { new LevelTableRow() })
					);
					break;
					
				case "Ninja":
					obsListClasses.add(new Ninja(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d8, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
							new LevelTableRow[] { new LevelTableRow() })
					);
					break;
					
				case "Samurai":
					obsListClasses.add(new Samurai(lines[0], lines[1],
							lines[2], 0, Alignments.Any, DiceType.d10, 
							Integer.parseInt(lines[8]), 
							Integer.parseInt(lines[6]),
							lines[5].split(","),
							new Feature[] { new Feature() },
							new String[] { lines[7] },
							new String[] { lines[7] },
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

	@Override
	public void loadData() {
		//load data through jefxif
		readSummary();
	}
}

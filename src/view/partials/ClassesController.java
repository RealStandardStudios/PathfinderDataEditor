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
import pathfinder.data.Attributes.AbilityName;
import pathfinder.data.Attributes.SaveAttribute;
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
	
	private HashMap<String, Class> classes = new HashMap<>();

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

		// Init the Classes table with the column for class Name
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
					classes.put(lines[0],new Barbarian(lines[0], lines[1],
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
					classes.put(lines[0],new Bard(lines[0], lines[1],
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
					classes.put(lines[0],new Cleric(lines[0], lines[1],
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
					classes.put(lines[0],new Druid(lines[0], lines[1],
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
					classes.put(lines[0],new Fighter(lines[0], lines[1],
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
					classes.put(lines[0],new Monk(lines[0], lines[1],
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
					classes.put(lines[0],new Paladin(lines[0], lines[1],
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
					classes.put(lines[0],new Ranger(lines[0], lines[1],
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
					classes.put(lines[0],new Rogue(lines[0], lines[1],
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
					classes.put(lines[0],new Sorcerer(lines[0], lines[1],
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
					classes.put(lines[0],new Wizard(lines[0], lines[1],
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
					classes.put(lines[0],new Alchemist(lines[0], lines[1],
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
					classes.put(lines[0],new Cavalier(lines[0], lines[1],
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
					classes.put(lines[0],new Inquisitor(lines[0], lines[1],
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
					classes.put(lines[0],new Oracle(lines[0], lines[1],
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
					classes.put(lines[0],new Summoner(lines[0], lines[1],
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
					classes.put(lines[0],new Witch(lines[0], lines[1],
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
					classes.put(lines[0],new Magus(lines[0], lines[1],
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
					classes.put(lines[0],new Gunslinger(lines[0], lines[1],
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
					classes.put(lines[0],new Ninja(lines[0], lines[1],
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
					classes.put(lines[0],new Samurai(lines[0], lines[1],
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
	
	/**
	 * Read the class level progression table from the appropriate data file
	 */
	
	private void readMeleeClass(String filename) {
		Scanner reader;
		try {
			reader = new Scanner(new FileReader(
					"data/class_progression/prog_" + filename.toLowerCase()+".tsv"));
			String readLine = reader.nextLine(); //the heading line
			LevelTableRow[] levelTable = new LevelTableRow[20];
			// Continue to read the rest of the file
			int count = 0;
			while(reader.hasNextLine()) {
				readLine = reader.nextLine();
				
				// Make an array of Strings to hold the data
				String[] lines = readLine.split("\t");
				// Split the line on '/' for science
				String[] babString = lines[1].split("/");
				// make an array of ints the same length
				int[] babs = new int[babString.length];
				// set all the babs to the values in the string one, remove the pluses
				for(int i=0;i<babString.length;i++){
					babs[i] = Integer.parseInt(babString[i].replace("+",""));
				}
				//Make a new tableRow(base attack bonus', FortitudeSave, ReflexSave, WillSave, String[])
				LevelTableRow tableRow = new LevelTableRow(babs,
						new SaveAttribute("Fortitude",AbilityName.Constitution,Integer.parseInt(lines[2])),
						new SaveAttribute("Reflex",AbilityName.Dexterity,Integer.parseInt(lines[3])),
						new SaveAttribute("Will",AbilityName.Wisdom,Integer.parseInt(lines[4])),
						lines[5].split(",")
				);
				levelTable[count] = tableRow;
				count++;
			}

			classes.get(filename).SetLevelTable(levelTable);
		}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(ClassesController.class.toString()).log(
					Level.SEVERE, null, e);
		}
	}

	@Override
	public void loadData() {
		//load data through jefxif
		readSummary();
		//load the levelTable for barbarian NOTE THIS NEEDS TO BE PUT INTO THE LEVELTABLE ON THE GUI NOW**************************************************
		readMeleeClass("Barbarian");
		
		obsListClasses.setAll(classes.values());
	}
}

package view.partials;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
import javafx.stage.DirectoryChooser;
import jefXif.DataLoader;
import jefXif.MainPartialController;
import jefXif.io.Data;
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
import pathfinder.data.Items.Armor;
import pathfinder.data.Items.CursedItem;
import pathfinder.data.Items.Goods;
import pathfinder.data.Items.MagicArmor;
import pathfinder.data.Items.MagicRing;
import pathfinder.data.Items.MagicRod;
import pathfinder.data.Items.MagicStaves;
import pathfinder.data.Items.MagicWeapon;
import pathfinder.data.Items.Weapon;
import pathfinder.data.Items.WondrousGood;
import pathfinder.data.Spells.Spell;

/**
 * the controller for the layout of the Classes section of the data editor
 * 
 * @author Real Standard Studios - Matthew Meehan, Ian Larsen
 * @param <T>
 */
public class ClassesController<T> extends MainPartialController implements DataLoader {

	/*
	 * Link Class table fxml entities to the Controller
	 */
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

	/*
	 * Link Class Progression table fxml entities to the Controller
	 */
	@FXML
	private TableView<LevelTableRow> tableLevelTable;

	@FXML
	private TableColumn<LevelTableRow, Integer> columnLevel;

	@FXML
	private TableColumn<LevelTableRow, String> columnBAB;

	@FXML
	private TableColumn<LevelTableRow, Integer> columnFort;

	@FXML
	private TableColumn<LevelTableRow, Integer> columnRef;

	@FXML
	private TableColumn<LevelTableRow, Integer> columnWill;

	@FXML
	private TableColumn<LevelTableRow, String> columnSpecial;
	
	/*
	 * Link Class Progression Spells Per Day Table fxml entities to the Controller
	 */
	
	@FXML
	private TableView<SpellLevelTableRow> tableSpellLevelTable;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> columnLevelSpells;

	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column0;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column1st;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column2nd;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column3rd;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column4th;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column5th;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column6th;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column7th;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column8th;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column9th;
	
	/*
	 * Link Class Progression Spells Known Table fxml entities to the Controller
	 */
	
	@FXML
	private TableView<SpellLevelTableRow> tableSpellsKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> columnLevelSpellsKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column0Known;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column1stKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column2ndKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column3rdKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column4thKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column5thKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column6thKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column7thKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column8thKnown;
	
	@FXML
	private TableColumn<SpellLevelTableRow, Integer> column9thKnown;
	
	
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

	/**
	 * the initialisation method
	 */
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

		// Init the Classes table with the column for class Name
		columnClassName.setCellValueFactory(cellData -> cellData.getValue()
				.getNameProperty());

		// Clear class details
		showClassDetails(null);

		// Set data from the observable list of classes to display in the table
		tableClasses.setItems(obsListClasses);

		// Handle changes in selection on Classes table and display appropriate
		// Class data
		tableClasses
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> showClassDetails(newValue));

		// Init the Class Progression Level Table with columns
		columnLevel.setCellValueFactory(cellData -> cellData.getValue()
				.getLevelNumProperty());
		columnBAB.setCellValueFactory(cellData -> cellData.getValue()
				.getBABProperty());
		columnFort.setCellValueFactory(cellData -> cellData.getValue()
				.getFortSave().getBaseValueProperty());
		columnRef.setCellValueFactory(cellData -> cellData.getValue()
				.getRefSave().getBaseValueProperty());
		columnWill.setCellValueFactory(cellData -> cellData.getValue()
				.getWillSave().getBaseValueProperty());
		columnSpecial.setCellValueFactory(cellData -> cellData.getValue()
				.getSpecialProperty());
		
		// Init the Class Progression Spell Level Table with columns
		columnLevelSpells.setCellValueFactory(cellData -> cellData.getValue()
				.getLevelNumProperty());
		column0.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[0]);
		column1st.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[1]);
		column2nd.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[2]);
		column3rd.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[3]);
		column4th.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[4]);
		column5th.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[5]);
		column6th.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[6]);
		column7th.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[7]);
		column8th.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[8]);
		column9th.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[9]);
		
		// Init the Class Progression Spells Known Table with columns
		columnLevelSpellsKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getLevelNumProperty());
		column0Known.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[0]);
		column1stKnown.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[1]);
		column2ndKnown.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[2]);
		column3rdKnown.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[3]);
		column4thKnown.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[4]);
		column5thKnown.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[5]);
		column6thKnown.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[6]);
		column7thKnown.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[7]);
		column8thKnown.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[8]);
		column9thKnown.setCellValueFactory(cellData -> cellData.getValue().getSpellsPerDay()[9]);
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
			lblHitDice.setText("D" + c.getHitDice().toString());
			lblClassSkills.setText(c.getClassSkillsToString());
			lblSkillRanksPerLevel.setText(Integer.toString(c
					.getSkillRanksPerLevel()));
			lblWeaponProf.setText(c.getWeaponProfsToString());
			lblArmorProf.setText(c.getArmorProfsToString());
			lblStartingWealthD6.setText(Integer.toString(c
					.getStartingWealthD6()));
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
		showClassProgression(c);
	}

	private void showClassProgression(Class c) {
		// We were here last, there is no spell shit showing up
		if (c != null) {
			tableLevelTable.setItems(c.getLeveltableRow());
			if(c.getLeveltableRow().getClass().isAssignableFrom(SpellLevelTableRow.class)) {
				ArrayList<SpellLevelTableRow> spellcaster = new ArrayList<SpellLevelTableRow>();
				for (LevelTableRow levelTableRow : c.getLeveltableRow()) {
					spellcaster.add((SpellLevelTableRow)levelTableRow);
				}
				
				tableSpellLevelTable.setItems(FXCollections.observableArrayList(spellcaster));
				tableSpellsKnown.setItems(FXCollections.observableArrayList(spellcaster));
			}			
		} else {
			tableLevelTable.setItems(null);
			tableSpellLevelTable.setItems(null);
		}
	}

	/**
	 * Reads class summary data from a .tsv file breaks it into component parts
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
					// barbarian(Classname[0], description[1], role[2],
					// level(0),
					// requireAlignments[3], hitDice[4], startingWealthD6[6],
					// skillRanksPerLevel, classSkills lines[5], features,
					// weaponProficiencies[7], armorProficiencies[7],
					// levelTable)
					classes.put(
							lines[0],
							new Barbarian(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d12, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() })
					/*
					 * Level Table Row: Secondary reader to read in
					 * LevelTableRow from the data file for each class. Add the
					 * LevelTableRow to the LevelTableRow[] array. Repeat for
					 * the 20 rows.
					 * 
					 * Make a method to do that ^ and call it from here.
					 * Probably need to conditionalise the method for each Class
					 * so it gets the right data.
					 */
					);
					break;

				case "Bard":
					classes.put(
							lines[0],
							new Bard(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Cleric":
					classes.put(
							lines[0],
							new Cleric(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Druid":
					classes.put(
							lines[0],
							new Druid(lines[0], lines[1], lines[2], 0,
									Alignments.AnyNeutral, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Fighter":
					classes.put(
							lines[0],
							new Fighter(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d10, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() }));
					break;

				case "Monk":
					classes.put(
							lines[0],
							new Monk(
									lines[0],
									lines[1],
									lines[2],
									0,
									Alignments.AnyLawful,
									DiceType.d8,
									Integer.parseInt(lines[8]),
									Integer.parseInt(lines[6]),
									lines[5].split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() },
									null, null, null, null, null));
					break;

				case "Paladin":
					classes.put(
							lines[0],
							new Paladin(lines[0], lines[1], lines[2], 0,
									Alignments.LawfulGood, DiceType.d10,
									Integer.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Ranger":
					classes.put(
							lines[0],
							new Ranger(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d10, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Rogue":
					classes.put(
							lines[0],
							new Rogue(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d10, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() }));
					break;

				case "Sorcerer":
					classes.put(
							lines[0],
							new Sorcerer(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d6, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Wizard":
					classes.put(
							lines[0],
							new Wizard(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d6, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Alchemist":
					classes.put(
							lines[0],
							new Alchemist(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Cavalier":
					classes.put(
							lines[0],
							new Cavalier(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d10, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() }));
					break;

				case "Inquisitor":
					classes.put(
							lines[0],
							new Inquisitor(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Oracle":
					classes.put(
							lines[0],
							new Oracle(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Summoner":
					classes.put(
							lines[0],
							new Summoner(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Witch":
					classes.put(
							lines[0],
							new Witch(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d6, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Magus":
					classes.put(
							lines[0],
							new Magus(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new HashMap<String, Spell>(),
									new SpellLevelTableRow[] {}));
					break;

				case "Gunslinger":
					classes.put(
							lines[0],
							new Gunslinger(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d10, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() }));
					break;

				case "Ninja":
					classes.put(
							lines[0],
							new Ninja(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() }));
					break;

				case "Samurai":
					classes.put(
							lines[0],
							new Samurai(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d10, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									new Feature[] { new Feature() },
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() }));
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

	private void readCommonLevelTable(String filename) {
		Scanner reader;
		try {
			reader = new Scanner(new FileReader("data/class_progression/prog_"
					+ filename.toLowerCase() + ".tsv"));
			String readLine = reader.nextLine(); // the heading line

			LevelTableRow[] levelTable = new LevelTableRow[20];
			// Continue to read the rest of the file
			int count = 0;
			while (reader.hasNextLine()) {
				readLine = reader.nextLine();
				// Make an array of Strings to hold the data
				// lines[0] Level; [1] BAB; [2] Fort; [3] Ref; [4] Will; [5] Special
				String[] lines = readLine.split("\t");
				
				int levelNum = Integer.parseInt(lines[0]);
				
				// Split lines[1] (BAB) on '/' to handle BAB data for higher
				// levels
				String[] babString = lines[1].split("/");
				// make an array of ints the same length
				int[] babs = new int[babString.length];
				// set all the babs to the values in the string one, remove the
				// pluses
				for (int i = 0; i < babString.length; i++) {
					babs[i] = Integer.parseInt(babString[i].replace("+", ""));
				}
				// Make a new tableRow(levelNum, BaseAttackBonus, FortitudeSave,
				// ReflexSave, WillSave, String[])
				int fort = Integer.parseInt(lines[2].replace("+", "").trim()), 
						ref = Integer.parseInt(lines[3].replace("+", "").trim()), 
						will = Integer.parseInt(lines[4].replace("+", "").trim());
				// lines[0]-[5] is common data.  [6]+ is Spell Level Table data.
				// If lines has more than 6 parts, send filename and lines to the method to handle Spell Level Data
				LevelTableRow tableRow = null;
				if(lines.length > 6) {
					tableRow = new SpellLevelTableRow(levelNum, babs, new SaveAttribute("Fortitude",AbilityName.Constitution,fort), 
							new SaveAttribute("Reflex",AbilityName.Dexterity,ref), 
							new SaveAttribute("Will",AbilityName.Wisdom, will), 
							lines[5].split(","), new int[10], new int[10]);
					tableRow = readSpellLevelTable(filename, lines, (SpellLevelTableRow)tableRow);
				}
				else
					tableRow = new LevelTableRow(levelNum, babs,
							new SaveAttribute("Fortitude",AbilityName.Constitution,fort), 
							new SaveAttribute("Reflex",AbilityName.Dexterity,ref), 
							new SaveAttribute("Will",AbilityName.Wisdom, will), 
							lines[5].split(","));
				levelTable[count] = tableRow;
				count++;
				
			} //End while next line

			classes.get(filename).SetLevelTable(
					FXCollections.observableArrayList(levelTable));
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(ClassesController.class.toString()).log(
					Level.SEVERE, null, e);
		}
	} //End readCommonLevelTable
	
	private LevelTableRow readSpellLevelTable(String filename, String[] lines, SpellLevelTableRow tableRow) {
		//Spells per day Levels 0-9
		if(filename == "cleric" || filename == "druid" || filename == "wizard" || filename == "witch") {
			int[] spd = new int[10];
			for (int i = 6; i < spd.length; i++) {
				spd[i] = Integer.parseInt(lines[i]);
			}
			tableRow.setSpellsPerDay(spd);
		}
		
		//Spells per day Levels 1-9, Spells Known 0-9
		else if(filename == "sorcerer" || filename == "oracle") {
			
		}
		
		//Spells per day Levels 1-6, Spells Known 0-6
		else if(filename == "bard" || filename == "inquisitor" || filename == "summoner") {
			
		}
		
		//Spells per day Levels 1-4
		else if(filename == "paladin" || filename == "ranger") {

		}

		//Spells per day Levels 0-6
		else if (filename == "magus") {

		}

		//Spells per day Levels 1-6: "alchemist" - the only one left
		else {

		}
		return tableRow;

	} //End readSpellLevelTable	
	

	/**
	 * loads data
	 */
	@Override
	public void loadData(File file) {
		// load data through jefxif
		readSummary();
		
		// Melee classes.  Generic Level Table information is fine.
		
		readCommonLevelTable("Barbarian");
		readCommonLevelTable("Cavalier");
		readCommonLevelTable("Fighter");
		readCommonLevelTable("Gunslinger");
		readCommonLevelTable("Ninja");
		readCommonLevelTable("Rogue");
		readCommonLevelTable("Samurai");
				
		// Caster classes.  Use Generic Level Table, add on Spell Level Table information.
		readCommonLevelTable("Alchemist");
		readCommonLevelTable("Bard");
		readCommonLevelTable("Cleric");
		readCommonLevelTable("Druid");
		readCommonLevelTable("Inquisitor");
		readCommonLevelTable("Magus");
		readCommonLevelTable("Oracle");
		readCommonLevelTable("Paladin");
		readCommonLevelTable("Ranger");
		readCommonLevelTable("Sorcerer");
		readCommonLevelTable("Summoner");
		readCommonLevelTable("Witch");
		readCommonLevelTable("Wizard");

		obsListClasses.setAll(classes.values());
	}

	@Override
	public void saveDataToFile(File filePath) throws IOException {
        	DirectoryChooser directoryChooser = new DirectoryChooser();
        	
        	directoryChooser.setTitle("Data Directory");
        	File defaultDirectory = new File(this.getClass().getResource("").getPath()+"\\..\\..\\..\\..\\PathfinderData\\Data");
        	if(defaultDirectory.exists())
        		directoryChooser.setInitialDirectory(defaultDirectory);
        	else {
        		defaultDirectory.mkdirs();
        		directoryChooser.setInitialDirectory(defaultDirectory);
        	}
            // Show the directory chooser
            File file = directoryChooser.showDialog(this.getInterface().getPrimaryStage());

            if (file != null) {
                Data.Write(file.getPath()+"\\Classes.idf", obsListClasses.toArray());
            }
        }
//	}

	@Override
	public void loadDataFromFile(File file) throws IOException {
		file = new File(this.getClass().getResource("").getPath()+"\\..\\..\\..\\..\\PathfinderData\\Data");
		File classFile = new File(file.getPath()+"\\Classes.idf");
			if(!classFile.exists()) {			
				readSummary();
			}
			else {
				try {
					obsListClasses.setAll(readDataFile(classFile, Class.class));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
	}
	
	@SuppressWarnings("unchecked")
	private <T> ArrayList<T> readDataFile(File file,  java.lang.Class<T> dataClass)
			throws IOException {
		ArrayList<T> arrayList = new ArrayList<T>();
		Object[] readItems = Data.Read(file.getPath(), Object[].class);
		for (Object object : readItems) {
			arrayList.add((T)object);
		}
		return arrayList;
	}
	
}

package view.partials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jefXif.DataLoader;
import jefXif.WindowController;
import pathfinder.data.Spells.Spell;

/**
 * @author Kenneth Cooper
 * @description A controller class for Spells that interacts with
 */
public class SpellsController extends WindowController implements DataLoader {

	private ObservableList<Spell> spellData = FXCollections
			.observableArrayList();

	public SpellsController() {
		// Test data for now
		// spellData
		// .add(new Spell(
		// "Ablative Barrier",
		// "conjuration (creation) [force]",
		// new String[] { "alchemist", "magus", "sorceror/wizard",
		// "summoner" },
		// new int[] { 2, 2, 3, 2 },
		// "1 standard action",
		// "V, S, M (a piece of metal cut from a shield)",
		// "touch",
		// "creature touched",
		// null,
		// null,
		// "1 hour/level or until discharged",
		// "Will negates (harmless)",
		// "no",
		// "Invisible layers of solid force surround and protect the target, granting that target a +2 armor bonus to AC. Additionally, the first 5 points of lethal damage the target takes from each attack are converted into nonlethal damage. Against attacks that already deal nonlethal damage, the target gains DR 5/—. Once this spell has converted 5 points of damage to nonlethal damage per caster level (maximum 50 points), the spell is discharged.",
		// null));
		// readData();
	}

	/**
	 * 
	 * @returns an ObservableList of Spells
	 */
	public ObservableList<Spell> getSpellData() {
		return spellData;
	}

	@FXML
	private TableView<Spell> spellTable;
	@FXML
	private TableColumn<Spell, String> spellColumn;

	@FXML
	private Label schoolLabel;
	@FXML
	private Label spellLevelLabel;
	@FXML
	private Label castingTimeLabel;
	@FXML
	private Label componentsLabel;
	@FXML
	private Label rangeLabel;
	@FXML
	private Label targetEffectAreaLabel;
	@FXML
	private Label durationLabel;
	@FXML
	private Label savingThrowLabel;
	@FXML
	private Label spellResistanceLabel;
	@FXML
	private Label descriptionLabel;

	@FXML
	private ImageView tableOneImageView;
	@FXML
	private ImageView tableTwoImageView;
	@FXML
	private ImageView tableThreeImageView;

	/**
	 * Initializes values for the class
	 */
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		spellTable.setItems(spellData);

		spellColumn.setCellValueFactory(cellData -> cellData.getValue()
				.getNameProperty());

		showSpellDetails(null);

		spellTable
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> showSpellDetails(newValue));
	}

	/**
	 * Shows the details for a spell based on the input information.
	 * 
	 * @param spell
	 */
	private void showSpellDetails(Spell spell) {
		if (spell != null) {
			// Fill the table with info from the Spell object
			schoolLabel.setText(spell.getSchool());
			spellLevelLabel.setText(spell.getClassAndSpellLevel());
			castingTimeLabel.setText(spell.getCastingTime());
			componentsLabel.setText(spell.getComponents());
			rangeLabel.setText(spell.getRange());
			targetEffectAreaLabel.setText(spell.getTarget());
			durationLabel.setText(spell.getDuration());
			savingThrowLabel.setText(spell.getSavingThrow());
			spellResistanceLabel.setText(spell.isSpellResistance());
			descriptionLabel.setText(spell.getDescription());
			descriptionLabel.setWrapText(true);
			descriptionLabel.setPadding(new Insets(50, 0, 0, 0));
			// need a loop that reads from an array and if has data, places data
			// into tableImageViews
			if (spell.getTablePicture() != null) {
				switch (spell.getTablePicture().length()) {
				case 1:
					tableOneImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePictures()[0]));
					tableTwoImageView.setImage(null);
					tableThreeImageView.setImage(null);
					break;
				case 2:
					tableOneImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePictures()[0]));
					tableTwoImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePictures()[1]));
					tableThreeImageView.setImage(null);
					break;
				case 3:
					tableOneImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePictures()[0]));
					tableTwoImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePictures()[1]));
					tableThreeImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePictures()[2]));
					break;
				default:
					tableOneImageView.setImage(null);
					tableTwoImageView.setImage(null);
					tableThreeImageView.setImage(null);
					break;
				}
			}

		} else {
			// Spell is null, remove all text
			schoolLabel.setText("");
			spellLevelLabel.setText("");
			castingTimeLabel.setText("");
			componentsLabel.setText("");
			rangeLabel.setText("");
			targetEffectAreaLabel.setText("");
			durationLabel.setText("");
			savingThrowLabel.setText("");
			spellResistanceLabel.setText("");
			descriptionLabel.setText("");
			tableOneImageView.setImage(null);
			tableTwoImageView.setImage(null);
			tableThreeImageView.setImage(null);
		}
	}

	private void readData() {
		try {
			Scanner scn = new Scanner(new FileReader(
					"data/Spell Data - Sheet1.tsv"));

			scn.nextLine();
			String line;

			// System.out.println(line); // The information for one spell
			while (scn.hasNextLine()) {
				line = scn.nextLine();

				String[] parts = line.split("\t"); // Spell is split into each
													// of it's component parts

				String[] levelParts = parts[2].split(","); // Splits the Spell
															// level into the
															// different classes

				String[] classParts = null; // Holds the levelParts split up
											// into the formula [string] [int]
				String[] className = new String[levelParts.length]; // holds
																	// class
																	// names
				int[] levelNum = new int[levelParts.length]; // holds class
																// levels

				for (String string : levelParts) {
					classParts = string.trim().split(" ");

					for (int i = 0; i < classParts.length; i++) {
						if (i % 2 == 0) {
							className[i / 2] = classParts[i];
						} else {
							levelNum[i / 2] = Integer.parseInt(classParts[i]);
						}
					}
				}

				String[] tableParts = null;

				if (parts.length == 14) {
					tableParts = parts[13].trim().split(",");
				}

				// Test data for now
				// spellData
				// .add(new Spell(
				// "Ablative Barrier",
				// "conjuration (creation) [force]",
				// new String[] { "alchemist", "magus", "sorceror/wizard",
				// "summoner" },
				// new int[] { 2, 2, 3, 2 },
				// "1 standard action",
				// "V, S, M (a piece of metal cut from a shield)",
				// "touch",
				// "creature touched",
				// null,
				// null,
				// "1 hour/level or until discharged",
				// "Will negates (harmless)",
				// "no",
				// "Invisible layers of solid force surround and protect the target, granting that target a +2 armor bonus to AC. Additionally, the first 5 points of lethal damage the target takes from each attack are converted into nonlethal damage. Against attacks that already deal nonlethal damage, the target gains DR 5/—. Once this spell has converted 5 points of damage to nonlethal damage per caster level (maximum 50 points), the spell is discharged.",
				// null));
				spellData.add(new Spell(parts[0], parts[1], className,
						levelNum, parts[3], parts[4], parts[5], parts[6],
						parts[7], parts[8], parts[9], parts[10], parts[11],
						parts[12], tableParts));
			}

			scn.close();
		} catch (FileNotFoundException e) {

		}
	}

	@Override
	public void loadData() {
		// This is where it will read in the file saved through the program or
		// use the tsvs as a fallback
		readData();
	}
}

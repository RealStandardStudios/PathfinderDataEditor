package view.partials;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jefXif.MainPartialController;
import jefXif.interfaces.DataLoader;
import jefXif.io.Data;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Spells.Spell;
import view.partials.dialogs.SpellEditDialogController;

/**
 * A controller class for Spells that interacts with
 * 
 * @author Real Standard Studios - Kenneth Cooper
 */
public class SpellsController extends MainPartialController implements DataLoader {

	private ObservableList<Spell> spellData = FXCollections
			.observableArrayList();

	@FXML
	private TableView<Spell> spellTable;
	@FXML
	private TableColumn<Spell, String> spellColumn;

	@FXML
	private Label nameLabel;
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
	private Label descriptionTextArea;

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
	 * Empty Controller
	 */
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
	 * @returns an ObservableList of Spells
	 */
	public ObservableList<Spell> getSpellData() {
		return spellData;
	}

	/**
	 * Shows the details for a spell based on the input information.
	 * 
	 * @param spell
	 */
	private void showSpellDetails(Spell spell) {
		if (spell != null) {
			// Fill the table with info from the Spell object
			nameLabel.setText(spell.getName());
			schoolLabel.setText(spell.getSchool());
			spellLevelLabel.setText(spell.getClassAndSpellLevel());
			castingTimeLabel.setText(spell.getCastingTime());
			componentsLabel.setText(spell.getComponents());
			rangeLabel.setText(spell.getRange());
			String line = spell.getTarget() + ", " + spell.getEffect() + ", " + spell.getArea();
			targetEffectAreaLabel.setText(line);
			durationLabel.setText(spell.getDuration());
			savingThrowLabel.setText(spell.getSavingThrow());
			spellResistanceLabel.setText(spell.isSpellResistance());
			descriptionLabel.setText(spell.getDescription());
			//descriptionLabel.setWrapText(true);
			//descriptionLabel.setPadding(new Insets(50, 0, 0, 0));

			if (!spell.getTablePicture().equals("")) {
				switch (spell.getTablePicture().length()) {
				case 1:
					tableOneImageView.setImage(new Image(
							"file:resources/images/SpellTables/"
									+ spell.getTablePictures()[0]));
					tableTwoImageView.setImage(null);
					tableThreeImageView.setImage(null);
					break;
				case 2:
					tableOneImageView.setImage(new Image(
							"file:resources/images/SpellTables/"
									+ spell.getTablePictures()[0]));
					tableTwoImageView.setImage(new Image(
							"file:resources/images/SpellTables/"
									+ spell.getTablePictures()[1]));
					tableThreeImageView.setImage(null);
					break;
				case 3:
					tableOneImageView.setImage(new Image(
							"file:resources/images/SpellTables/"
									+ spell.getTablePictures()[0]));
					tableTwoImageView.setImage(new Image(
							"file:resources/images/SpellTables/"
									+ spell.getTablePictures()[1]));
					tableThreeImageView.setImage(new Image(
							"file:resources/images/SpellTables/"
									+ spell.getTablePictures()[2]));
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
			nameLabel.setText("");
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

	/**
	 * reads Spell data from a .tsv file and breaks it into it's
	 * component parts
	 */
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
				HashMap<String, Integer> spellLevels = new HashMap<>();

				for (String string : levelParts) {
					classParts = string.trim().split(" ");
					String className = "";
					int levelNum = 0;

					for (int i = 0; i < classParts.length; i++) {
						if (i % 2 == 0) {
							className = classParts[i];
						} else {
							levelNum = Integer.parseInt(classParts[i]);
						}
						spellLevels.put(className, levelNum);
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
				spellData.add(new Spell(parts[0], parts[1], spellLevels,
						parts[3], parts[4], parts[5], parts[6], parts[7],
						parts[8], parts[9], parts[10], parts[11], parts[12],
						tableParts));
			}

			scn.close();
		} catch (FileNotFoundException e) {

		}
	}

	/**
	 * a method for loading data
	 */
	@Override
	public void loadData(File file) {
		// This is where it will read in the file saved through the program or
		// use the tsvs as a fallback
		readData();
	}
	
	/**
	 * Opens a dialog to edit details for the specified spell.  If the user
	 * clicks OK, the changes are saved into the provided spell object and true
	 * is returned.
	 * 
	 * @param spell  the spell object to be edited
	 * @return true if the user clicked OK, false otherwise
	 */
	public boolean showSpellEditDialog(Spell spell) {
		try {
			// Load the fxml file and create a new stage for the popup dialog
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SpellsController.class.getResource("dialogs/SpellEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			// create the Dialog stage
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Spell");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getInterface().getPrimaryStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			
			// Set the spell into the Controller
			SpellEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSpell(spell);
			
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();
			
			return controller.isOkayClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * Called when the user clicks the edit button.  Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditSpell() {
		Spell selectedSpell = spellTable.getSelectionModel().getSelectedItem();
		if (selectedSpell != null) {
			boolean okClicked = showSpellEditDialog(selectedSpell);
			if (okClicked) {
				showSpellDetails(selectedSpell);
			}
		} else {
			// Nothing selected
			Dialogs.create()
				.title("No Selection")
				.masthead("No Spell Selected")
				.message("Please select a spell in the table.")
				.showWarning();
		}
	}

	/**
	 * a method for saving data to a file
	 */
	@Override
	public void saveDataToFile(File filePath) throws IOException {
        	DirectoryChooser directoryChooser = new DirectoryChooser();
        	
        	directoryChooser.setTitle("Data Directory");
        	File defaultDirectory = new File(this.getClass().getResource("").getPath()+pathfinderDataLoc);
        	if(defaultDirectory.exists())
        		directoryChooser.setInitialDirectory(defaultDirectory);
        	else {
        		defaultDirectory.mkdirs();
        		directoryChooser.setInitialDirectory(defaultDirectory);
        	}
            // Show the directory chooser
            File file = directoryChooser.showDialog(this.getInterface().getPrimaryStage());

            if (file != null) {
                Data.Write(file.getPath()+"\\Spells.sdf", spellData.toArray());
            }
        }
//	}

	/**
	 * a method for loading data from a file
	 */
	@Override
	public void loadDataFromFile(File file) throws IOException {
		file = new File(this.getClass().getResource("").getPath()+pathfinderDataLoc);
		File spellFile = new File(file.getPath()+"\\Spells.sdf");
			if(!spellFile.exists()) {			
				readData();
			}
			else {
				try {
					spellData.setAll(readDataFile(spellFile, Spell.class));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
	}
}

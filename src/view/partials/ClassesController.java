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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jefXif.DataLoader;
import jefXif.MainPartialController;
import jefXif.io.Data;

import org.controlsfx.dialog.Dialogs;

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
import pathfinder.data.Classes.Objects.LevelTable.LevelTableRow;
import pathfinder.data.Classes.Objects.LevelTable.MonkLevelTableRow;
import pathfinder.data.Classes.Objects.LevelTable.SpellLevelTableRow;
import pathfinder.data.Spells.Spell;
import view.partials.dialogs.ClassDescriptionsEditDialogController;
import view.partials.dialogs.ClassFeatureEditDialogController;
import view.partials.dialogs.LevelTableEditDialogController;
import view.partials.dialogs.SpellKnowenTableEditDialogController;
import view.partials.dialogs.SpellLevelTableEditDialogController;
import editor.Tools;

/**
 * the controller for the layout of the Classes section of the data editor
 * 
 * @author Real Standard Studios - Matthew Meehan, Ian Larsen
 */
public class ClassesController extends MainPartialController implements
		DataLoader {
	
	@FXML
	private TableView<Class> tableClasses;

	@FXML
	private TableColumn<Class, String> columnClassName;

	//region Class Description Labels	
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
	//endregion

	//region Class Progression table
	@FXML
	private Tab tabLevelTable;

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

	TableColumn[] levelTable;
	//endregion

	//region Spells Per Level Table
	@FXML
	private Tab tabSpellLevelTable;

	@FXML
	private TableView<SpellLevelTableRow> tableSpellLevelTable;

	@FXML
	private TableColumn<SpellLevelTableRow, Integer> columnLevelSpells;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column0;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column1st;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column2nd;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column3rd;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column4th;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column5th;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column6th;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column7th;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column8th;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column9th;

	TableColumn[] spellLevelTable;
	//endregion

	//region Spells Known Table
	@FXML
	private Tab tabSpellsKnown;

	@FXML
	private TableView<SpellLevelTableRow> tableSpellsKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, Integer> columnLevelSpellsKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column0Known;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column1stKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column2ndKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column3rdKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column4thKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column5thKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column6thKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column7thKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column8thKnown;

	@FXML
	private TableColumn<SpellLevelTableRow, String> column9thKnown;
	
	TableColumn[] spellKnowenTable;
	
	//endregion

	//region Monk Level Table
	@FXML
	private Tab tabMonkSpecials;

	@FXML
	private TableView<MonkLevelTableRow> tableMonkTable;

	@FXML
	private TableColumn<MonkLevelTableRow, String> columnFOB;

	@FXML
	private TableColumn<MonkLevelTableRow, String> columnUnarmed;

	@FXML
	private TableColumn<MonkLevelTableRow, String> columnAcBonus;

	@FXML
	private TableColumn<MonkLevelTableRow, String> columnFastMovement;
	
	TableColumn[] monkTable;

	//endregion

	//region Class Features
	@FXML
	private TableView<Feature> tableFeatures;

	@FXML
	private TableColumn<Feature, String> columnFeatureName;

	@FXML
	private TableColumn<Feature, String> columnFeatureType;

	@FXML
	private TableColumn<Feature, String> columnFeatureDesctiption;

	@FXML
	private TableColumn<Feature, String> columnFeatureEffect;

	TableColumn[] featuresTable;
	//endregion

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

	@FXML
	public void handleDrag(MouseEvent event) {
		System.out.println("I am dragging, no one likes me");
	}

	/**
	 * the initialization method
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

		//region Init the Class Progression Level Table with columns
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
		//endregion

		//region Init the Class Progression Spell Level Table with columns
		columnLevelSpells.setCellValueFactory(cellData -> cellData.getValue()
				.getLevelNumProperty());
		column0.setCellValueFactory(cellData -> cellData.getValue().getSPD()[0]);
		column1st
				.setCellValueFactory(cellData -> cellData.getValue().getSPD()[1]);
		column2nd
				.setCellValueFactory(cellData -> cellData.getValue().getSPD()[2]);
		column3rd
				.setCellValueFactory(cellData -> cellData.getValue().getSPD()[3]);
		column4th
				.setCellValueFactory(cellData -> cellData.getValue().getSPD()[4]);
		column5th
				.setCellValueFactory(cellData -> cellData.getValue().getSPD()[5]);
		column6th
				.setCellValueFactory(cellData -> cellData.getValue().getSPD()[6]);
		column7th
				.setCellValueFactory(cellData -> cellData.getValue().getSPD()[7]);
		column8th
				.setCellValueFactory(cellData -> cellData.getValue().getSPD()[8]);
		column9th
				.setCellValueFactory(cellData -> cellData.getValue().getSPD()[9]);
		//endregion

		//region Init the Class Progression Spells Known Table with columns
		columnLevelSpellsKnown.setCellValueFactory(cellData -> cellData
				.getValue().getLevelNumProperty());
		column0Known.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[0]);
		column1stKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[1]);
		column2ndKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[2]);
		column3rdKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[3]);
		column4thKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[4]);
		column5thKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[5]);
		column6thKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[6]);
		column7thKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[7]);
		column8thKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[8]);
		column9thKnown.setCellValueFactory(cellData -> cellData.getValue()
				.getSpellsKnown()[9]);
		//endregion

		//region Init the Monk progression table with columns
		columnFOB.setCellValueFactory(celldata -> celldata.getValue()
				.getFlurryOfBlowsString());
		columnUnarmed.setCellValueFactory(cellData -> cellData.getValue()
				.getUnarmedDamageProperty());
		columnAcBonus.setCellValueFactory(cellData -> cellData.getValue()
				.getAcBonusProperty());
		columnFastMovement.setCellValueFactory(cellData -> cellData.getValue()
				.getFastMovementProperty());
		//endregion
		
		//region Init the features table with columns
		columnFeatureName.setCellValueFactory(cellData -> cellData.getValue()
				.getNameProperty());
		columnFeatureType.setCellValueFactory(cellData -> cellData.getValue()
				.getTypeProperty());
		columnFeatureDesctiption.setCellValueFactory(cellData -> cellData
				.getValue().getDescriptionProperty());
		// columnFeatureEffect.setCellValueFactory(cellData ->
		// cellData.getValue().getEffectProperty().get().getNameProperty());
		//endregion

		// Array of Table Columns
		levelTable = new TableColumn[] { columnLevel, columnBAB,
				columnFort, columnRef, columnWill, columnSpecial };
		// table.getcolumns().adListener(new
		// ListChangeListenet<TableColumn<DataType,?>>() { }
		tableLevelTable.getColumns().addListener(
				new ListChangeListener<TableColumn<LevelTableRow, ?>>() {
					public boolean suspended;

					@Override
					public void onChanged(
							Change<? extends TableColumn<LevelTableRow, ?>> change) {
						change.next();

						if (change.wasReplaced() && !suspended) {
							this.suspended = true;
							// array of table columns as defined above
							tableLevelTable.getColumns().setAll(
									levelTable);
							this.suspended = false;
						}

					}

				});

		spellLevelTable = new TableColumn[] { columnLevelSpells, column0,
				column1st, column2nd, column3rd, column4th, column5th,
				column6th, column7th, column8th, column9th };

		tableSpellLevelTable.getColumns().addListener(
				new ListChangeListener<TableColumn<SpellLevelTableRow, ?>>() {
					public boolean suspended;

					@Override
					public void onChanged(
							Change<? extends TableColumn<SpellLevelTableRow, ?>> change) {
						change.next();

						if (change.wasReplaced() && !suspended) {
							this.suspended = true;
							// array of table columns as defined above
							tableSpellLevelTable.getColumns().setAll(
									spellLevelTable);
							this.suspended = false;
						}

					}

				});

		spellKnowenTable = new TableColumn[] { columnLevelSpellsKnown,
				column0Known, column1stKnown, column2ndKnown, column3rdKnown,
				column4thKnown, column5thKnown, column6thKnown, column7thKnown,
				column8thKnown, column9thKnown };
		
		tableSpellsKnown.getColumns().addListener(
				new ListChangeListener<TableColumn<SpellLevelTableRow, ?>>() {
					public boolean suspended;

					@Override
					public void onChanged(
							Change<? extends TableColumn<SpellLevelTableRow, ?>> change) {
						change.next();

						if (change.wasReplaced() && !suspended) {
							this.suspended = true;
							// array of table columns as defined above
							tableSpellsKnown.getColumns().setAll(
									spellKnowenTable);
							this.suspended = false;
						}

					}

				});

		monkTable = new TableColumn[] {
			columnFOB,columnUnarmed,columnAcBonus,columnFastMovement	
		};
		
		tableMonkTable.getColumns().addListener(
				new ListChangeListener<TableColumn<MonkLevelTableRow, ?>>(){
					public boolean suspended;
					
					@Override
					public void onChanged(Change<? extends TableColumn<MonkLevelTableRow,?>> change) {
						change.next();
						
						if(change.wasReplaced() && !suspended) {
							this.suspended = true;
							
							tableMonkTable.getColumns().setAll(monkTable);
						}
					}
				});

		featuresTable = new TableColumn[] { columnFeatureName,
				columnFeatureType, columnFeatureDesctiption,
				columnFeatureEffect };

		tableFeatures.getColumns().addListener(
				new ListChangeListener<TableColumn<Feature, ?>>() {
					public boolean suspended;

					@Override
					public void onChanged(
							Change<? extends TableColumn<Feature, ?>> change) {
						change.next();

						if (change.wasReplaced() && !suspended) {
							this.suspended = true;
							tableFeatures.getColumns().setAll(featuresTable);
							this.suspended = false;
						}
					}
				});
	}

	@FXML
	private void handleEditDetails(ActionEvent event) {
		Class selectedClass = tableClasses.getSelectionModel()
				.getSelectedItem();
		if (selectedClass != null) {
			boolean okayClicked = showEditDetailDialog(selectedClass);
		} else {
			Dialogs.create().title("No Selection")
					.masthead("No Class selected")
					.message("Select a Class from the table.").showWarning();
		}
	}
	
	@FXML
	private void handleEditFeature(ActionEvent event) {
		Feature selectedFeature = tableFeatures.getSelectionModel().getSelectedItem();
		if(selectedFeature!= null) {
			boolean okayClicked = showEditFeatureDialog(selectedFeature);
		} else {
			Dialogs.create().title("No Selection")
			.masthead("No Feature selected")
			.message("Select a Feature from the table.").showWarning();
		}
	}
	
	@FXML
	private void handleEditLevelTables(ActionEvent event) {
		LevelTableRow[] levelTable = tableClasses.getSelectionModel().getSelectedItem().getLeveltableRow().toArray(new LevelTableRow[20]);
		if(levelTable!=null) {
			boolean okayClicked = showEditLevelTableDialog(levelTable);
		}
		else {
			Dialogs.create().title("Woah how'd this happen")
			.masthead("There's no levelTable on this Class")
			.message("Someone Screwed up here big time").showWarning();
		}
	}
	
	@FXML
	private void handleEditSpellLevelTable(ActionEvent event) {
		SpellLevelTableRow[] spellLevelTable = tableClasses.getSelectionModel().getSelectedItem().getLeveltableRow().toArray(new SpellLevelTableRow[20]);
		if(levelTable!=null) {
			boolean okayClicked = showEditSpellLevelTableDialog(spellLevelTable);
		}
		else {
			Dialogs.create().title("Woah how'd this happen")
			.masthead("There's no SpellLevelTable on this Class")
			.message("Someone Screwed up here big time").showWarning();
		}
	}

	@FXML
	private void handleEditSpellsKnowen(ActionEvent event) {
		SpellLevelTableRow[] spellLevelTable = tableClasses.getSelectionModel().getSelectedItem().getLeveltableRow().toArray(new SpellLevelTableRow[20]);
		if(levelTable!=null) {
			boolean okayClicked = showEditSpellKnownTableDialog(spellLevelTable);
		}
		else {
			Dialogs.create().title("Woah how'd this happen")
			.masthead("There's no SpellLevelTable on this Class")
			.message("Someone Screwed up here big time").showWarning();
		}
	}

	@FXML
	private void handleEditMonkTable(ActionEvent event) {
		
	}
	
	private boolean showEditSpellKnownTableDialog(SpellLevelTableRow[] spellLevelTable) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource(
					"dialogs/SpellKnowenTableEditDialog.fxml"));

			AnchorPane pane = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Class Spell Levels Per Day");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getInterface().getPrimaryStage());
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);

			SpellKnowenTableEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSpellLevelTable(spellLevelTable);
			dialogStage.showAndWait();
			spellLevelTable = controller.getSpellLevelTable();
			//refresh table
			return controller.isOkayClicked();
		} catch (Exception e) {
			Dialogs.create().title("Error").masthead("Somthing Went Wrong")
			.message(e.getMessage()).showWarning();
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean showEditSpellLevelTableDialog(SpellLevelTableRow[] spellLevelTable) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource(
					"dialogs/SpellLevelTableEditDialog.fxml"));

			AnchorPane pane = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Class Spell Levels Per Day");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getInterface().getPrimaryStage());
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);

			SpellLevelTableEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setSpellLevelTable(spellLevelTable);
			dialogStage.showAndWait();
			spellLevelTable = controller.getSpellLevelTable();
			//refresh table
			return controller.isOkayClicked();
		} catch (Exception e) {
			Dialogs.create().title("Error").masthead("Somthing Went Wrong")
			.message(e.getMessage()).showWarning();
			e.printStackTrace();
			return false;
		}
	}

	private boolean showEditLevelTableDialog(LevelTableRow[] levelTable) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource(
					"dialogs/LevelTableEditDialog.fxml"));

			AnchorPane pane = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Class Level Table");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getInterface().getPrimaryStage());
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);

			LevelTableEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setLevelTable(levelTable);
			dialogStage.showAndWait();
			levelTable = controller.getLevelTable();
			//refresh table
			return controller.isOkayClicked();
		} catch (Exception e) {
			Dialogs.create().title("Error").masthead("Somthing Went Wrong")
			.message(e.getMessage()).showWarning();
			e.printStackTrace();
			return false;
		}
	}

	private boolean showEditFeatureDialog(Feature selectedFeature) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource(
					"dialogs/ClassFeatureEditDialog.fxml"));

			AnchorPane pane = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Class Feature");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getInterface().getPrimaryStage());
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);

			ClassFeatureEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setFeature(selectedFeature);
			dialogStage.showAndWait();
			selectedFeature = controller.getFeature();
			//showClassDetails(selectedClass);
			return controller.isOkayClicked();
		} catch (IOException e) {
			Dialogs.create().title("Error").masthead("Somthing Went Wrong")
			.message(e.getMessage()).showWarning();
			e.printStackTrace();
			return false;
		}
	}

	private boolean showEditDetailDialog(Class selectedClass) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource(
					"dialogs/ClassDescriptionsEditDialog.fxml"));

			AnchorPane pane = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Class Details");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getInterface().getPrimaryStage());
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);

			ClassDescriptionsEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setpClass(selectedClass);
			dialogStage.showAndWait();
			selectedClass = controller.getpClass();
			showClassDetails(selectedClass);
			return controller.isOkayClicked();
		} catch (IOException e) {
			Dialogs.create().title("Error").masthead("Somthing Went Wrong")
			.message(e.getMessage()).showWarning();
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Populate Class Details labels with data from the selected Class
	 * 
	 * @param c
	 *            : selected Class
	 */
	private void showClassDetails(Class c) {
		if (c != null) {
			tableLevelTable.setDisable(false);
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
			tableFeatures.setItems(c.getFeatures());
		} else {
			tableLevelTable.setDisable(true);

			lblDescription.setText("");
			lblRole.setText("");
			lblAlignments.setText("");
			lblHitDice.setText("");
			lblClassSkills.setText("");
			lblSkillRanksPerLevel.setText("");
			lblWeaponProf.setText("");
			lblArmorProf.setText("");
			lblStartingWealthD6.setText("");

			tableFeatures.setItems(null);
		}
		showClassProgression(c);
	}

	private void showClassProgression(Class c) {
		if (c != null) {
			tabLevelTable.setDisable(false);
			tableLevelTable.setItems(c.getLeveltableRow());
			if (SpellLevelTableRow.class
					.isInstance(c.getLeveltableRow().get(0))) {
				tabSpellLevelTable.setDisable(false);

				ArrayList<SpellLevelTableRow> spellcaster = new ArrayList<SpellLevelTableRow>();
				for (LevelTableRow levelTableRow : c.getLeveltableRow()) {
					spellcaster.add((SpellLevelTableRow) levelTableRow);
				}

				tableSpellLevelTable.setItems(FXCollections
						.observableArrayList(spellcaster));
				if (((SpellLevelTableRow) c.getLeveltableRow().get(0))
						.getSpellsKnown()[0] != null) {
					tabSpellsKnown.setDisable(false);
					tableSpellsKnown.setItems(FXCollections
							.observableArrayList(spellcaster));
				}
			} else {
				tabSpellLevelTable.setDisable(true);
				tabSpellsKnown.setDisable(true);
				tableSpellLevelTable.setItems(null);
				tableSpellsKnown.setItems(null);
			}
			if (c.getName().equals("Monk")) {
				tabMonkSpecials.setDisable(false);
				ArrayList<MonkLevelTableRow> monk = new ArrayList<>();
				for (LevelTableRow levelTableRow : c.getLeveltableRow()) {
					monk.add((MonkLevelTableRow) levelTableRow);
				}
				tableMonkTable
						.setItems(FXCollections.observableArrayList(monk));
			} else {
				tabMonkSpecials.setDisable(true);
				tableMonkTable.setItems(null);
			}
		} else {
			tabSpellLevelTable.setDisable(true);
			tabSpellsKnown.setDisable(true);
			tabLevelTable.setDisable(true);
			tabMonkSpecials.setDisable(true);
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

				switch (lines[0]) {

				case "Barbarian":
					classes.put(
							lines[0],
							new Barbarian(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d12, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									readFeatures(lines[0]),
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() }));
					break;

				case "Bard":
					classes.put(
							lines[0],
							new Bard(lines[0], lines[1], lines[2], 0,
									Alignments.Any, DiceType.d8, Integer
											.parseInt(lines[8]), Integer
											.parseInt(lines[6]), lines[5]
											.split(","),
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
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
									readFeatures(lines[0]),
									new String[] { lines[7] },
									new String[] { lines[7] },
									new LevelTableRow[] { new LevelTableRow() }));
					break;

				default:
					break;
				}
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(ClassesController.class.toString()).log(
					Level.SEVERE, null, e);
		}
	}

	private ArrayList<Feature> readFeatures(String className) {
		Scanner reader;
		ArrayList<Feature> features = new ArrayList<>();
		try {
			reader = new Scanner(new FileReader("data/class_features/features_"
					+ className.toLowerCase() + ".tsv"));
			String readLine = reader.nextLine();

			while (reader.hasNextLine()) {
				readLine = reader.nextLine();

				String[] lines = readLine.split("\t");

				features.add(new Feature(lines[0], lines[1], lines[2]));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			Logger.getLogger(ClassesController.class.toString()).log(
					Level.WARNING, e.getMessage(), e);
		}
		return features;
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
				// lines[0] Level; [1] BAB; [2] Fort; [3] Ref; [4] Will; [5]
				// Special
				String[] lines = readLine.split("\t");

				int levelNum = Integer.parseInt(lines[0]);

				// Split lines[1] (BAB) on '/' to handle BAB data for higher
				// levels
				// set all the babs to the values in the string one, remove the
				// pluses
				int[] babs = Tools.StringToIntArray(lines[1].split("/"),
						new String[] { "+" }, new String[] { "" });
				// Make a new tableRow(levelNum, BaseAttackBonus, FortitudeSave,
				// ReflexSave, WillSave, String[])
				int fort = Integer.parseInt(lines[2].replace("+", "").trim()), ref = Integer
						.parseInt(lines[3].replace("+", "").trim()), will = Integer
						.parseInt(lines[4].replace("+", "").trim());
				// lines[0]-[5] is common data. [6]+ is Spell Level Table data.
				// If lines has more than 6 parts, send filename and lines to
				// the method to handle Spell Level Data
				LevelTableRow tableRow = null;
				if (lines.length > 6) {
					if (filename != "Monk") {
						tableRow = new SpellLevelTableRow(levelNum, babs,
								new SaveAttribute("Fortitude",
										AbilityName.Constitution, fort),
								new SaveAttribute("Reflex",
										AbilityName.Dexterity, ref),
								new SaveAttribute("Will", AbilityName.Wisdom,
										will), lines[5].split(","),
								new StringProperty[10], new StringProperty[10]);
						tableRow = readSpellLevelTable(filename, lines,
								(SpellLevelTableRow) tableRow);
					} else {
						String[] fobParts = lines[6].split("/");
						tableRow = new MonkLevelTableRow(levelNum, babs,
								new SaveAttribute("Fortitude",
										AbilityName.Constitution, fort),
								new SaveAttribute("Reflex",
										AbilityName.Dexterity, ref),
								new SaveAttribute("Will", AbilityName.Wisdom,
										will), lines[5].split(","),
								Tools.StringToIntArray(fobParts,
										new String[] { "+" },
										new String[] { "" }), lines[7],
								lines[8].trim(), lines[9].trim());
					}
				} else
					tableRow = new LevelTableRow(levelNum, babs,
							new SaveAttribute("Fortitude",
									AbilityName.Constitution, fort),
							new SaveAttribute("Reflex", AbilityName.Dexterity,
									ref), new SaveAttribute("Will",
									AbilityName.Wisdom, will),
							lines[5].split(","));
				levelTable[count] = tableRow;
				count++;

			} // End while next line

			classes.get(filename).setLevelTable(
					FXCollections.observableArrayList(levelTable));
			reader.close();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(ClassesController.class.toString()).log(
					Level.SEVERE, null, e);
		}
	} // End readCommonLevelTable

	private LevelTableRow readSpellLevelTable(String filename, String[] lines,
			SpellLevelTableRow tableRow) {
		StringProperty[] spd = new StringProperty[10];
		StringProperty[] spk = new StringProperty[10];
		// Spells per day Levels 0-9
		if (filename == "Cleric" || filename == "Druid" || filename == "Wizard"
				|| filename == "Witch") {
			for (int i = 6; i < lines.length; i++) {
				spd[i - 6] = new SimpleStringProperty(lines[i]);
			}
			tableRow.setSPD(spd);
		}

		// Spells per day Levels 1-9, Spells Known 0-9
		else if (filename == "Sorcerer" || filename == "Oracle") {
			spd[0] = new SimpleStringProperty("-");
			for (int i = 6; i < lines.length - 10; i++) {
				spd[i - 5] = new SimpleStringProperty(lines[i]);
			}
			tableRow.setSPD(spd);

			for (int i = 15; i < lines.length; i++) {
				spk[i - 15] = new SimpleStringProperty(lines[i]);
			}
			tableRow.setSpellsKnown(spk);
		}

		// Spells per day Levels 1-6, Spells Known 0-6
		else if (filename == "Bard" || filename == "Inquisitor"
				|| filename == "Summoner") {
			spd[0] = new SimpleStringProperty("-");
			for (int i = 6; i < lines.length - 7; i++)
				spd[i - 5] = new SimpleStringProperty(lines[i]);
			for(int i=7;i<10;i++)
				spd[i] = new SimpleStringProperty("-");
			tableRow.setSPD(spd);

			for (int i = 12; i < lines.length; i++)
				spk[i - 12] = new SimpleStringProperty(lines[i]);
			for (int i=7;i<10;i++)
				spk[i] = new SimpleStringProperty("-");
			tableRow.setSpellsKnown(spk);
		}

		// Spells per day Levels 1-4
		else if (filename == "Paladin" || filename == "Ranger") {
			spd[0] = new SimpleStringProperty("-");
			for (int i = 6; i < lines.length; i++) {
				spd[i - 5] = new SimpleStringProperty(lines[i]);
			}
			for (int i=5;i<10;i++) 
				spd[i] = new SimpleStringProperty("-");
			tableRow.setSPD(spd);
		}

		// Spells per day Levels 0-6
		else if (filename == "Magus") {
			for (int i = 6; i < lines.length; i++) {
				spd[i - 6] = new SimpleStringProperty(lines[i]);
			}
			for (int i = 7; i < 10; i++)
				spd[i] = new SimpleStringProperty("-");
			
			tableRow.setSPD(spd);
		}

		// Spells per day Levels 1-6: "alchemist" - the only one left
		else {
			for (int i = 6; i < lines.length; i++) {
				spd[i - 6] = new SimpleStringProperty(lines[i]);
			}
			for (int i = 7; i<10;i++)
				spd[i] = new SimpleStringProperty("-");
			tableRow.setSPD(spd);
		}
		return tableRow;

	} // End readSpellLevelTable

	/**
	 * loads data
	 */
	@Override
	public void loadData(File file) {
		// load data through jefxif
		readSummary();

		// Melee classes. Generic Level Table information is fine.

		readCommonLevelTable("Barbarian");
		readCommonLevelTable("Cavalier");
		readCommonLevelTable("Fighter");
		readCommonLevelTable("Gunslinger");
		readCommonLevelTable("Ninja");
		readCommonLevelTable("Rogue");
		readCommonLevelTable("Samurai");

		// Caster classes. Use Generic Level Table, add on Spell Level Table
		// information.
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
		readCommonLevelTable("Monk");

		obsListClasses.setAll(classes.values());
	}

	@Override
	public void saveDataToFile(File filePath) throws IOException {
		DirectoryChooser directoryChooser = new DirectoryChooser();

		directoryChooser.setTitle("Data Directory");
		File defaultDirectory = new File(this.getClass().getResource("")
				.getPath()
				+ pathfinderDataLoc);
		if (defaultDirectory.exists())
			directoryChooser.setInitialDirectory(defaultDirectory);
		else {
			defaultDirectory.mkdirs();
			directoryChooser.setInitialDirectory(defaultDirectory);
		}
		// Show the directory chooser
		File file = directoryChooser.showDialog(this.getInterface()
				.getPrimaryStage());

		if (file != null) {
			Data.Write(file.getPath() + "\\Classes.cldf",
					obsListClasses.toArray());
		}
	}

	@Override
	public void loadDataFromFile(File file) throws IOException {
		file = new File(this.getClass().getResource("").getPath()
				+ pathfinderDataLoc);
		File classFile = new File(file.getPath() + "\\Classes.cldf");
		if (!classFile.exists()) {
			readSummary();
		} else {
			try {
				obsListClasses.setAll(readDataFile(classFile, Class.class));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

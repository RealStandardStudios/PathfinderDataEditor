package view.partials;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.controlsfx.dialog.Dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jefXif.DataLoader;
import jefXif.MainPartialController;
import jefXif.io.Data;
import pathfinder.data.Attributes.AbilityName;
import pathfinder.data.Effects.AbilityEffect;
import pathfinder.data.Effects.ArmorClassEffect;
import pathfinder.data.Effects.AttackBonusEffect;
import pathfinder.data.Effects.CombatManeuverBonusEffect;
import pathfinder.data.Effects.CombatManeuverDefenseEffect;
import pathfinder.data.Effects.DamageEffect;
import pathfinder.data.Effects.ResistanceBonusEffect;
import pathfinder.data.Effects.SavingThrowEffect;
import pathfinder.data.Effects.SkillEffect;
import pathfinder.data.Effects.NonValued.MiscEffect;
import pathfinder.data.Effects.NonValued.OnLevelEffect;
import pathfinder.data.Feats.Feat;
import pathfinder.data.Races.Race;
import pathfinder.data.Races.Objects.Size;
import pathfinder.data.Races.Objects.VisionType;
import pathfinder.data.Races.Traits.MiscTrait;
import pathfinder.data.Races.Traits.SpellTrait;
import pathfinder.data.Races.Traits.Trait;
import view.partials.dialogs.RaceDescriptionsEditDialogController;
import view.partials.dialogs.RaceTraitsEditDialogController;

public class RacesController extends MainPartialController implements DataLoader {
	@FXML
	TableView<Race> tableRaces;

	@FXML
	TableColumn<Race, String> tableNameColumn;

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
	Label labelRacialModifiers;

	@FXML
	Label labelSize;
	@FXML
	Label labelSpeed;
	@FXML
	Label labelVision;
	@FXML
	Label labelTraits;
	@FXML
	Label labelWeapons;
	@FXML
	Label labelLanguages;

	@FXML
	Button btnEditSheet;

	@FXML
	Button btnEditTraits;

	ObservableList<Race> races = FXCollections.observableArrayList();
	HashMap<String, Race> raceList;
	HashMap<String, AbilityName> AbilityNames;
	HashMap<String, Size> Sizes;

	@Override
	public void initialize() {
		tableRaces.setItems(races);

		showRaceDetails(null);

		tableNameColumn.setCellValueFactory(celldata -> celldata.getValue()
				.getNameProperty());
		tableRaces
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> showRaceDetails(newValue));
	}

	private void showRaceDetails(Race r) {
		if (r != null) {
			lblName.setText(r.getName());
			txtaDescription.setText(r.getDescription());
			txtaPDescription.setText(r.getPhysicalDescription());
			txtaSociety.setText(r.getSociety());
			txtaRelations.setText(r.getRelations());
			txtaReligion.setText(r.getAlignmentAndReligion());
			txtaAdventures.setText(r.getAdventures());
			labelRacialModifiers.setText(r.getRacialModifierString());
			labelSize.setText(r.getSize().name());
			labelSpeed.setText(Integer.toString(r.getSpeed()));
			labelVision.setText(r.getVisionString());
			labelTraits.setText(r.getTraitsString());
			labelWeapons.setText(r.getWeaponsString());
			labelLanguages.setText(r.getLanguagesString());
		}
	}

	@FXML
	public void handleEditSheet(ActionEvent event) {
		Race selectedRace = tableRaces.getSelectionModel().getSelectedItem();
		if(selectedRace!=null) {
			boolean okClicked = showEditRaceDescriptions(selectedRace);
		} else {
			Dialogs.create().title("No Selection").masthead("No race Selected")
			.message("Select a race from the table.").showWarning();
		}
	}

	private boolean showEditRaceDescriptions(Race race) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("dialogs/RaceDescriptionsEditDialog.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Race Descriptions");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getInterface().getPrimaryStage());
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);
			
			RaceDescriptionsEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setRace(race);
			dialogStage.showAndWait();
			race = controller.getRace();
			showRaceDetails(race);
			return controller.isOkayClicked();
		}catch (IOException e) {
			Dialogs.create().title("Error").masthead("Somthing Went Wrong")
			.message(e.getMessage()).showWarning();
			e.printStackTrace();
			return false;
		}
	}

	@FXML
	public void handleEditTraits(ActionEvent event) {
		Race selectedRace = tableRaces.getSelectionModel().getSelectedItem();
		if(selectedRace!=null) {
			boolean okClicked = showEditRaceTraits(selectedRace);
		} else {
			Dialogs.create().title("No Selection").masthead("No race Selected")
			.message("Select a race from the table.").showWarning();
		}
	}

	private boolean showEditRaceTraits(Race race) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("dialogs/RaceTraitsEditDialog.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Race Traits");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getInterface().getPrimaryStage());
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);
			
			RaceTraitsEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setRace(race);
			dialogStage.showAndWait();
			race = controller.getRace();
			showRaceDetails(race);
			return controller.isOkayClicked();
		}catch (IOException e) {
			Dialogs.create().title("Error").masthead("Somthing Went Wrong")
			.message(e.getMessage()).showWarning();
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("serial")
	@Override
	public void loadData(File file) {
		AbilityNames = new HashMap<String, AbilityName>() {
			{
				put(AbilityName.Charisma.name(), AbilityName.Charisma);
				put(AbilityName.Constitution.name(), AbilityName.Constitution);
				put(AbilityName.Dexterity.name(), AbilityName.Dexterity);
				put(AbilityName.Intelligence.name(), AbilityName.Intelligence);
				put(AbilityName.Strength.name(), AbilityName.Strength);
				put(AbilityName.Wisdom.name(), AbilityName.Wisdom);
			}
		};

		Sizes = new HashMap<String, Size>() {
			{
				put(Size.Colossal.name(), Size.Colossal);
				put(Size.Diminutive.name(), Size.Diminutive);
				put(Size.Fine.name(), Size.Fine);
				put(Size.Gargantuan.name(), Size.Gargantuan);
				put(Size.Huge.name(), Size.Huge);
				put(Size.Large.name(), Size.Large);
				put(Size.Medium.name(), Size.Medium);
				put(Size.Small.name(), Size.Small);
				put(Size.Tiny.name(), Size.Tiny);
			}
		};
		raceList = new HashMap<>();
		try {
			loadDataFromFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadRaceTraits() {
		try {
			Scanner kb = new Scanner(new FileReader("data/RaceTraits.tsv"));
			String line = kb.nextLine();

			while (kb.hasNextLine()) {
				line = kb.nextLine();
				String[] parts = line.split("\t");
				Race r = raceList.get(parts[0]);
				{
					String effectName = "Racial Ability Modifier";
					String[] traits = parts[1].split(",");
					switch (traits.length) {
					case 1:
						r.setRacialModifiers(new AbilityEffect[] { new AbilityEffect(
								new Integer(traits[0].trim().substring(0, 2)),
								effectName, null) });
						break;
					case 2:
						r.setRacialModifiers(new AbilityEffect[] {
								new AbilityEffect(new Integer(traits[0].trim()
										.substring(0, 2)), effectName, AbilityNames
										.get(traits[0].substring(3).trim())),
								new AbilityEffect(new Integer(traits[1].trim()
										.substring(0, 2)), effectName, AbilityNames
										.get(traits[1].substring(3).trim())) });
						break;
					case 3:
						r.setRacialModifiers(new AbilityEffect[] {
								new AbilityEffect(new Integer(traits[0].trim()
										.substring(0, 2)), effectName, AbilityNames
										.get(traits[0].substring(3).trim())),
								new AbilityEffect(new Integer(traits[1].trim()
										.substring(0, 2)), effectName, AbilityNames
										.get(traits[1].substring(3).trim())),
								new AbilityEffect(new Integer(traits[2].trim()
										.substring(0, 2)), effectName, AbilityNames
										.get(traits[2].substring(3).trim())) });
						break;
					case 4:
						r.setRacialModifiers(new AbilityEffect[] {
								new AbilityEffect(new Integer(traits[0].trim()
										.substring(0, 2)), effectName, AbilityNames
										.get(traits[0].substring(3).trim())),
								new AbilityEffect(new Integer(traits[1].trim()
										.substring(0, 2)), effectName, AbilityNames
										.get(traits[1].substring(3).trim())),
								new AbilityEffect(new Integer(traits[2].trim()
										.substring(0, 2)), effectName, AbilityNames
										.get(traits[2].substring(3).trim())),
								new AbilityEffect(new Integer(traits[3].trim()
										.substring(0, 2)), effectName, AbilityNames
										.get(traits[3].substring(3).trim())) });
					default:
						break;
					}
					String[] sizeparts = parts[3].split(":");

					r.setSize(Sizes.get(sizeparts[0]));

					r.setSpeed(Integer.parseInt(parts[5]));

					if (parts[6].equals("0"))
						r.setSpeedLoss(false);
					else
						r.setSpeedLoss(true);
					String[] visionParts = parts[7].split(",");
					// new VisionType(distance, name)
					ArrayList<VisionType> visionTypes = new ArrayList<>();
					visionTypes.add(new VisionType(60, "Normal"));
					for (String s : visionParts) {
						if (s.equals("-"))
							visionTypes.add(new VisionType(30, "Low-Light Vision"));
						if (s.contains("Superior Darkvision"))
							visionTypes.add(new VisionType(120, "Darkvision"));
						else if (s.contains("Darkvision")) {
							visionTypes.add(new VisionType(30, "Low-Light Vision"));
							visionTypes.add(new VisionType(60, "Darkvision"));
						}
						if (s.contains("Low-Light Vision"))
							visionTypes.add(new VisionType(60, "Low-Light Vision"));
					}					
					r.setVisionTypes(visionTypes.toArray(new VisionType[]{}));
					ArrayList<Trait> racialTraits = new ArrayList<>();
					for(int i=8;i<17;i++) {
						if(!parts[i].equals("-")) {
							String[] traitParts = parts[i].split(";");
							if(traitParts[0].equals("Misc")) {
								switch (traitParts[2]) {
								case "Misc":
									racialTraits.add(new MiscTrait(traitParts[1], new MiscEffect(traitParts[1]+ " Effect", traitParts[3])));
									break;
								case "ArmorClass":
									racialTraits.add(new MiscTrait(traitParts[1], new ArmorClassEffect(Integer.parseInt(traitParts[3]),traitParts[1]+" Effect",traitParts[4])));
									break;
								case "SavingThrow":
									racialTraits.add(new MiscTrait(traitParts[1], new SavingThrowEffect(Integer.parseInt(traitParts[3]), traitParts[1]+" Effect", traitParts[4], traitParts[5])));
									break;
								case "Skill":
									racialTraits.add(new MiscTrait(traitParts[1], new SkillEffect(Integer.parseInt(traitParts[3]), traitParts[1]+" Effect", traitParts[5], traitParts[4])));
									break;
								case "Damage":
									racialTraits.add(new MiscTrait(traitParts[1], new DamageEffect(Integer.parseInt(traitParts[3]), traitParts[1]+ " Effect")));
									break;
								case "AttackBonus":
									racialTraits.add(new MiscTrait(traitParts[1], new AttackBonusEffect(traitParts[3], traitParts[4], Integer.parseInt(traitParts[5]), traitParts[1]+" Effect")));
									break;
								case "CombatManeuverDefense":
									racialTraits.add(new MiscTrait(traitParts[1], new CombatManeuverDefenseEffect(traitParts[4],traitParts[5], Integer.parseInt(traitParts[3]), traitParts[1]+" Effect")));
									break;
								case "OnLevel":
									racialTraits.add(new MiscTrait(traitParts[1], new OnLevelEffect(Integer.parseInt(traitParts[3]), traitParts[1]+" Effect", traitParts[4])));
									break;
								case "ResistanceBonus":
									racialTraits.add(new MiscTrait(traitParts[1], new ResistanceBonusEffect(Integer.parseInt(traitParts[3]), traitParts[1]+" Effect", traitParts[4])));
									break;
								case "CombatManeuverBonus":
									racialTraits.add(new MiscTrait(traitParts[1], new CombatManeuverBonusEffect(Integer.parseInt(traitParts[3]), traitParts[1]+" Effect")));
									break;
								default:
									System.out.println(parts[0]+", "+traitParts[2]);
									break;
								}
							}
							else {
								racialTraits.add(new SpellTrait(traitParts[1], new MiscEffect(traitParts[1]+" Effect", traitParts[4]), traitParts[2], Integer.parseInt(traitParts[3])));
							}
						}
					}
					r.setRacialTraits(racialTraits);
					r.setWeaponFamiliarity(new String[] {""});
					r.setLanguages(new String[] {""});
				}
			}
			kb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void loadRaceSheet() {
		try {
			Scanner kb = new Scanner(new FileReader("data/Races.tsv"));
			String line = kb.nextLine();

			while (kb.hasNextLine()) {
				line = kb.nextLine();
				String[] parts = line.split("\t");
				Race r = new Race();
				{
					r.setName(parts[0]);
					r.setDescription(parts[1]);
					r.setPhysicalDescription(parts[2]);
					r.setSociety(parts[3]);
					r.setRelations(parts[4]);
					r.setAlignmentAndReligion(parts[5]);
					r.setAdventures(parts[6]);
				}
				raceList.put(parts[0], r);
			}
			kb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

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
            Data.Write(file.getPath()+"\\Races.rdf", races.toArray());
        }
	}

	@Override
	public void loadDataFromFile(File file) throws IOException {
		file = new File(this.getClass().getResource("").getPath()+pathfinderDataLoc);
		File raceFile = new File(file.getPath()+"\\Feats.fdf");
		if(!raceFile.exists()) {			
			loadRaceSheet();
			loadRaceTraits();
			races.setAll(raceList.values());
		}
		else {
			races.setAll(readDataFile(raceFile, Race.class));
		}
	}

}

package view.partials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import jefXif.DataLoader;
import jefXif.WindowController;
import pathfinder.data.Attributes.AbilityName;
import pathfinder.data.Effects.AbilityEffect;
import pathfinder.data.Items.Weapon;
import pathfinder.data.Races.Race;
import pathfinder.data.Races.Objects.Language;
import pathfinder.data.Races.Objects.Size;
import pathfinder.data.Races.Objects.VisionType;
import pathfinder.data.Races.Traits.Trait;

public class RacesController extends WindowController implements DataLoader {
	@FXML
	TableView<Race> tableRaces;
	
	@FXML
	TableColumn<Race,String> tableNameColumn;
	
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
	HashMap<String, Race> raceList;
	HashMap<String, AbilityName> AbilityNames;
	HashMap<String, Size> Sizes;

	@Override
	public void initialize() {
		tableRaces.setItems(races);
		
		showRaceDetails(null);
		
		tableNameColumn.setCellValueFactory(celldata->celldata.getValue().getNameProperty());
	}

	private void showRaceDetails(Race r) {
				
	}

	@FXML
	public void handleEditSheet(ActionEvent event) {

	}

	@FXML
	public void handleEditTraits(ActionEvent event) {

	}

	@Override
	public void loadData() {
		AbilityNames = new HashMap<String, AbilityName>(){{
			put(AbilityName.Charisma.name(),AbilityName.Charisma);
			put(AbilityName.Constitution.name(), AbilityName.Constitution);
			put(AbilityName.Dexterity.name(),AbilityName.Dexterity);
			put(AbilityName.Intelligence.name(), AbilityName.Intelligence);
			put(AbilityName.Strength.name(), AbilityName.Strength);
			put(AbilityName.Wisdom.name(), AbilityName.Wisdom);
		}};
		
		Sizes = new HashMap<String, Size>(){{
			put(Size.Colossal.name(), Size.Colossal);
			put(Size.Diminutive.name(), Size.Diminutive);
			put(Size.Fine.name(), Size.Fine);
			put(Size.Gargantuan.name(), Size.Gargantuan);
			put(Size.Huge.name(), Size.Huge);
			put(Size.Large.name(), Size.Large);
			put(Size.Medium.name(), Size.Medium);
			put(Size.Small.name(), Size.Small);
			put(Size.Tiny.name(), Size.Tiny);
		}};
		raceList = new HashMap<>();
		loadRaceSheet();
		loadRaceTraits();
		races.setAll(raceList.values());
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
					String name = "Racial Ability Modifier";
					String[] traits = parts[1].split(",");
					switch (traits.length) {
					case 1:
						r.setRacialModifiers(new AbilityEffect[] { 
							new AbilityEffect(new Integer(traits[0].trim().substring(0, 2)), name, null) 
						});
						break;
					case 2:
						r.setRacialModifiers(new AbilityEffect[] { 
							new AbilityEffect(new Integer(traits[0].trim().substring(0, 2)), name, AbilityNames.get(traits[0].substring(3).trim())),
							new AbilityEffect(new Integer(traits[1].trim().substring(0, 2)),name, AbilityNames.get(traits[1].substring(3).trim()))
						});
						break;
					case 3:
						r.setRacialModifiers(new AbilityEffect[] { 
							new AbilityEffect(new Integer(traits[0].trim().substring(0, 2)), name, AbilityNames.get(traits[0].substring(3).trim())),
							new AbilityEffect(new Integer(traits[1].trim().substring(0, 2)),name, AbilityNames.get(traits[1].substring(3).trim())),
							new AbilityEffect(new Integer(traits[2].trim().substring(0, 2)),name, AbilityNames.get(traits[2].substring(3).trim()))
						});
						break;
					case 4:
						r.setRacialModifiers(new AbilityEffect[] { 
							new AbilityEffect(new Integer(traits[0].trim().substring(0, 2)), name, AbilityNames.get(traits[0].substring(3).trim())),
							new AbilityEffect(new Integer(traits[1].trim().substring(0, 2)),name, AbilityNames.get(traits[1].substring(3).trim())),
							new AbilityEffect(new Integer(traits[2].trim().substring(0, 2)),name, AbilityNames.get(traits[2].substring(3).trim())),
							new AbilityEffect(new Integer(traits[3].trim().substring(0, 2)),name, AbilityNames.get(traits[3].substring(3).trim()))
						});
					default:
						break;
					}
					
					r.setSize(Sizes.get(parts[3]));
					
					r.setSpeed(Integer.parseInt(parts[5]));
					
					if(parts[6].equals("0"))
						r.setSpeedLoss(false);
					else
						r.setSpeedLoss(true);
					// new VisionType(distance, name)
					r.setVisionTypes(new VisionType[]{});
					
					r.setRacialTraits(new ArrayList<Trait>(){{
						
					}});
					
					r.setWeaponFamiliarity(new Weapon[]{});
					r.setLanguages(new Language[]{});
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

}

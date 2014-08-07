package view.partials;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jefXif.WindowController;
import pathfinder.data.Spells.Spell;

/**
 * @author Kenneth Cooper
 *@description A controller class for Spells that interacts with 
 */
public class SpellsController extends WindowController {

	private ObservableList<Spell> spellData = FXCollections
			.observableArrayList();

	public SpellsController() {
		// Test data for now
		spellData
				.add(new Spell(
						"Ablative Barrier",
						"conjuration (creation) [force]",
						new String[] { "alchemist", "magus", "sorceror/wizard",
								"summoner" },
						new int[] { 2, 2, 3, 2 },
						"1 standard action",
						"V, S, M (a piece of metal cut from a shield)",
						"touch",
						"creature touched",
						null,
						null,
						"1 hour/level or until discharged",
						"Will negates (harmless)",
						"no",
						"Invisible layers of solid force surround and protect the target, granting that target a +2 armor bonus to AC. Additionally, the first 5 points of lethal damage the target takes from each attack are converted into nonlethal damage. Against attacks that already deal nonlethal damage, the target gains DR 5/—. Once this spell has converted 5 points of damage to nonlethal damage per caster level (maximum 50 points), the spell is discharged.",
						null));

	}

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
			switch (spell.getTablePicture().length) {
			case 1:
				tableOneImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePicture()[0]));
				tableTwoImageView.setImage(null);
				tableThreeImageView.setImage(null);
				break;
			case 2:
				tableOneImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePicture()[0]));
				tableTwoImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePicture()[1]));
				tableThreeImageView.setImage(null);
				break;
			case 3:
				tableOneImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePicture()[0]));
				tableTwoImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePicture()[1]));
				tableThreeImageView.setImage(new Image("file:resources/images/SpellTables/" + spell.getTablePicture()[2]));
				break;
			default:
				tableOneImageView.setImage(null);
				tableTwoImageView.setImage(null);
				tableThreeImageView.setImage(null);
				break;
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
}

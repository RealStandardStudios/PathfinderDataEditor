package view.partials.dialogs;

import java.util.HashMap;

import org.controlsfx.dialog.Dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.view.DialogController;
import pathfinder.data.Spells.Spell;

/**
 * Dialog to edit spell details
 * 
 * @author Real Standard Studios - Kenneth Cooper
 */
public class SpellEditDialogController extends DialogController{
	@FXML
	private TextField spellNameField;
	@FXML
	private TextField schoolNameField;
	@FXML
	private TextField spellLevelField;
	@FXML
	private TextField castingTimeField;
	@FXML
	private TextField componentsField;
	@FXML
	private TextField rangeField;
	@FXML
	private TextField targetEffectAreaField;
	@FXML
	private TextField durationField;
	@FXML
	private TextField savingThrowField;
	@FXML
	private TextField spellResistanceField;
	@FXML
	private TextField descriptionField;
	@FXML
	private TextField spellTableField;
	
	private Stage dialogStage;
	private Spell spell;
	
	/**
	 * Initialises the controller class.  This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initializes() {
		
	}
	
	/**
	 * Sets the spell to be edited in the dialog
	 * 
	 * @param spell
	 */
	public void setSpell(Spell spell) {
		this.spell = spell;
		
		spellNameField.setText(spell.getName());
		schoolNameField.setText(spell.getSchool());
		spellLevelField.setText(spell.getClassAndSpellLevel());
		castingTimeField.setText(spell.getCastingTime());
		componentsField.setText(spell.getComponents());
		rangeField.setText(spell.getRange());
		targetEffectAreaField.setText(spell.getTarget() + ", " + spell.getEffect() + ", " + spell.getArea());
		durationField.setText(spell.getDuration());
		savingThrowField.setText(spell.getSavingThrow());
		spellResistanceField.setText(spell.isSpellResistance());
		descriptionField.setText(spell.getDescription());
		spellTableField.setText(spell.getTablePicture());
	}
	
	/**
	 * a handle method that saves changes upon pressing the Ok button
	 */
	@FXML
	public void handleOkay(ActionEvent event) {
		if (isInputValid()) {
			spell.setName(spellNameField.getText());
			spell.setSchool(schoolNameField.getText());
			// fancy code for setting spell level
			String[] parts = spellLevelField.getText().split(",");			
			String[] classParts = null; // Holds the levelParts split up into the formula [string] [int]
			HashMap<String, Integer> spellLevels = new HashMap<>();

			for (String string : parts) {
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
			spell.setSpellLevel(spellLevels);
			spell.setCastingTime(castingTimeField.getText());
			spell.setComponents(componentsField.getText());
			spell.setRange(rangeField.getText());
			// fancy code for setting target, effect, area
			String[] parts2 = targetEffectAreaField.getText().trim().split(",");
			if(parts2.length >= 1)
			{
				spell.setTarget(parts2[0]);
			}
			else
			{
				spell.setTarget("-");
			}
			if(parts2.length >= 2)
			{
				spell.setEffect(parts2[1]);
			}
			else
			{
				spell.setEffect("-");
			}
			if(parts2.length >= 3)
			{
				spell.setArea(parts2[2]);
			}
			else
			{
				spell.setArea("-");
			}
			spell.setDuration(durationField.getText());
			spell.setSavingThrow(savingThrowField.getText());
			spell.setSpellResistance(spellResistanceField.getText());
			spell.setDescription(descriptionField.getText());
			spell.setTablePicture(spellTableField.getText());
			
			okayClicked = true;
			dialogStage.close();
		}
	}
	
	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";
		
		if (spellNameField.getText() == null || spellNameField.getText().length() == 0) {
            errorMessage += "No valid spell name!\n"; 
        }
		if (schoolNameField.getText() == null || schoolNameField.getText().length() == 0) {
            errorMessage += "No valid school name!\n"; 
        }
		if (spellLevelField.getText() == null || spellLevelField.getText().length() == 0) {
            errorMessage += "No valid spell levels!\n"; 
        }
		if (castingTimeField.getText() == null || castingTimeField.getText().length() == 0) {
            errorMessage += "No valid casting time!\n"; 
        }
		if (componentsField.getText() == null || componentsField.getText().length() == 0) {
            errorMessage += "No valid spell components!\n"; 
        }
		if (rangeField.getText() == null || rangeField.getText().length() == 0) {
            errorMessage += "No valid range!\n"; 
        }
		if (targetEffectAreaField.getText() == null || targetEffectAreaField.getText().length() == 0) {
            errorMessage += "No valid target, effect, or area!\n"; 
        }
		if (durationField.getText() == null || durationField.getText().length() == 0) {
            errorMessage += "No valid duration!\n"; 
        }
		if (savingThrowField.getText() == null || savingThrowField.getText().length() == 0) {
            errorMessage += "No valid saving throw!\n"; 
        }
		if (spellResistanceField.getText() == null || spellResistanceField.getText().length() == 0) {
            errorMessage += "No valid spell resistance!\n"; 
        }
		if (descriptionField.getText() == null || descriptionField.getText().length() == 0) {
            errorMessage += "No valid description!\n"; 
        }
		if (spellTableField.getText() == null ) { //|| spellTableField.getText().length() == 0, currently removed for save testing....
            errorMessage += "No valid table info!\n"; 
        }
		
		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message
			Dialogs.create()
				.title("Invalid Fields")
				.masthead("Please enter data.  If you want to leave the field empty, use a -")
				.message(errorMessage)
				.showError();
			return false;
		}
	}
}

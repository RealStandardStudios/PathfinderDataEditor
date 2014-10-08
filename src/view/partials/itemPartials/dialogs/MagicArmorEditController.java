package view.partials.itemPartials.dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.view.DialogController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.MagicArmor;

/**
 * the controller for the magic armour edit dialog
 * 
 * @author Real Standard Studios - Joshua Boyd
 */
public class MagicArmorEditController extends DialogController {

	@FXML
	private TextField armorNameField;
	@FXML
	private TextField costField;
	@FXML
	private TextField acBonusField;
	@FXML
	private TextField maxDexBonusField;
	@FXML
	private TextField armorCheckPenaltyField;
	@FXML
	private TextField arcaneSpellFailureField;
	@FXML
	private TextField speed30Field;
	@FXML
	private TextField speed20Field;
	@FXML
	private TextField weightField;
	@FXML
	private TextField slotField;
	@FXML
	private TextField auraStrengthField;
	@FXML
	private TextField casterLevelField;
	@FXML
	private TextField descriptionField;
	@FXML
	private TextField constructionField;
	
	
	private Stage dialogStage;
    private MagicArmor armor;
    
    /**
	 * the initialize method implemented from extension
	 */
    public void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    /**
     * populates the dialog
     * @param a
     */
    public void setArmor(MagicArmor a)
    {
    	armor = a;
    	
    	armorNameField.setText(a.Name.get());
    	costField.setText(a.Cost.get());
    	acBonusField.setText(a.ArmorBonus.get());
    	maxDexBonusField.setText(a.MaxDexBonus.get());
    	armorCheckPenaltyField.setText(a.ArmorCheckPenalty.get());
    	arcaneSpellFailureField.setText(a.ArcaneSpellFailure.get());
    	speed30Field.setText(a.Speed30feet.get());
    	speed20Field.setText(a.Speed20feet.get());
    	weightField.setText(a.Weight.get());
    	slotField.setText(a.getSlot());
    	auraStrengthField.setText(a.getAuraStrength());
    	casterLevelField.setText(a.getCasterLevel());
    	descriptionField.setText(a.getDescription());
    	constructionField.setText(a.getConstruction());
    	
    }    
    
    /**
     * checks for valid input
     * @returns true if correct
     */
    private boolean isInputValid() {
    	String errorMessage = "";

        if (armorNameField.getText() == null || armorNameField.getText().length() == 0) {
            errorMessage += "No valid magic weapon name is set!\n"; 
        }        
        if (costField.getText() == null || costField.getText().length() == 0) {
            errorMessage += "No valid price is set!\n"; 
        }
        if (acBonusField.getText() == null || acBonusField.getText().length() == 0) {
            errorMessage += "No valid AC is set!\n"; 
        }

        if (maxDexBonusField.getText() == null || maxDexBonusField.getText().length() == 0) {
            errorMessage += "No valid maximum dex bonus is set!\n"; 
        } 

        if (armorCheckPenaltyField.getText() == null || armorCheckPenaltyField.getText().length() == 0) {
            errorMessage += "No valid armor check penalty is set!\n"; 
        }
        
        if (arcaneSpellFailureField.getText() == null || arcaneSpellFailureField.getText().length() == 0) {
            errorMessage += "No valid arcane spell failure is set!\n";
        }

        if (speed30Field.getText() == null || speed30Field.getText().length() == 0) {
            errorMessage += "No valid speed 30 is set!\n";
        }
        
        if (speed20Field.getText() == null || speed20Field.getText().length() == 0) {
            errorMessage += "No valid speed 20 is set!\n";
        }
        
        if (weightField.getText() == null || weightField.getText().length() == 0) {
            errorMessage += "No valid weight is set!\n";
        }
        
        if (slotField.getText() == null || slotField.getText().length() == 0) {
            errorMessage += "No valid slot is set!\n";
        }
        
        if (auraStrengthField.getText() == null || auraStrengthField.getText().length() == 0) {
            errorMessage += "No valid aura strength is set!\n";
        }
        
        if (casterLevelField.getText() == null || casterLevelField.getText().length() == 0) {
            errorMessage += "No valid caster level is set!\n";
        }
        
        if (descriptionField.getText() == null || descriptionField.getText().length() == 0) {
            errorMessage += "No valid description is set!\n";
        }
        
        if (constructionField.getText() == null || constructionField.getText().length() == 0) {
            errorMessage += "No valid construction is set!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Dialogs.create()
                .title("Invalid Fields")
                .masthead("Please correct invalid fields")
                .message(errorMessage)
                .showError();
            return false;
        }
        
    }
    
    /**
     * saves data when Ok button pressed
     */
    @FXML
    public void handleOkay(ActionEvent event) {
        if (isInputValid()) {            
            armor.Name.set(armorNameField.getText());
            armor.Cost.set(costField.getText());
            armor.ArmorBonus.set(acBonusField.getText());
            armor.MaxDexBonus.set(maxDexBonusField.getText());
            armor.ArmorCheckPenalty.set(armorCheckPenaltyField.getText());
            armor.ArcaneSpellFailure.set(arcaneSpellFailureField.getText());
            armor.Speed30feet.set(speed30Field.getText());
            armor.Speed20feet.set(speed20Field.getText());
            armor.Weight.set(weightField.getText());
            armor.setSlot(slotField.getText());
            armor.setAuraStrength(auraStrengthField.getText());
            armor.setCasterLevel(casterLevelField.getText());
            armor.setDescription(descriptionField.getText());
            armor.setConstruction(constructionField.getText());

            okayClicked = true;
            dialogStage.close();
        }
    }


	
}

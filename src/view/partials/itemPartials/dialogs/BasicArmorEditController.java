package view.partials.itemPartials.dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.DialogController;

import org.controlsfx.dialog.Dialogs;
import pathfinder.data.Items.Armor;

public class BasicArmorEditController extends DialogController {

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
	
	
	private Stage dialogStage;
    private Armor armor;
    private boolean okClicked = false;
    
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
    
    public void setArmor(Armor a)
    {
    	armor = a;
    	
    	armorNameField.setText(a.getName());
    	costField.setText(a.getCost());
    	acBonusField.setText(a.getArmorBonus());
    	maxDexBonusField.setText(a.getMaxDexBonus());
    	armorCheckPenaltyField.setText(a.getArmorCheckPenalty());
    	arcaneSpellFailureField.setText(a.getArcaneSpellFailiure());
    	speed30Field.setText(a.getSpeed30feet());
    	speed20Field.setText(a.getSpeed20feet());
    	weightField.setText(a.getWeight());
    	
    }    
    
    public boolean isOkClicked() {
        return okClicked;
    }
    /**
     * Called when the user clicks ok.
     */
       
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    /**
     * Called when the user clicks cancel.
     */
    
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (armorNameField.getText() == null || armorNameField.getText().length() == 0) {
            errorMessage += "No valid item name is set!\n"; 
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
    
    @FXML
    private void handleOk() {
        if (isInputValid()) {            
            armor.setName(armorNameField.getText());
            armor.setCost(costField.getText());
            armor.setArmorBonus(acBonusField.getText());
            armor.setMaxDexBonus(maxDexBonusField.getText());
            armor.setArmorCheckPenalty(armorCheckPenaltyField.getText());
            armor.setArcaneSpellFailiure(arcaneSpellFailureField.getText());
            armor.setSpeed30feet(speed30Field.getText());
            armor.setSpeed20feet(speed20Field.getText());
            armor.setWeight(weightField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }
}

package view.partials.itemPartials.dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.DialogController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.Weapon;

public class BasicWeaponEditController extends DialogController{
	
	@FXML
	private TextField nameField;
	@FXML
	private TextField weaponTypeField;
	@FXML
	private TextField wieldStyleField;
	@FXML
	private TextField dmgSField;
	@FXML
	private TextField dmgMField;
	@FXML
	private TextField criticalField;
	@FXML
	private TextField rangeField;
	@FXML
	private TextField dmgTypeField;
	@FXML
	private TextField specialField;
	@FXML
	private TextField costField;
	@FXML
	private TextField weightField;
	
	private Stage dialogStage;
    private Weapon weapon;
    
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
    
    public void setWeapon(Weapon w)
    {
    	weapon = w;
    	
    	nameField.setText(w.Name.get());
    	weaponTypeField.setText(w.WeaponType.get());
    	wieldStyleField.setText(w.WieldStyle.get());
    	dmgSField.setText(w.DmgS.get());
    	dmgMField.setText(w.DmgM.get());
    	criticalField.setText(w.Critical.get());
    	rangeField.setText(w.Range.get());
    	dmgTypeField.setText(w.WeaponDmgType.get());
    	specialField.setText(w.Special.get());
    	costField.setText(w.Cost.get());
    	weightField.setText(w.Weight.get());
    	
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid weapon name is set!\n"; 
        }
        
        if (weaponTypeField.getText() == null || weaponTypeField.getText().length() == 0) {
            errorMessage += "No valid weapon type is set!\n"; 
        }
        
        if (wieldStyleField.getText() == null || wieldStyleField.getText().length() == 0) {
            errorMessage += "No valid wield style is set!\n"; 
        }
        
        if (criticalField.getText() == null || criticalField.getText().length() == 0) {
            errorMessage += "No valid weapon critical is set!\n"; 
        }
        
        if (dmgSField.getText() == null || dmgSField.getText().length() == 0) {
            errorMessage += "No valid small weapon damage is set!\n"; 
        }
        
        if (dmgMField.getText() == null || dmgMField.getText().length() == 0) {
            errorMessage += "No valid medium weapon damage is set!\n"; 
        }
        
        if (rangeField.getText() == null || rangeField.getText().length() == 0) {
            errorMessage += "No valid weapon range is set!\n"; 
        }
        
        if (dmgTypeField.getText() == null || dmgTypeField.getText().length() == 0) {
            errorMessage += "No valid damage type is set!\n"; 
        }
        
        if (specialField.getText() == null || specialField.getText().length() == 0) {
            errorMessage += "No valid special weapon conditions is set!\n"; 
        }
        
        if (costField.getText() == null || costField.getText().length() == 0) {
            errorMessage += "No valid price is set!\n"; 
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
    public void handleOkay(ActionEvent event) {
        if (isInputValid()) {            
            weapon.Name.set(nameField.getText());
            weapon.WeaponType.set(weaponTypeField.getText());
            weapon.WieldStyle.set(wieldStyleField.getText());
            weapon.Critical.set(criticalField.getText());
            weapon.DmgS.set(dmgSField.getText());
            weapon.DmgM.set(dmgMField.getText());
            weapon.Range.set(rangeField.getText());
            weapon.WeaponDmgType.set(dmgTypeField.getText());
            weapon.Special.set(specialField.getText());
            weapon.Weight.set(weightField.getText());
            weapon.Cost.set(costField.getText());
            weapon.Weight.set(weightField.getText());

            okayClicked = true;
            dialogStage.close();
        }
    }
}

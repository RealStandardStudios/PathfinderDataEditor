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
    	
    	nameField.setText(w.getName());
    	weaponTypeField.setText(w.getWeaponType());
    	wieldStyleField.setText(w.getWieldStyle());
    	dmgSField.setText(w.getDmgS());
    	dmgMField.setText(w.getDmgM());
    	criticalField.setText(w.getCritical());
    	rangeField.setText(w.getRange());
    	dmgTypeField.setText(w.getWeaponDmgType());
    	specialField.setText(w.getSpecial());
    	costField.setText(w.getCost());
    	weightField.setText(w.getWeight());
    	
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
            weapon.setName(nameField.getText());
            weapon.setWeaponType(weaponTypeField.getText());
            weapon.setWieldStyle(wieldStyleField.getText());
            weapon.setCritical(criticalField.getText());
            weapon.setDmgS(dmgSField.getText());
            weapon.setDmgM(dmgMField.getText());
            weapon.setRange(rangeField.getText());
            weapon.setWeaponDmgType(dmgTypeField.getText());
            weapon.setSpecial(specialField.getText());
            weapon.setWeight(weightField.getText());
            weapon.setCost(costField.getText());
            weapon.setWeight(weightField.getText());

            okayClicked = true;
            dialogStage.close();
        }
    }
}

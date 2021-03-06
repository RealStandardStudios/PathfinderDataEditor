package view.partials.itemPartials.dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.view.DialogController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.MagicRod;

/**
 * the controller for the magic rod edit dialog
 * 
 * @author Real Standard Studios - Joshua Boyd
 */
@SuppressWarnings("deprecation")
public class MagicRodEditController extends DialogController {

	@FXML
	private TextField rodNameField;
	@FXML
	private TextField casterLevelField;
	@FXML
	private TextField priceField;
	@FXML
	private TextField descriptionField;
	@FXML
	private TextField constructionField;
	@FXML
	private TextField auraStrengthField;
	@FXML
	private TextField weightField;
	
	
	private Stage dialogStage;
    private MagicRod rod;
    
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
    public void setMagicRod(MagicRod r) {
    	rod = r;
    	rodNameField.setText(r.Name.get());
    	casterLevelField.setText(r.getCasterLevel());
    	priceField.setText(r.Cost.get());
    	descriptionField.setText(r.getDescription());
    	constructionField.setText(r.getConstruction());
    	auraStrengthField.setText(r.getAuraStrength());
    	weightField.setText(r.Weight.get());
		
	}    
    
    /**
     * checks for valid input
     * @returns true if correct
     */
    private boolean isInputValid() {
    	String errorMessage = "";

        if (rodNameField.getText() == null || rodNameField.getText().length() == 0) {
            errorMessage += "No valid item name is set!\n"; 
        }        
        if (casterLevelField.getText() == null || casterLevelField.getText().length() == 0) {
            errorMessage += "No valid caster level is set!\n"; 
        }
        if (priceField.getText() == null || priceField.getText().length() == 0) {
            errorMessage += "No valid price is set!\n"; 
        }

        if (descriptionField.getText() == null || descriptionField.getText().length() == 0) {
            errorMessage += "No valid description is set!\n"; 
        } 

        if (constructionField.getText() == null || constructionField.getText().length() == 0) {
            errorMessage += "No valid construction is set!\n"; 
        }
        
        if (auraStrengthField.getText() == null || auraStrengthField.getText().length() == 0) {
            errorMessage += "No valid aura is set!\n"; 
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
    
    /**
     * saves data when Ok button pressed
     */
    @FXML
    public void handleOkay(ActionEvent event) {
    	if (isInputValid()) {            
            rod.Name.set(rodNameField.getText());
            rod.Cost.set(priceField.getText());
            rod.Weight.set(weightField.getText());
            rod.setAuraStrength(auraStrengthField.getText());
            rod.setConstruction(constructionField.getText());
            rod.setDescription(descriptionField.getText());
            rod.setCasterLevel(casterLevelField.getText());

            okayClicked = true;
            dialogStage.close();
        }
    }
}

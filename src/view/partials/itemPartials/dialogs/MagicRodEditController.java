package view.partials.itemPartials.dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.DialogController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.MagicRod;

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
    
    public void setMagicRod(MagicRod r) {
    	rod = r;
    	rodNameField.setText(r.getName());
    	casterLevelField.setText(r.getCasterLevel());
    	priceField.setText(r.getCost());
    	descriptionField.setText(r.getDescription());
    	constructionField.setText(r.getConstruction());
    	auraStrengthField.setText(r.getAuraStrength());
    	weightField.setText(r.getWeight());
		
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
    
    @FXML
    private void handleOk() {
    	if (isInputValid()) {            
            rod.setName(rodNameField.getText());
            rod.setAuraStrength(auraStrengthField.getText());
            rod.setConstruction(constructionField.getText());
            rod.setCost(priceField.getText());
            rod.setDescription(descriptionField.getText());
            rod.setCasterLevel(casterLevelField.getText());
            rod.setWeight(weightField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }
}

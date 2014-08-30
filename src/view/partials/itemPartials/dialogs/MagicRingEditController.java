package view.partials.itemPartials.dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.DialogController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.MagicRing;

public class MagicRingEditController extends DialogController {

	@FXML
	private TextField nameField;
	@FXML
	private TextField auraField;
	@FXML
	private TextField casterLevelField;
	@FXML
	private TextField priceField;
	@FXML
	private TextField descriptionField;
	@FXML
	private TextField constructionField;
	
	
	private Stage dialogStage;
    private MagicRing ring;
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
    
    public void setRing(MagicRing r)
    {
    	ring = r;
    	
    	nameField.setText(r.getName());
    	auraField.setText(r.getAuraStrength());
    	casterLevelField.setText(r.getCasterLevel());
    	priceField.setText(r.getCost());
    	descriptionField.setText(r.getDescription());
    	constructionField.setText(r.getConstruction());
    	
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

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid item name is set!\n"; 
        } 
        if (auraField.getText() == null || auraField.getText().length() == 0) {
            errorMessage += "No valid aura strength is set!\n"; 
        }  
        if (casterLevelField.getText() == null || casterLevelField.getText().length() == 0) {
            errorMessage += "No valid Caster Level is set!\n"; 
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
            
        	ring.setName(nameField.getText());
        	ring.setAuraStrength(auraField.getText());
        	ring.setCasterLevel(casterLevelField.getText());
        	ring.setCost(priceField.getText());
        	ring.setDescription(descriptionField.getText());
        	ring.setConstruction(constructionField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }
}

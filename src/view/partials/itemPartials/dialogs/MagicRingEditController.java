package view.partials.itemPartials.dialogs;

import javafx.event.ActionEvent;
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
    	
    	nameField.setText(r.Name.get());
    	auraField.setText(r.getAuraStrength());
    	casterLevelField.setText(r.getCasterLevel());
    	priceField.setText(r.Cost.get());
    	descriptionField.setText(r.getDescription());
    	constructionField.setText(r.getConstruction());
    	
    }    
        
    
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
    public void handleOkay(ActionEvent event) {
        if (isInputValid()) {            
            
        	ring.Name.set(nameField.getText());
        	ring.Cost.set(priceField.getText());
        	ring.setAuraStrength(auraField.getText());
        	ring.setCasterLevel(casterLevelField.getText());
        	ring.setDescription(descriptionField.getText());
        	ring.setConstruction(constructionField.getText());
            okayClicked = true;
            dialogStage.close();
        }
    }
}

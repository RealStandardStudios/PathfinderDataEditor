package view.partials.itemPartials.dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.DialogController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.WondrousGood;

public class WondrousGoodEditController extends DialogController{
	
	@FXML
	private TextField rodNameField;
	@FXML
	private TextField casterLevelField;
	@FXML
	private TextField slotField;
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
    private WondrousGood good;
    
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
    
    public void setWondrousGood(WondrousGood g)
    {
    	good = g;
    	rodNameField.setText(g.getName());
    	casterLevelField.setText(g.getCasterLevel());
    	slotField.setText(g.getSlot());
    	priceField.setText(g.getCost());
    	descriptionField.setText(g.getDescription());
    	constructionField.setText(g.getConstruction());
    	auraStrengthField.setText(g.getAuraStrength());
    	weightField.setText(g.getWeight());
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
        if (slotField.getText() == null || slotField.getText().length() == 0) {
            errorMessage += "No valid slot is set!\n"; 
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
    public void handleOkay(ActionEvent event) {
        if (isInputValid()) {            
            good.setName(rodNameField.getText());
            good.setAuraStrength(auraStrengthField.getText());
            good.setConstruction(constructionField.getText());
            good.setSlot(slotField.getText());
            good.setCost(priceField.getText());
            good.setDescription(descriptionField.getText());
            good.setCasterLevel(casterLevelField.getText());
            good.setWeight(weightField.getText());

            okayClicked = true;
            dialogStage.close();
        }
    }
}

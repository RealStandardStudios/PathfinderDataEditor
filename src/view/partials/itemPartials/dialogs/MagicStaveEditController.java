package view.partials.itemPartials.dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.DialogController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.MagicStaves;

public class MagicStaveEditController extends DialogController{

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
	private MagicStaves stave;
	
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
	    
	    public void setMagicStave(MagicStaves s)
	    {
	    	stave = s;
	    	rodNameField.setText(s.getName());
	    	casterLevelField.setText(s.getCasterLevel());
	    	priceField.setText(s.getCost());
	    	descriptionField.setText(s.getDescription());
	    	constructionField.setText(s.getConstruction());
	    	auraStrengthField.setText(s.getAuraStrength());
	    	weightField.setText(s.getWeight());
	    }
	    
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
	    public void handleOkay(ActionEvent event) {
	        if (isInputValid()) {            
	            stave.setName(rodNameField.getText());
	            stave.setAuraStrength(auraStrengthField.getText());
	            stave.setConstruction(constructionField.getText());
	            stave.setCost(priceField.getText());
	            stave.setDescription(descriptionField.getText());
	            stave.setCasterLevel(casterLevelField.getText());
	            stave.setWeight(weightField.getText());

	            okayClicked = true;
	            dialogStage.close();
	        }
	    }
}

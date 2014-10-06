package view.partials.itemPartials.dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.DialogController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.Goods;

/**
 * the controller for the basic goods edit dialog
 * 
 * @author Real Standard Studios - Joshua Boyd
 */
public class BasicGoodsEditController extends DialogController{

	@FXML
	private TextField nameField;
	@FXML
	private TextField costField;
	@FXML
	private TextField weightField;
	
	private Stage dialogStage;
    private Goods good;
    
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
    public void setGood(Goods g)
    {
    	good = g;
    	
    	nameField.setText(g.Name.get());
    	costField.setText(g.Cost.get());
    	weightField.setText(g.Weight.get());
    	
    } 
        
    /**
     * checks for valid input
     * @returns true if correct
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid item name is set!\n"; 
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
    
    /**
     * saves data when Ok button pressed
     */
    @FXML
    public void handleOkay(ActionEvent event) {
        if (isInputValid()) {            
            good.Name.set(nameField.getText());
            good.Cost.set(costField.getText());
            good.Weight.set(weightField.getText());

            okayClicked = true;
            dialogStage.close();
        }
    }
}

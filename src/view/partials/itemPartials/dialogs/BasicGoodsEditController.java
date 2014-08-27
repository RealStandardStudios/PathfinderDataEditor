package view.partials.itemPartials.dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.Goods;

public class BasicGoodsEditController {

	@FXML
	private TextField nameField;
	@FXML
	private TextField costField;
	@FXML
	private TextField weightField;
	
	private Stage dialogStage;
    private Goods good;
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
    
    public void setGood(Goods g)
    {
    	good = g;
    	
    	nameField.setText(g.getName());
    	costField.setText(g.getCost());
    	weightField.setText(g.getWeight());
    	
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
    private void handleOk() {
        if (isInputValid()) {            
            good.setName(nameField.getText());
            good.setCost(costField.getText());
            good.setWeight(weightField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }
}

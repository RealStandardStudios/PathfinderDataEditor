package view.partials.itemPartials.dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jefXif.DialogController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.Armor;
import pathfinder.data.Items.MagicRod;
import pathfinder.data.Items.MagicWeapon;

public class MagicWeaponEditController extends DialogController {

	@FXML
	private TextField armorNameField;
	@FXML
	private TextField costField;
	@FXML
	private TextField acBonusField;
	@FXML
	private TextField maxDexBonusField;
	@FXML
	private TextField armorCheckPenaltyField;
	@FXML
	private TextField arcaneSpellFailureField;
	@FXML
	private TextField speed30Field;
	@FXML
	private TextField speed20Field;
	@FXML
	private TextField weightField;
	
	
	private Stage dialogStage;
    private MagicWeapon weapon;
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
    
    public void setWeapon(MagicWeapon item) {
		// TODO Auto-generated method stub
		
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
           

            okClicked = true;
            dialogStage.close();
        }
    }
}

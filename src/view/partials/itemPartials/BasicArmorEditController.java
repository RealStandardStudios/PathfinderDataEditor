package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pathfinder.data.Items.Armor;
import pathfinder.data.Items.Item;

public class BasicArmorEditController {

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
    private Armor armor;
    private boolean okClicked = false;
    
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setArmor(Armor a)
    {
    	armor = a;
    	
    	armorNameField.setText(a.getName());
    	costField.setText(a.getCost());
    	acBonusField.setText(a.getArmorBonus());
    	maxDexBonusField.setText(a.getMaxDexBonus());
    	armorCheckPenaltyField.setText(a.getArmorCheckPenalty());
    	speed30Field.setText(a.getSpeed30feet());
    	speed20Field.setText(a.getSpeed20feet());
    	weightField.setText(a.getWeight());
    }
    
    
    public boolean isOkClicked() {
        return okClicked;
    }
    /**
     * Called when the user clicks ok.
     */
    
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (armorNameField.getText() == null || armorNameField.getText().length() == 0) {
            errorMessage += "No valid Item name!\n"; 
        }
        return false;
        /*
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n"; 
            }
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
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
        */
    }
}

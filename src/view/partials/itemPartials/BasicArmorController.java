package view.partials.itemPartials;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.Armor;
import pathfinder.data.Items.Item;
import view.partials.itemPartials.dialogs.BasicArmorEditController;

public class BasicArmorController extends ItemPartialController {

	@FXML
	TableView<Item> itemTable;
	@FXML
	TableColumn<Item, String> itemNameColumn;
	
	@FXML
	private Label lblArmorName;
	@FXML
	private Label lblCost;
	@FXML
	private Label lblACBonus;
	@FXML
	private Label lblMaxDexBonus;
	@FXML
	private Label lblArmorCheckPenalty;
	@FXML
	private Label lblArcaneSpellFailure;
	@FXML
	private Label lblSpeed30;
	@FXML
	private Label lblSpeed20;
	@FXML
	private Label lblWeight;
	@Override
	
	public void initialize() {
		// TODO Auto-generated method stub

	}
	
	

	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblArmorName.setText(((Armor)item).getName());
			lblCost.setText(((Armor)item).getCost() + "");
			lblACBonus.setText(((Armor)item).getArmorBonus() + "");
			lblMaxDexBonus.setText(((Armor)item).getMaxDexBonus() + "");
			lblArmorCheckPenalty.setText(((Armor)item).getArmorCheckPenalty() + "");
			lblArcaneSpellFailure.setText(((Armor)item).getArcaneSpellFailiure() + "");
			lblSpeed30.setText(((Armor)item).getSpeed30feet() + "");
			lblSpeed20.setText(((Armor)item).getSpeed20feet() + "");
			lblWeight.setText(((Armor)item).getWeight() + "");
		}
		else
		{
			lblArmorName.setText("Armor Name");
			lblCost.setText("");
			lblACBonus.setText("");
			lblMaxDexBonus.setText("");
			lblArmorCheckPenalty.setText("");
			lblArcaneSpellFailure.setText("");
			lblSpeed30.setText("");
			lblSpeed20.setText("");
			lblWeight.setText("");
		}
		
	}



	@Override
	public void inView(ObservableList<Item> items) {
		itemTable.setItems(items);
		itemNameColumn.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
		itemTable.getSelectionModel().selectedItemProperty().addListener
		((observable, oldValue, newValue) -> this.setItemDetails(newValue));
	}
	
	@FXML
	private void handleEditArmor() {
	    Item selectedArmor = itemTable.getSelectionModel().getSelectedItem();
	    if (selectedArmor != null) {
	        boolean okClicked = showItemEditDialog(selectedArmor);
	        if (okClicked) {
	            setItemDetails(selectedArmor);
	        }

	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Armor Selected")
	            .message("Please select a armor in the table.")
	            .showWarning();
	    }
	}
	
	@Override
	public boolean showItemEditDialog(Item item) {
	    try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader =new FXMLLoader();
	        loader.setLocation(this.getClass().getResource("dialogs/BasicArmorEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Armor");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.getInterface().getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        BasicArmorEditController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setArmor((Armor)item);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}

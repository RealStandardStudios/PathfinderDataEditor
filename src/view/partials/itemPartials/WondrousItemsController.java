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

import pathfinder.data.Items.Item;
import pathfinder.data.Items.WondrousGood;
import view.partials.itemPartials.dialogs.WondrousGoodEditController;

public class WondrousItemsController extends ItemPartialController {

	@FXML
	TableView<Item> itemTable;
	
	@FXML
	TableColumn<Item, String> itemNameColumn;
	@FXML
	private Label lblName;
	@FXML
	private Label lblAura;
	@FXML
	private Label lblCasterLevel;
	@FXML
	private Label lblSlot;
	@FXML
	private Label lblPrice;
	@FXML
	private Label lblWeight;
	@FXML
	private Label lblDescription;
	@FXML
	private Label lblConstruction;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setItemDetails(Item item) {
		if(((WondrousGood)item) != null)
		{
			lblName.setText(((WondrousGood)item).getName());
			lblAura.setText(((WondrousGood)item).getAuraStrength());
			lblCasterLevel.setText(((WondrousGood)item).getCasterLevel());
			lblPrice.setText(((WondrousGood)item).getCost());
			lblWeight.setText(((WondrousGood)item).getWeight());
			lblDescription.setText(((WondrousGood)item).getDescription());
			lblConstruction.setText(((WondrousGood)item).getConstruction());
			lblSlot.setText(((WondrousGood)item).getSlot());
		}
		else
		{
			lblName.setText("No Wondrous Item Selected");
			lblAura.setText("");
			lblCasterLevel.setText("");
			lblPrice.setText("");
			lblWeight.setText("");
			lblDescription.setText("");
			lblConstruction.setText("");
			lblSlot.setText("");
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
	private void handleEditWondrousGood() {
	    Item selectedGood = itemTable.getSelectionModel().getSelectedItem();
	    if (selectedGood != null) {
	        boolean okClicked = showItemEditDialog(selectedGood);
	        if (okClicked) {
	            setItemDetails(selectedGood);
	        }

	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Wondrous Good Selected")
	            .message("Please select a wondrous good in the table.")
	            .showWarning();
	    }
	}
	
	@Override
	public boolean showItemEditDialog(Item item) {
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader =new FXMLLoader();
	        loader.setLocation(this.getClass().getResource("dialogs/WondrousGoodEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Wondrous Good");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.getInterface().getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        WondrousGoodEditController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setWondrousGood((WondrousGood)item);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkayClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
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
import pathfinder.data.Items.MagicRod;
import view.partials.itemPartials.dialogs.MagicRodEditController;

/**
 * the controller for the magic rod partial
 * 
 * @author Real Standard Studios - Joshua Boyd
 */
@SuppressWarnings("deprecation")
public class MagicRodController extends ItemPartialController {

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
	private Label lblPrice;
	@FXML
	private Label lblWeight;
	@FXML
	private Label lblDescription;
	@FXML
	private Label lblConstruction;
	
	/**
	 * the initialize method implemented from extension
	 */
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	/**
	 * this method sets the Item details
	 */
	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblName.setText(((MagicRod)item).Name.get());
			lblAura.setText(((MagicRod)item).getAuraStrength());
			lblCasterLevel.setText(((MagicRod)item).getCasterLevel());
			lblPrice.setText(((MagicRod)item).Cost.get());
			lblWeight.setText(((MagicRod)item).Weight.get());
			lblDescription.setText(((MagicRod)item).getDescription());
			lblConstruction.setText(((MagicRod)item).getConstruction());
		}
		else
		{
			lblName.setText("No Rod Selected");
			lblAura.setText("");
			lblCasterLevel.setText("");
			lblPrice.setText("");
			lblWeight.setText("");
			lblDescription.setText("");
			lblConstruction.setText("");
		}
		
	}

	/**
	 * this method populates the partial
	 */
	@Override
	public void inView(ObservableList<Item> items) {
		itemTable.setItems(items);
		itemNameColumn.setCellValueFactory(cellData->cellData.getValue().Name);
		itemTable.getSelectionModel().selectedItemProperty().addListener
		((observable, oldValue, newValue) -> this.setItemDetails(newValue));
		
	}
	
	/**
	 * a handle method that allows for editing
	 */
	@FXML
	private void handleEditMagicRod() {
	    Item selectedRod = itemTable.getSelectionModel().getSelectedItem();
	    if (selectedRod != null) {
	        boolean okClicked = showItemEditDialog(selectedRod);
	        if (okClicked) {
	            setItemDetails(selectedRod);
	        }

	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Magic Rod Selected")
	            .message("Please select a magic rod in the table.")
	            .showWarning();
	    }
	}
	
	/**
	 * a method that displays a dialog to allow editing
	 */
	@Override
	public boolean showItemEditDialog(Item item) {
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader =new FXMLLoader();
	        loader.setLocation(this.getClass().getResource("dialogs/MagicRodEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Magic Armor");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.getInterface().getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        MagicRodEditController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setMagicRod((MagicRod)item);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkayClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}

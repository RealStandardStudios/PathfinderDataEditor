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
import pathfinder.data.Items.MagicRing;
import view.partials.itemPartials.dialogs.MagicRingEditController;

public class MagicRingController extends ItemPartialController {
	
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
	private Label lblDescription;
	@FXML
	private Label lblConstruction;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblName.setText(((MagicRing)item).getName());
			lblAura.setText(((MagicRing)item).getAuraStrength());
			lblCasterLevel.setText(((MagicRing)item).getCasterLevel());
			lblPrice.setText(((MagicRing)item).getCost());
			lblDescription.setText(((MagicRing)item).getDescription());
			lblConstruction.setText(((MagicRing)item).getConstruction());
		}
		else
		{
			lblName.setText("No Magic Ring Selected");
			lblAura.setText("");
			lblCasterLevel.setText("");
			lblPrice.setText("");
			lblDescription.setText("");
			lblConstruction.setText("");
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
	private void handleEditMagicRing() {
	    Item selectedRing = itemTable.getSelectionModel().getSelectedItem();
	    if (selectedRing != null) {
	        boolean okClicked = showItemEditDialog(selectedRing);
	        if (okClicked) {
	            setItemDetails(selectedRing);
	        }

	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Magic Ring Selected")
	            .message("Please select a magic ring in the table.")
	            .showWarning();
	    }
	}
	
	@Override
	public boolean showItemEditDialog(Item item) {
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader =new FXMLLoader();
	        loader.setLocation(this.getClass().getResource("dialogs/MagicRingEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Magic Ring");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.getInterface().getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        MagicRingEditController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setRing((MagicRing)item);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}

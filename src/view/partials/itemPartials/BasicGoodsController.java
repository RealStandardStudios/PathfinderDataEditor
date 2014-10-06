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

import pathfinder.data.Items.Goods;
import pathfinder.data.Items.Item;
import view.partials.itemPartials.dialogs.BasicGoodsEditController;

/**
 * the controller for basic goods partial
 * 
 * @author Real Standard Studios - Joshua Boyd
 */
public class BasicGoodsController extends ItemPartialController {
	
	@FXML
	TableView<Item> itemTable;
	
	@FXML
	TableColumn<Item, String> itemNameColumn;
	@FXML
	private Label lblName;
	
	@FXML
	private Label lblCost;
	
	@FXML
	private Label lblWeight;

	/**
	 * the initialize method implemented from extension
	 */
	@Override
	public void initialize() {
	}

	/**
	 * this method sets the Item details
	 */
	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblName.setText(((Goods)item).Name.get());
			lblCost.setText(((Goods)item).Cost.get());
			lblWeight.setText(((Goods)item).Weight.get());
		}
		else
		{
			lblName.setText("No Goods selected");
			lblCost.setText("");
			lblWeight.setText("");
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
	private void handleEditGoods() {
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
	            .masthead("No Good Selected")
	            .message("Please select a good in the table.")
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
	        loader.setLocation(this.getClass().getResource("dialogs/BasicGoodsEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Good");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.getInterface().getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        BasicGoodsEditController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setGood((Goods)item);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkayClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}

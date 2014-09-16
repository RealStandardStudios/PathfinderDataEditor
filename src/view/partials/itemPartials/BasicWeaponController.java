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
import pathfinder.data.Items.Weapon;
import view.partials.itemPartials.dialogs.BasicWeaponEditController;

public class BasicWeaponController extends ItemPartialController {

	@FXML
	TableView<Item> itemTable;
	
	@FXML
	TableColumn<Item, String> itemNameColumn;
	@FXML
	private Label lblName;
	@FXML
	private Label lblCost;
	@FXML
	private Label lblDMGS;
	@FXML
	private Label lblDMGM;
	@FXML
	private Label lblCritical;
	@FXML
	private Label lblRange;
	@FXML
	private Label lblWeight;
	@FXML
	private Label lblDmgType;
	@FXML
	private Label lblWeaponType;
	@FXML
	private Label lblWieldStyle;
	@FXML
	private Label lblSpecial;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblName.setText(((Weapon)item).getName());
			lblCost.setText(((Weapon)item).getCost());
			lblDMGS.setText(((Weapon)item).getDmgS());
			lblDMGM.setText(((Weapon)item).getDmgM());
			lblCritical.setText(((Weapon)item).getCritical());
			lblRange.setText(((Weapon)item).getRange());
			lblWeight.setText(((Weapon)item).getWeight());
			lblDmgType.setText(((Weapon)item).getWeaponDmgType());
			lblSpecial.setText(((Weapon)item).getSpecial());
			lblWeaponType.setText(((Weapon)item).getWeaponType());
			lblWieldStyle.setText(((Weapon)item).getWieldStyle());
		}
		else
		{
			lblName.setText("No Weapon Selected");
			lblCost.setText("");
			lblDMGS.setText("");
			lblDMGM.setText("");
			lblCritical.setText("");
			lblRange.setText("");
			lblWeight.setText("");
			lblDmgType.setText("");
			lblSpecial.setText("");
			lblWeaponType.setText("");
			lblWieldStyle.setText("");
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
	private void handleEditWeapon() {
	    Item selectedWeapon = itemTable.getSelectionModel().getSelectedItem();
	    if (selectedWeapon != null) {
	        boolean okClicked = showItemEditDialog(selectedWeapon);
	        if (okClicked) {
	            setItemDetails(selectedWeapon);
	        }

	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Weapon Selected")
	            .message("Please select a weapon in the table.")
	            .showWarning();
	    }
	}
	
	@Override
	public boolean showItemEditDialog(Item item) {
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader =new FXMLLoader();
	        loader.setLocation(this.getClass().getResource("dialogs/BasicWeaponEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Weapon");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.getInterface().getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        BasicWeaponEditController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setWeapon((Weapon)item);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkayClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}

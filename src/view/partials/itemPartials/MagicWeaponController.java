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
import pathfinder.data.Items.MagicWeapon;
import pathfinder.data.Items.Weapon;
import view.partials.itemPartials.dialogs.MagicWeaponEditController;


public class MagicWeaponController extends ItemPartialController {

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
	@FXML
	private Label lblAura;
	@FXML
	private Label lblCasterLevel;
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
			lblName.setText(((MagicWeapon)item).getName());
			lblCost.setText(((MagicWeapon)item).getCost());
			lblDMGS.setText(((MagicWeapon)item).getDmgS());
			lblDMGM.setText(((MagicWeapon)item).getDmgM());
			lblCritical.setText(((MagicWeapon)item).getCritical());
			lblRange.setText(((MagicWeapon)item).getRange());
			lblWeight.setText(((MagicWeapon)item).getWeight());
			lblDmgType.setText(((MagicWeapon)item).getWeaponDmgType());
			lblSpecial.setText(((MagicWeapon)item).getSpecial());
			lblAura.setText(((MagicWeapon)item).getAuraStrength());
			lblCasterLevel.setText(((MagicWeapon)item).getCasterLevel());
			lblDescription.setText(((MagicWeapon)item).getDescription());
			lblConstruction.setText(((MagicWeapon)item).getConstruction());
			lblWeaponType.setText(((MagicWeapon)item).getWeaponType());
			lblWieldStyle.setText(((MagicWeapon)item).getWieldStyle());
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
			lblAura.setText("");
			lblCasterLevel.setText("");
			lblDescription.setText("");
			lblConstruction.setText("");
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
	            .masthead("No Magic Weapon Selected")
	            .message("Please select a magic weapon in the table.")
	            .showWarning();
	    }
	}
	
	@Override
	public boolean showItemEditDialog(Item item) {
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader =new FXMLLoader();
	        loader.setLocation(this.getClass().getResource("dialogs/MagicWeaponEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Magic Weapon");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.getInterface().getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        MagicWeaponEditController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setWeapon((MagicWeapon)item);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}

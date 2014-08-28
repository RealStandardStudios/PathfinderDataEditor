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
import pathfinder.data.Items.MagicArmor;
import view.partials.itemPartials.dialogs.MagicArmorEditController;

public class MagicArmorController extends ItemPartialController {

	@FXML
	TableView<Item> itemTable;
	
	@FXML
	TableColumn<Item, String> itemNameColumn;
	@FXML
	private Label lblArmorName;
	@FXML
	private Label lblACBonus;
	@FXML
	private Label lblMaxDex;
	@FXML
	private Label lblArmorCheckPenalty;
	@FXML
	private Label lblArcaneSpellFalure;
	@FXML
	private Label lblSpeed30ft;
	@FXML
	private Label lblSpeed20ft;
	@FXML
	private Label lblSlot;
	@FXML
	private Label lblAuraStrength;
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
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblArmorName.setText(((MagicArmor)item).getName());
			lblACBonus.setText(((MagicArmor)item).getArmorBonus() + "");
			lblMaxDex.setText(((MagicArmor)item).getMaxDexBonus() + "");
			lblArmorCheckPenalty.setText(((MagicArmor)item).getArmorCheckPenalty()+"");
			lblArcaneSpellFalure.setText(((MagicArmor)item).getArcaneSpellFailiure()+"");
			lblSpeed30ft.setText(((MagicArmor)item).getSpeed30feet() +"");
			lblSpeed20ft.setText(((MagicArmor)item).getSpeed20feet()+"");
			lblSlot.setText(((MagicArmor)item).getSlot());
			lblAuraStrength.setText(((MagicArmor)item).getAuraStrength());
			lblCasterLevel.setText(((MagicArmor)item).getCasterLevel());
			lblPrice.setText(((MagicArmor)item).getCost());
			lblWeight.setText(((MagicArmor)item).getWeight());
			lblDescription.setText(((MagicArmor)item).getDescription());
			lblConstruction.setText(((MagicArmor)item).getConstruction());
		}
		else
		{
			lblArmorName.setText("No Magic Armor Selected");
			lblACBonus.setText("");
			lblMaxDex.setText("");
			lblArmorCheckPenalty.setText("");
			lblArcaneSpellFalure.setText("");
			lblSpeed30ft.setText("");
			lblSpeed20ft.setText("");
			lblSlot.setText("");
			lblAuraStrength.setText("");
			lblCasterLevel.setText("");
			lblPrice.setText("");
			lblWeight.setText("");
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
	private void handleEditMagicArmor() {
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
	            .masthead("No Magic Armor Selected")
	            .message("Please select a magic armor in the table.")
	            .showWarning();
	    }
	}

	@Override
	public boolean showItemEditDialog(Item item) {
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader =new FXMLLoader();
	        loader.setLocation(this.getClass().getResource("dialogs/MagicArmorEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Magic Armor");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.getInterface().getPrimaryStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        MagicArmorEditController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setArmor((MagicArmor)item);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}

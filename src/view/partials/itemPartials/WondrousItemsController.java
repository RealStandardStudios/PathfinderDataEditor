package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pathfinder.data.Items.Item;
import pathfinder.data.Items.WondrousGood;

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

}
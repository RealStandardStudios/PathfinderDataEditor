package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pathfinder.data.Items.Item;
import pathfinder.data.Items.MagicStaves;

public class MagicStavesController extends ItemPartialController {


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
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblName.setText(((MagicStaves)item).getName());
			lblAura.setText(((MagicStaves)item).getAuraStrength());
			lblCasterLevel.setText(((MagicStaves)item).getCasterLevel());
			lblPrice.setText(((MagicStaves)item).getCost());
			lblWeight.setText(((MagicStaves)item).getWeight());
			lblDescription.setText(((MagicStaves)item).getDescription());
			lblConstruction.setText(((MagicStaves)item).getConstruction());
		}
		else
		{
			lblName.setText("No stave Selected");
			lblAura.setText("");
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

	@Override
	public boolean showItemEditDialog(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

}
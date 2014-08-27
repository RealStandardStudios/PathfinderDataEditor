package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jefXif.WindowController;
import pathfinder.data.Items.*;

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
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblName.setText(((Rods)item).getName());
			lblAura.setText(((Rods)item).getAuraStrength());
			lblCasterLevel.setText(((Rods)item).getCasterLevel());
			lblPrice.setText(((Rods)item).getCost());
			lblWeight.setText(((Rods)item).getWeight());
			lblDescription.setText(((Rods)item).getDescription());
			lblConstruction.setText(((Rods)item).getConstruction());
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

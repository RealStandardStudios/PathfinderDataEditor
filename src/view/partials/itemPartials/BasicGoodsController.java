package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pathfinder.data.Items.Item;

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

	@Override
	public void initialize() {
	}

	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblName.setText(item.getName());
			lblCost.setText(item.getCost());
			lblWeight.setText(item.getWeight());
		}
		else
		{
			lblName.setText("No Goods selected");
			lblCost.setText("");
			lblWeight.setText("");
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

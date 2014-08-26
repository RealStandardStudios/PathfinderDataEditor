package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jefXif.WindowController;
import pathfinder.data.Items.*;

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

}

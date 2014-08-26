package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pathfinder.data.Items.Armor;
import pathfinder.data.Items.Item;

public class BasicArmorController extends ItemPartialController {

	@FXML
	TableView<Item> itemTable;
	
	@FXML
	TableColumn<Item, String> itemNameColumn;
	
	@FXML
	private Label lblArmorName;
	
	@FXML
	private Label lblCost;
	
	@FXML
	private Label lblACBonus;
	
	@FXML
	private Label lblMaxDexBonus;
	
	@FXML
	private Label lblArmorCheckPenalty;
	
	@FXML
	private Label lblArcaneSpellFailure;
	
	@FXML
	private Label lblSpeed30;
	
	@FXML
	private Label lblSpeed20;
	
	@FXML
	private Label lblWeight;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}
	
	

	@Override
	public void setItemDetails(Item item) {
		if(item != null)
		{
			lblArmorName.setText(((Armor)item).getName());
			lblCost.setText(((Armor)item).getCost() + "");
			lblACBonus.setText(((Armor)item).getArmorBonus() + "");
			lblMaxDexBonus.setText(((Armor)item).getMaxDexBonus() + "");
			lblArmorCheckPenalty.setText(((Armor)item).getArmorCheckPenalty() + "");
			lblArcaneSpellFailure.setText(((Armor)item).getArcaneSpellFailiure() + "");
			lblSpeed30.setText(((Armor)item).getSpeed30feet() + "");
			lblSpeed20.setText(((Armor)item).getSpeed20feet() + "");
			lblWeight.setText(((Armor)item).getWeight() + "");
		}
		else
		{
			lblArmorName.setText("Armor Name");
			lblCost.setText("");
			lblACBonus.setText("");
			lblMaxDexBonus.setText("");
			lblArmorCheckPenalty.setText("");
			lblArcaneSpellFailure.setText("");
			lblSpeed30.setText("");
			lblSpeed20.setText("");
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

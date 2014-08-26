package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jefXif.WindowController;
import pathfinder.data.Items.*;

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
	private Label lblType;
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
			lblType.setText(((Weapon)item).getWeaponDmgType());
			lblSpecial.setText(((Weapon)item).getSpecial());
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
			lblType.setText("");
			lblSpecial.setText("");
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

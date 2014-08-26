package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jefXif.WindowController;
import pathfinder.data.Items.*;

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

}

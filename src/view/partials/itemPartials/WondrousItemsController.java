package view.partials.itemPartials;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pathfinder.data.Items.*;
import jefXif.WindowController;

public class WondrousItemsController extends WindowController {


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
	
	public void setStave(WondrousGood item)
	{
		if(item != null)
		{
			lblName.setText(item.getName());
			lblAura.setText(item.getAuraStrength());
			lblCasterLevel.setText(item.getCasterLevel());
			lblPrice.setText(item.getCost());
			lblWeight.setText(item.getWeight());
			lblDescription.setText(item.getDescription());
			lblConstruction.setText(item.getConstruction());
			lblSlot.setText(item.getSlot());
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

}
package view.partials.itemPartials;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jefXif.WindowController;
import pathfinder.data.Items.*;

public class MagicRodController extends WindowController {

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
	
	public void setRod(Rods rod)
	{
		if(rod != null)
		{
			lblName.setText(rod.getName());
			lblAura.setText(rod.getAuraStrength());
			lblCasterLevel.setText(rod.getCasterLevel());
			lblPrice.setText(rod.getCost());
			lblWeight.setText(rod.getWeight());
			lblDescription.setText(rod.getDescription());
			lblConstruction.setText(rod.getConstruction());
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

}

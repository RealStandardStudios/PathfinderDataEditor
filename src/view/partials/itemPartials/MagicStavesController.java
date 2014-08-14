package view.partials.itemPartials;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pathfinder.data.Items.*;
import jefXif.WindowController;

public class MagicStavesController extends WindowController {


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
	
	public void setStave(Staves stave)
	{
		if(stave != null)
		{
			lblName.setText(stave.getName());
			lblAura.setText(stave.getAuraStrength());
			lblCasterLevel.setText(stave.getCasterLevel());
			lblPrice.setText(stave.getCost());
			lblWeight.setText(stave.getWeight());
			lblDescription.setText(stave.getDescription());
			lblConstruction.setText(stave.getConstruction());
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

}
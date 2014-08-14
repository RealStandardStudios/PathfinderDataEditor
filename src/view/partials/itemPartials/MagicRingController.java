package view.partials.itemPartials;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jefXif.WindowController;
import pathfinder.data.Items.*;

public class MagicRingController extends WindowController {
	
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
	
	public void setMagicRing(MagicRing ring)
	{
		if(ring != null)
		{
			lblName.setText(ring.getName());
			lblAura.setText(ring.getAuraStrength());
			lblCasterLevel.setText(ring.getCasterLevel());
			lblPrice.setText(ring.getCost());
			lblDescription.setText(ring.getDescription());
			lblConstruction.setText(ring.getConstruction());
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

}

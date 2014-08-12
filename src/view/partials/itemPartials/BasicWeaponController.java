package view.partials.itemPartials;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jefXif.WindowController;
import pathfinder.data.Items.*;

public class BasicWeaponController extends WindowController {

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
	
	public void setBasicWeapon(Weapon weapon)
	{
		if(weapon != null)
		{
			lblName.setText(weapon.getName());
			lblCost.setText(weapon.getCost());
			lblDMGS.setText(weapon.getDmgS());
			lblDMGM.setText(weapon.getDmgM());
			lblCritical.setText(weapon.getCritical());
			lblRange.setText(weapon.getRange());
			lblWeight.setText(weapon.getWeight());
			lblType.setText(weapon.getType());
			lblSpecial.setText(weapon.getSpecial());
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

}

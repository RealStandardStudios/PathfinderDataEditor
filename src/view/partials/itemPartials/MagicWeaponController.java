package view.partials.itemPartials;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pathfinder.data.Items.*;
import jefXif.WindowController;


public class MagicWeaponController extends WindowController {

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
	@FXML
	private Label lblAura;
	@FXML
	private Label lblCasterLevel;
	@FXML
	private Label lblDescription;
	@FXML
	private Label lblConstruction;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}
	
	public void setBasicWeapon(MagicWeapon weapon)
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
			lblType.setText(weapon.getWeaponDmgType());
			lblSpecial.setText(weapon.getSpecial());
			lblAura.setText(weapon.getAuraStrength());
			lblCasterLevel.setText(weapon.getCasterLevel());
			lblDescription.setText(weapon.getDescription());
			lblConstruction.setText(weapon.getConstruction());
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
			lblAura.setText("");
			lblCasterLevel.setText("");
			lblDescription.setText("");
			lblConstruction.setText("");
		}
	}

}

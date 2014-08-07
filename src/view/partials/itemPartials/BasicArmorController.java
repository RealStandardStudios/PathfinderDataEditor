package view.partials.itemPartials;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jefXif.WindowController;
import pathfinder.data.Items.Armor;

public class BasicArmorController extends WindowController {

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
	
	public void setArmor(Armor armor)
	{
		if(armor != null)
		{
			lblArmorName.setText(armor.getName());
			lblCost.setText(armor.getCost() + " gp");
			lblACBonus.setText(armor.getArmorBonus() + "");
			lblMaxDexBonus.setText(armor.getMaxDexBonus() + "");
			lblArmorCheckPenalty.setText(armor.getArmorCheckPenalty() + "");
			lblArcaneSpellFailure.setText(armor.getArcaneSpellFailiure() + "%");
			lblSpeed30.setText(armor.getSpeed30feet() + " ft");
			lblSpeed20.setText(armor.getSpeed20feet() + " ft");
			lblWeight.setText(armor.getWeight() + " lbs");
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

}

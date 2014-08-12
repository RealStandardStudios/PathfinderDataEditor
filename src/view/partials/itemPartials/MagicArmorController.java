package view.partials.itemPartials;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jefXif.WindowController;
import pathfinder.data.Items.*;

public class MagicArmorController extends WindowController {

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
	
	public void setMagicArmor(MagicArmor magicArmor)
	{
		if(magicArmor != null)
		{
			lblArmorName.setText(magicArmor.getName());
			lblACBonus.setText(magicArmor.getArmorBonus() + "");
			lblMaxDex.setText(magicArmor.getMaxDexBonus() + "");
			lblArmorCheckPenalty.setText(magicArmor.getArmorCheckPenalty()+"");
			lblArcaneSpellFalure.setText(magicArmor.getArcaneSpellFailiure()+"");
			lblSpeed30ft.setText(magicArmor.getSpeed30feet() +"");
			lblSpeed20ft.setText(magicArmor.getSpeed20feet()+"");
			lblSlot.setText(magicArmor.getSlot());
			lblAuraStrength.setText(magicArmor.getAuraStrength());
			lblCasterLevel.setText(magicArmor.getCasterLevel());
			lblPrice.setText(magicArmor.getCost());
			lblWeight.setText(magicArmor.getWeight());
			lblDescription.setText(magicArmor.getDescription());
			lblConstruction.setText(magicArmor.getConstruction());
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

}

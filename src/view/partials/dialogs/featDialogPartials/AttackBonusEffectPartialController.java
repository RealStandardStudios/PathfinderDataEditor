package view.partials.dialogs.featDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pathfinder.data.Effects.AttackBonusEffect;
import pathfinder.data.Effects.Effect;

public class AttackBonusEffectPartialController extends EffectPartialController {

	@FXML
	TextField txtBonusVs;
	@FXML
	TextField txtBonusType;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
		this.txtBonusVs.setText(((AttackBonusEffect)this.effect).getBonusVs());
		this.txtBonusType.setText(((AttackBonusEffect)this.effect).getBonusType());
	}
}

package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import pathfinder.data.Effects.ArmorClassEffect;
import pathfinder.data.Effects.Effect;

public class ArmorClassEffectPartialController extends EffectPartialController {
	@FXML
	TextArea txtaBonusType;
	
	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
		this.txtaBonusType.setText(((ArmorClassEffect)this.effect).getBonusType());
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((ArmorClassEffect)this.effect).setBonusType(txtaBonusType.getText());
		return this.effect;
	}

}

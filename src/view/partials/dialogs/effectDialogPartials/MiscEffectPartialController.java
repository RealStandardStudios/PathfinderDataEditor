package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.NonValued.MiscEffect;

public class MiscEffectPartialController extends EffectPartialController {

	@FXML
	TextArea txtaEffect;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
		this.txtaEffect.setText(((MiscEffect)this.effect).getEffect());
	}

	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((MiscEffect)this.effect).setEffect(txtaEffect.getText());
		return this.effect;
	}
}

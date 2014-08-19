package view.partials.dialogs.featDialogPartials;

import pathfinder.data.Effects.Effect;

public class DamageEffectPartialController extends EffectPartialController {
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
	}
	
	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		return this.effect;
	}
}

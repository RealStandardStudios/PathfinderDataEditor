package view.partials.dialogs.featDialogPartials;

import pathfinder.data.Effects.Effect;

public class CombatManeuverBonusEffectPartialController extends EffectPartialController {
	
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
}

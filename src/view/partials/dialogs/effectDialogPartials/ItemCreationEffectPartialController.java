package view.partials.dialogs.effectDialogPartials;

import pathfinder.data.Effects.Effect;

/**
 * the controller for the Item Creation effect partial
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class ItemCreationEffectPartialController extends EffectPartialController {
	
	/**
	 * the initialize method implemented from extension
	 */
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * a method for setting the effect
	 */
	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
	}
	
	/**
	 * a method for getting an effect
	 */
	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		return this.effect;
	}
}

package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.NonValued.MiscEffect;

/**
 * the controller for the Misc effect partial
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class MiscEffectPartialController extends EffectPartialController {

	@FXML
	TextArea txtaEffect;
	
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
		this.txtaEffect.setText(((MiscEffect)this.effect).getEffect());
	}

	/**
	 * a method for getting an effect
	 */
	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((MiscEffect)this.effect).setEffect(txtaEffect.getText());
		return this.effect;
	}
}

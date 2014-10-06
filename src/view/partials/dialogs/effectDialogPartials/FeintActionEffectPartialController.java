package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.Actions.FeintActionEffect;

/**
 * the controller for the Feint Action effect partial
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class FeintActionEffectPartialController extends EffectPartialController {

	@FXML
	TextArea txtaDescription;
	
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
		this.txtaDescription.setText(((FeintActionEffect)this.effect).getDescription());
	}

	/**
	 * a method for getting an effect
	 */
	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((FeintActionEffect)this.effect).setDescription(txtaDescription.getText());
		return this.effect;
	}
}

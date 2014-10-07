package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.SaveAttributeEffect;

/**
 * the controller for the Save Attribute effect partial
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class SaveAttributeEffectPartialController extends EffectPartialController {

	@FXML
	TextField txtSaveAttributeName;
	
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
		if(effect.getClass().isInstance(SaveAttributeEffect.class))
			this.effect = effect;
		else {
			this.effect = new SaveAttributeEffect();
			this.effect.setName(effect.getName());
			this.effect.setValue(effect.getValue());
		}
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
		this.txtSaveAttributeName.setText(((SaveAttributeEffect)this.effect).getAttributeName());
	}

	/**
	 * a method for getting an effect
	 */
	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((SaveAttributeEffect)this.effect).setAttributeName(txtSaveAttributeName.getText());
		return this.effect;
	}
}

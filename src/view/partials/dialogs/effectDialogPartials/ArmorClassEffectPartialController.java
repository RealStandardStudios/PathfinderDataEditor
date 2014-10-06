package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import pathfinder.data.Effects.ArmorClassEffect;
import pathfinder.data.Effects.Effect;

/**
 * the controller for the Armour Class effect partial
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class ArmorClassEffectPartialController extends EffectPartialController {
	@FXML
	TextArea txtaBonusType;
	
	/**
	 * a method for setting the effect
	 */
	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
		this.txtaBonusType.setText(((ArmorClassEffect)this.effect).getBonusType());
	}

	/**
	 * the initialize method implemented from extension
	 */
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	/**
	 * a method for getting an effect
	 */
	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((ArmorClassEffect)this.effect).setBonusType(txtaBonusType.getText());
		return this.effect;
	}

}

package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.Actions.ActionToSwiftEffect;

/**
 * the controller for the Action to Swift effect partial
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class ActionToSwiftEffectPartialController extends EffectPartialController {

	@FXML
	TextField txtSpecifiedAction;
	
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
		this.txtSpecifiedAction.setText(((ActionToSwiftEffect)this.effect).getAction());
	}
	
	/**
	 * a method for getting an effect
	 */
	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((ActionToSwiftEffect)this.effect).setAction(txtSpecifiedAction.getText());
		return this.effect;
	}
}

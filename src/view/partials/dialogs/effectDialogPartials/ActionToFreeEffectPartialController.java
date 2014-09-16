package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.Actions.ActionToFreeEffect;

public class ActionToFreeEffectPartialController extends EffectPartialController {

	@FXML
	TextField txtSpecifiedAction;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
		this.txtSpecifiedAction.setText(((ActionToFreeEffect)this.effect).getAction());
	}

	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((ActionToFreeEffect)this.effect).setAction(txtSpecifiedAction.getText());
		return this.effect;
	}
}

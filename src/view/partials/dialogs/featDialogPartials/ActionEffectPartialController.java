package view.partials.dialogs.featDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.Actions.ActionEffect;

public class ActionEffectPartialController extends EffectPartialController {

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
		this.txtSpecifiedAction.setText(((ActionEffect)this.effect).getAction());
	}

	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((ActionEffect)this.effect).setAction(txtSpecifiedAction.getText());
		return this.effect;
	}
}

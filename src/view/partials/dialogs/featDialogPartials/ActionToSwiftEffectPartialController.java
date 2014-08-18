package view.partials.dialogs.featDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.Actions.ActionToSwiftEffect;

public class ActionToSwiftEffectPartialController extends EffectPartialController {

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
		this.txtSpecifiedAction.setText(((ActionToSwiftEffect)this.effect).getAction());
	}
}

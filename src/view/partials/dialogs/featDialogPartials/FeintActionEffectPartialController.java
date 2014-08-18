package view.partials.dialogs.featDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.Actions.FeintActionEffect;

public class FeintActionEffectPartialController extends EffectPartialController {

	@FXML
	TextArea txtaDescription;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
		this.txtaDescription.setText(((FeintActionEffect)this.effect).getDescription());
	}
}

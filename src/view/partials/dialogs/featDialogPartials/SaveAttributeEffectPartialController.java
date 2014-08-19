package view.partials.dialogs.featDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.SaveAttributeEffect;

public class SaveAttributeEffectPartialController extends EffectPartialController {

	@FXML
	TextArea txtSaveAttributeName;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
		this.txtSaveAttributeName.setText(((SaveAttributeEffect)this.effect).getAttributeName());
	}

	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((SaveAttributeEffect)this.effect).setAttributeName(txtSaveAttributeName.getText());
		return this.effect;
	}
}

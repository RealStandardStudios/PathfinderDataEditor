package view.partials.dialogs.featDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.NonValued.MetaMagicEffect;

public class MetaMagicEffectPartialController extends EffectPartialController {
	
	@FXML
	TextField txtSpellEffect;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEffect(Effect effect) {
		this.effect = effect;
		this.txtEffectName.setText(this.effect.getName());
		this.txtEffectValue.setText(Integer.toString(this.effect.getValue()));
		this.txtSpellEffect.setText(((MetaMagicEffect)this.effect).getEffect());
	}

	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((MetaMagicEffect)this.effect).setEffect(txtSpellEffect.getText());
		return this.effect;
	}
}

 package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Effects.SkillEffect;

/**
 * the controller for the Skill effect partial
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class SkillEffectPartialController extends EffectPartialController {

	@FXML
	TextField txtSkillName;
	@FXML
	TextField txtBonusType;
	@FXML
	TextField txtBonusVs;
	
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
		this.txtSkillName.setText(((SkillEffect)this.effect).getSkillName());
		this.txtBonusType.setText(((SkillEffect)this.effect).getBonusType());
		this.txtBonusVs.setText(((SkillEffect)this.effect).getBonusVs());
	}

	/**
	 * a method for getting an effect
	 */
	@Override
	public Effect getEffect() {
		this.effect.setName(txtEffectName.getText());
		this.effect.setValue(Integer.parseInt(txtEffectValue.getText()));
		((SkillEffect)this.effect).setSkillName(txtSkillName.getText());
		((SkillEffect)this.effect).setBonusType(txtBonusType.getText());
		((SkillEffect)this.effect).setBonusVs(txtBonusVs.getText());
		return this.effect;
	}
}

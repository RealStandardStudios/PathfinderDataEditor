package view.partials.dialogs.effectDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jefXif.WindowController;
import pathfinder.data.Effects.Effect;

/**
 * the base controller class for effect partials
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public abstract class EffectPartialController extends WindowController {
	Effect effect;
	@FXML
	public TextField txtEffectName;
	
	@FXML
	public TextField txtEffectValue;

	/**
	 * a method for setting the effect
	 */
	public abstract void setEffect(Effect effect);
	
	/**
	 * a method for getting an effect
	 */
	public abstract Effect getEffect();
}

package view.partials.dialogs.featDialogPartials;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jefXif.WindowController;
import pathfinder.data.Effects.Effect;

public abstract class EffectPartialController extends WindowController {
	Effect effect;
	@FXML
	public TextField txtEffectName;
	
	@FXML
	public TextField txtEffectValue;

	public abstract void setEffect(Effect effect);
	
	public abstract Effect getEffect();
}

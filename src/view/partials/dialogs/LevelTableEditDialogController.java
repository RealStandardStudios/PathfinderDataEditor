/**
 * 
 */
package view.partials.dialogs;

import editor.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jefXif.DialogController;
import pathfinder.data.Classes.Objects.LevelTable.LevelTableRow;

/**
 * 
 * @author RealStandardStudios - Matthew Meehan
 */
public class LevelTableEditDialogController extends DialogController {
	
	//region txtBaseAttackBonus
	@FXML
	TextField txtlvl1BaseAttackBonus;
	@FXML
	TextField txtlvl2BaseAttackBonus;
	@FXML
	TextField txtlvl3BaseAttackBonus;
	@FXML
	TextField txtlvl4BaseAttackBonus;
	@FXML
	TextField txtlvl5BaseAttackBonus;
	@FXML
	TextField txtlvl6BaseAttackBonus;
	@FXML
	TextField txtlvl7BaseAttackBonus;
	@FXML
	TextField txtlvl8BaseAttackBonus;
	@FXML
	TextField txtlvl9BaseAttackBonus;
	@FXML
	TextField txtlvl10BaseAttackBonus;
	@FXML
	TextField txtlvl11BaseAttackBonus;
	@FXML
	TextField txtlvl12BaseAttackBonus;
	@FXML
	TextField txtlvl13BaseAttackBonus;
	@FXML
	TextField txtlvl14BaseAttackBonus;
	@FXML
	TextField txtlvl15BaseAttackBonus;
	@FXML
	TextField txtlvl16BaseAttackBonus;
	@FXML
	TextField txtlvl17BaseAttackBonus;
	@FXML
	TextField txtlvl18BaseAttackBonus;
	@FXML
	TextField txtlvl19BaseAttackBonus;
	@FXML
	TextField txtlvl20BaseAttackBonus;
	
	TextField[] baseAttackBonus;
	//endregion
	
	//region txtFortitudeSave
	@FXML
	TextField txtlvl1FortitudeSave;
	@FXML
	TextField txtlvl2FortitudeSave;
	@FXML
	TextField txtlvl3FortitudeSave;
	@FXML
	TextField txtlvl4FortitudeSave;
	@FXML
	TextField txtlvl5FortitudeSave;
	@FXML
	TextField txtlvl6FortitudeSave;
	@FXML
	TextField txtlvl7FortitudeSave;
	@FXML
	TextField txtlvl8FortitudeSave;
	@FXML
	TextField txtlvl9FortitudeSave;
	@FXML
	TextField txtlvl10FortitudeSave;
	@FXML
	TextField txtlvl11FortitudeSave;
	@FXML
	TextField txtlvl12FortitudeSave;
	@FXML
	TextField txtlvl13FortitudeSave;
	@FXML
	TextField txtlvl14FortitudeSave;
	@FXML
	TextField txtlvl15FortitudeSave;
	@FXML
	TextField txtlvl16FortitudeSave;
	@FXML
	TextField txtlvl17FortitudeSave;
	@FXML
	TextField txtlvl18FortitudeSave;
	@FXML
	TextField txtlvl19FortitudeSave;
	@FXML
	TextField txtlvl20FortitudeSave;
	
	TextField[] fortitudeSaves;
	//endregion
	
	//region txtReflexSave
	@FXML
	TextField txtlvl1ReflexSave;
	@FXML
	TextField txtlvl2ReflexSave;
	@FXML
	TextField txtlvl3ReflexSave;
	@FXML
	TextField txtlvl4ReflexSave;
	@FXML
	TextField txtlvl5ReflexSave;
	@FXML
	TextField txtlvl6ReflexSave;
	@FXML
	TextField txtlvl7ReflexSave;
	@FXML
	TextField txtlvl8ReflexSave;
	@FXML
	TextField txtlvl9ReflexSave;
	@FXML
	TextField txtlvl10ReflexSave;
	@FXML
	TextField txtlvl11ReflexSave;
	@FXML
	TextField txtlvl12ReflexSave;
	@FXML
	TextField txtlvl13ReflexSave;
	@FXML
	TextField txtlvl14ReflexSave;
	@FXML
	TextField txtlvl15ReflexSave;
	@FXML
	TextField txtlvl16ReflexSave;
	@FXML
	TextField txtlvl17ReflexSave;
	@FXML
	TextField txtlvl18ReflexSave;
	@FXML
	TextField txtlvl19ReflexSave;
	@FXML
	TextField txtlvl20ReflexSave;
	
	TextField[] reflexSaves;
	//endregion
	
	//region txtWillSave
	@FXML
	TextField txtlvl1WillSave;
	@FXML
	TextField txtlvl2WillSave;
	@FXML
	TextField txtlvl3WillSave;
	@FXML
	TextField txtlvl4WillSave;
	@FXML
	TextField txtlvl5WillSave;
	@FXML
	TextField txtlvl6WillSave;
	@FXML
	TextField txtlvl7WillSave;
	@FXML
	TextField txtlvl8WillSave;
	@FXML
	TextField txtlvl9WillSave;
	@FXML
	TextField txtlvl10WillSave;
	@FXML
	TextField txtlvl11WillSave;
	@FXML
	TextField txtlvl12WillSave;
	@FXML
	TextField txtlvl13WillSave;
	@FXML
	TextField txtlvl14WillSave;
	@FXML
	TextField txtlvl15WillSave;
	@FXML
	TextField txtlvl16WillSave;
	@FXML
	TextField txtlvl17WillSave;
	@FXML
	TextField txtlvl18WillSave;
	@FXML
	TextField txtlvl19WillSave;
	@FXML
	TextField txtlvl20WillSave;
	
	TextField[] willSaves;
	//endregion
	
	//region txtSpecials
	@FXML
	TextField txtlvl1Specials;
	@FXML
	TextField txtlvl2Specials;
	@FXML
	TextField txtlvl3Specials;
	@FXML
	TextField txtlvl4Specials;
	@FXML
	TextField txtlvl5Specials;
	@FXML
	TextField txtlvl6Specials;
	@FXML
	TextField txtlvl7Specials;
	@FXML
	TextField txtlvl8Specials;
	@FXML
	TextField txtlvl9Specials;
	@FXML
	TextField txtlvl10Specials;
	@FXML
	TextField txtlvl11Specials;
	@FXML
	TextField txtlvl12Specials;
	@FXML
	TextField txtlvl13Specials;
	@FXML
	TextField txtlvl14Specials;
	@FXML
	TextField txtlvl15Specials;
	@FXML
	TextField txtlvl16Specials;
	@FXML
	TextField txtlvl17Specials;
	@FXML
	TextField txtlvl18Specials;
	@FXML
	TextField txtlvl19Specials;
	@FXML
	TextField txtlvl20Specials;
	
	TextField[] specials;
	//endregion

	LevelTableRow[] levelTable;
	
	/**
	 * @return the levelTable
	 */
	public LevelTableRow[] getLevelTable() {
		return levelTable;
	}

	/**
	 * @param levelTable the levelTable to set
	 */
	public void setLevelTable(LevelTableRow[] levelTable) {
		this.levelTable = levelTable;
		baseAttackBonus = new TextField[] {
				txtlvl1BaseAttackBonus,txtlvl2BaseAttackBonus,txtlvl3BaseAttackBonus,txtlvl4BaseAttackBonus,txtlvl5BaseAttackBonus,
				txtlvl6BaseAttackBonus,txtlvl7BaseAttackBonus,txtlvl8BaseAttackBonus,txtlvl9BaseAttackBonus,txtlvl10BaseAttackBonus,
				txtlvl11BaseAttackBonus,txtlvl12BaseAttackBonus,txtlvl13BaseAttackBonus,txtlvl14BaseAttackBonus,txtlvl15BaseAttackBonus,
				txtlvl16BaseAttackBonus,txtlvl17BaseAttackBonus,txtlvl18BaseAttackBonus,txtlvl19BaseAttackBonus,txtlvl20BaseAttackBonus
			};
			
			fortitudeSaves = new TextField[] {
				txtlvl1FortitudeSave,txtlvl2FortitudeSave,txtlvl3FortitudeSave,txtlvl4FortitudeSave,txtlvl5FortitudeSave,
				txtlvl6FortitudeSave,txtlvl7FortitudeSave,txtlvl8FortitudeSave,txtlvl9FortitudeSave,txtlvl10FortitudeSave,
				txtlvl11FortitudeSave,txtlvl12FortitudeSave,txtlvl13FortitudeSave,txtlvl14FortitudeSave,txtlvl15FortitudeSave,
				txtlvl16FortitudeSave,txtlvl17FortitudeSave,txtlvl18FortitudeSave,txtlvl19FortitudeSave,txtlvl20FortitudeSave
			};
			
			reflexSaves = new TextField[] {
				txtlvl1ReflexSave,txtlvl2ReflexSave,txtlvl3ReflexSave,txtlvl4ReflexSave,txtlvl5ReflexSave,
				txtlvl6ReflexSave,txtlvl7ReflexSave,txtlvl8ReflexSave,txtlvl9ReflexSave,txtlvl10ReflexSave,
				txtlvl11ReflexSave,txtlvl12ReflexSave,txtlvl13ReflexSave,txtlvl14ReflexSave,txtlvl15ReflexSave,
				txtlvl16ReflexSave,txtlvl17ReflexSave,txtlvl18ReflexSave,txtlvl19ReflexSave,txtlvl20ReflexSave	
			};
			
			willSaves = new TextField[] {
				txtlvl1WillSave,txtlvl2WillSave,txtlvl3WillSave,txtlvl4WillSave,txtlvl5WillSave,
				txtlvl6WillSave,txtlvl7WillSave,txtlvl8WillSave,txtlvl9WillSave,txtlvl10WillSave,
				txtlvl11WillSave,txtlvl12WillSave,txtlvl13WillSave,txtlvl14WillSave,txtlvl15WillSave,
				txtlvl16WillSave,txtlvl17WillSave,txtlvl18WillSave,txtlvl19WillSave,txtlvl20WillSave
			};
			
			specials = new TextField[] {
				txtlvl1Specials,txtlvl2Specials,txtlvl3Specials,txtlvl4Specials,txtlvl5Specials,
				txtlvl6Specials,txtlvl7Specials,txtlvl8Specials,txtlvl9Specials,txtlvl10Specials,
				txtlvl11Specials,txtlvl12Specials,txtlvl13Specials,txtlvl14Specials,txtlvl15Specials,
				txtlvl16Specials,txtlvl17Specials,txtlvl18Specials,txtlvl19Specials,txtlvl20Specials	
			};
		for (int i = 0; i < levelTable.length; i++) {
			baseAttackBonus[i].setText(levelTable[i].getBABProperty().get());
			fortitudeSaves[i].setText(levelTable[i].getFortSave().getBaseValueProperty().get().toString());
			reflexSaves[i].setText(levelTable[i].getRefSave().getBaseValueProperty().get().toString());
			willSaves[i].setText(levelTable[i].getWillSave().getBaseValueProperty().get().toString());
			specials[i].setText(levelTable[i].getSpecialProperty().get());
		}
	}
	
	@Override
	public void handleOkay(ActionEvent event) {
		for (int i = 0; i < levelTable.length; i++) {
			levelTable[i].setBAB(Tools.StringToIntArray(baseAttackBonus[i].getText().split("/")));
			levelTable[i].getFortSave().setBaseValue(Integer.parseInt(fortitudeSaves[i].getText()));
			levelTable[i].getRefSave().setBaseValue(Integer.parseInt(reflexSaves[i].getText()));
			levelTable[i].getWillSave().setBaseValue(Integer.parseInt(willSaves[i].getText()));
			levelTable[i].setSpecial(specials[i].getText());
		}
		okayClicked = true;
		this.getDialogStage().close();
	}

}

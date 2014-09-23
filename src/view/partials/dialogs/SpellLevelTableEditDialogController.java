/**
 * 
 */
package view.partials.dialogs;

import pathfinder.data.Classes.Objects.LevelTable.SpellLevelTableRow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jefXif.DialogController;

/**
 * the controller for the spell level table edit dialog
 * 
 * @author RealStandardStudios - Matthew Meehan
 */
public class SpellLevelTableEditDialogController extends DialogController {

	// region 0 Level Spells per Day
	@FXML
	TextField txtlvl10LevelSpells;
	@FXML
	TextField txtlvl20LevelSpells;
	@FXML
	TextField txtlvl30LevelSpells;
	@FXML
	TextField txtlvl40LevelSpells;
	@FXML
	TextField txtlvl50LevelSpells;
	@FXML
	TextField txtlvl60LevelSpells;
	@FXML
	TextField txtlvl70LevelSpells;
	@FXML
	TextField txtlvl80LevelSpells;
	@FXML
	TextField txtlvl90LevelSpells;
	@FXML
	TextField txtlvl100LevelSpells;
	@FXML
	TextField txtlvl110LevelSpells;
	@FXML
	TextField txtlvl120LevelSpells;
	@FXML
	TextField txtlvl130LevelSpells;
	@FXML
	TextField txtlvl140LevelSpells;
	@FXML
	TextField txtlvl150LevelSpells;
	@FXML
	TextField txtlvl160LevelSpells;
	@FXML
	TextField txtlvl170LevelSpells;
	@FXML
	TextField txtlvl180LevelSpells;
	@FXML
	TextField txtlvl190LevelSpells;
	@FXML
	TextField txtlvl200LevelSpells;

	TextField[] zeroLevelSpells;
	// endregion

	// region 1st Level Spells per Day
	@FXML
	TextField txtlvl11stLevelSpells;
	@FXML
	TextField txtlvl21stLevelSpells;
	@FXML
	TextField txtlvl31stLevelSpells;
	@FXML
	TextField txtlvl41stLevelSpells;
	@FXML
	TextField txtlvl51stLevelSpells;
	@FXML
	TextField txtlvl61stLevelSpells;
	@FXML
	TextField txtlvl71stLevelSpells;
	@FXML
	TextField txtlvl81stLevelSpells;
	@FXML
	TextField txtlvl91stLevelSpells;
	@FXML
	TextField txtlvl101stLevelSpells;
	@FXML
	TextField txtlvl111stLevelSpells;
	@FXML
	TextField txtlvl121stLevelSpells;
	@FXML
	TextField txtlvl131stLevelSpells;
	@FXML
	TextField txtlvl141stLevelSpells;
	@FXML
	TextField txtlvl151stLevelSpells;
	@FXML
	TextField txtlvl161stLevelSpells;
	@FXML
	TextField txtlvl171stLevelSpells;
	@FXML
	TextField txtlvl181stLevelSpells;
	@FXML
	TextField txtlvl191stLevelSpells;
	@FXML
	TextField txtlvl201stLevelSpells;

	TextField[] firstLevelSpells;
	// endregion

	// region 2nd Level Spells per Day
	@FXML
	TextField txtlvl12ndLevelSpells;
	@FXML
	TextField txtlvl22ndLevelSpells;
	@FXML
	TextField txtlvl32ndLevelSpells;
	@FXML
	TextField txtlvl42ndLevelSpells;
	@FXML
	TextField txtlvl52ndLevelSpells;
	@FXML
	TextField txtlvl62ndLevelSpells;
	@FXML
	TextField txtlvl72ndLevelSpells;
	@FXML
	TextField txtlvl82ndLevelSpells;
	@FXML
	TextField txtlvl92ndLevelSpells;
	@FXML
	TextField txtlvl102ndLevelSpells;
	@FXML
	TextField txtlvl112ndLevelSpells;
	@FXML
	TextField txtlvl122ndLevelSpells;
	@FXML
	TextField txtlvl132ndLevelSpells;
	@FXML
	TextField txtlvl142ndLevelSpells;
	@FXML
	TextField txtlvl152ndLevelSpells;
	@FXML
	TextField txtlvl162ndLevelSpells;
	@FXML
	TextField txtlvl172ndLevelSpells;
	@FXML
	TextField txtlvl182ndLevelSpells;
	@FXML
	TextField txtlvl192ndLevelSpells;
	@FXML
	TextField txtlvl202ndLevelSpells;

	TextField[] secondLevelSpells;
	// endregion

	// region 3rd Level Spells per Day
	@FXML
	TextField txtlvl13rdLevelSpells;
	@FXML
	TextField txtlvl23rdLevelSpells;
	@FXML
	TextField txtlvl33rdLevelSpells;
	@FXML
	TextField txtlvl43rdLevelSpells;
	@FXML
	TextField txtlvl53rdLevelSpells;
	@FXML
	TextField txtlvl63rdLevelSpells;
	@FXML
	TextField txtlvl73rdLevelSpells;
	@FXML
	TextField txtlvl83rdLevelSpells;
	@FXML
	TextField txtlvl93rdLevelSpells;
	@FXML
	TextField txtlvl103rdLevelSpells;
	@FXML
	TextField txtlvl113rdLevelSpells;
	@FXML
	TextField txtlvl123rdLevelSpells;
	@FXML
	TextField txtlvl133rdLevelSpells;
	@FXML
	TextField txtlvl143rdLevelSpells;
	@FXML
	TextField txtlvl153rdLevelSpells;
	@FXML
	TextField txtlvl163rdLevelSpells;
	@FXML
	TextField txtlvl173rdLevelSpells;
	@FXML
	TextField txtlvl183rdLevelSpells;
	@FXML
	TextField txtlvl193rdLevelSpells;
	@FXML
	TextField txtlvl203rdLevelSpells;

	TextField[] thirdLevelSpells;
	// endregion

	// region 4th Level Spells per Day
	@FXML
	TextField txtlvl14thLevelSpells;
	@FXML
	TextField txtlvl24thLevelSpells;
	@FXML
	TextField txtlvl34thLevelSpells;
	@FXML
	TextField txtlvl44thLevelSpells;
	@FXML
	TextField txtlvl54thLevelSpells;
	@FXML
	TextField txtlvl64thLevelSpells;
	@FXML
	TextField txtlvl74thLevelSpells;
	@FXML
	TextField txtlvl84thLevelSpells;
	@FXML
	TextField txtlvl94thLevelSpells;
	@FXML
	TextField txtlvl104thLevelSpells;
	@FXML
	TextField txtlvl114thLevelSpells;
	@FXML
	TextField txtlvl124thLevelSpells;
	@FXML
	TextField txtlvl134thLevelSpells;
	@FXML
	TextField txtlvl144thLevelSpells;
	@FXML
	TextField txtlvl154thLevelSpells;
	@FXML
	TextField txtlvl164thLevelSpells;
	@FXML
	TextField txtlvl174thLevelSpells;
	@FXML
	TextField txtlvl184thLevelSpells;
	@FXML
	TextField txtlvl194thLevelSpells;
	@FXML
	TextField txtlvl204thLevelSpells;

	TextField[] fourthLevelSpells;
	// endregion

	// region 5th Level Spells per Day
	@FXML
	TextField txtlvl15thLevelSpells;
	@FXML
	TextField txtlvl25thLevelSpells;
	@FXML
	TextField txtlvl35thLevelSpells;
	@FXML
	TextField txtlvl45thLevelSpells;
	@FXML
	TextField txtlvl55thLevelSpells;
	@FXML
	TextField txtlvl65thLevelSpells;
	@FXML
	TextField txtlvl75thLevelSpells;
	@FXML
	TextField txtlvl85thLevelSpells;
	@FXML
	TextField txtlvl95thLevelSpells;
	@FXML
	TextField txtlvl105thLevelSpells;
	@FXML
	TextField txtlvl115thLevelSpells;
	@FXML
	TextField txtlvl125thLevelSpells;
	@FXML
	TextField txtlvl135thLevelSpells;
	@FXML
	TextField txtlvl145thLevelSpells;
	@FXML
	TextField txtlvl155thLevelSpells;
	@FXML
	TextField txtlvl165thLevelSpells;
	@FXML
	TextField txtlvl175thLevelSpells;
	@FXML
	TextField txtlvl185thLevelSpells;
	@FXML
	TextField txtlvl195thLevelSpells;
	@FXML
	TextField txtlvl205thLevelSpells;

	TextField[] fifthLevelSpells;
	// endregion

	// region 6th Level Spells per Day
	@FXML
	TextField txtlvl16thLevelSpells;
	@FXML
	TextField txtlvl26thLevelSpells;
	@FXML
	TextField txtlvl36thLevelSpells;
	@FXML
	TextField txtlvl46thLevelSpells;
	@FXML
	TextField txtlvl56thLevelSpells;
	@FXML
	TextField txtlvl66thLevelSpells;
	@FXML
	TextField txtlvl76thLevelSpells;
	@FXML
	TextField txtlvl86thLevelSpells;
	@FXML
	TextField txtlvl96thLevelSpells;
	@FXML
	TextField txtlvl106thLevelSpells;
	@FXML
	TextField txtlvl116thLevelSpells;
	@FXML
	TextField txtlvl126thLevelSpells;
	@FXML
	TextField txtlvl136thLevelSpells;
	@FXML
	TextField txtlvl146thLevelSpells;
	@FXML
	TextField txtlvl156thLevelSpells;
	@FXML
	TextField txtlvl166thLevelSpells;
	@FXML
	TextField txtlvl176thLevelSpells;
	@FXML
	TextField txtlvl186thLevelSpells;
	@FXML
	TextField txtlvl196thLevelSpells;
	@FXML
	TextField txtlvl206thLevelSpells;

	TextField[] sixthLevelSpells;
	// endregion

	// region 7th Level Spells per Day
	@FXML
	TextField txtlvl17thLevelSpells;
	@FXML
	TextField txtlvl27thLevelSpells;
	@FXML
	TextField txtlvl37thLevelSpells;
	@FXML
	TextField txtlvl47thLevelSpells;
	@FXML
	TextField txtlvl57thLevelSpells;
	@FXML
	TextField txtlvl67thLevelSpells;
	@FXML
	TextField txtlvl77thLevelSpells;
	@FXML
	TextField txtlvl87thLevelSpells;
	@FXML
	TextField txtlvl97thLevelSpells;
	@FXML
	TextField txtlvl107thLevelSpells;
	@FXML
	TextField txtlvl117thLevelSpells;
	@FXML
	TextField txtlvl127thLevelSpells;
	@FXML
	TextField txtlvl137thLevelSpells;
	@FXML
	TextField txtlvl147thLevelSpells;
	@FXML
	TextField txtlvl157thLevelSpells;
	@FXML
	TextField txtlvl167thLevelSpells;
	@FXML
	TextField txtlvl177thLevelSpells;
	@FXML
	TextField txtlvl187thLevelSpells;
	@FXML
	TextField txtlvl197thLevelSpells;
	@FXML
	TextField txtlvl207thLevelSpells;

	TextField[] seventhLevelSpells;
	// endregion

	// region 8th Level Spells per Day
	@FXML
	TextField txtlvl18thLevelSpells;
	@FXML
	TextField txtlvl28thLevelSpells;
	@FXML
	TextField txtlvl38thLevelSpells;
	@FXML
	TextField txtlvl48thLevelSpells;
	@FXML
	TextField txtlvl58thLevelSpells;
	@FXML
	TextField txtlvl68thLevelSpells;
	@FXML
	TextField txtlvl78thLevelSpells;
	@FXML
	TextField txtlvl88thLevelSpells;
	@FXML
	TextField txtlvl98thLevelSpells;
	@FXML
	TextField txtlvl108thLevelSpells;
	@FXML
	TextField txtlvl118thLevelSpells;
	@FXML
	TextField txtlvl128thLevelSpells;
	@FXML
	TextField txtlvl138thLevelSpells;
	@FXML
	TextField txtlvl148thLevelSpells;
	@FXML
	TextField txtlvl158thLevelSpells;
	@FXML
	TextField txtlvl168thLevelSpells;
	@FXML
	TextField txtlvl178thLevelSpells;
	@FXML
	TextField txtlvl188thLevelSpells;
	@FXML
	TextField txtlvl198thLevelSpells;
	@FXML
	TextField txtlvl208thLevelSpells;

	TextField[] eighthLevelSpells;
	// endregion

	// region 9th Level Spells per Day
	@FXML
	TextField txtlvl19thLevelSpells;
	@FXML
	TextField txtlvl29thLevelSpells;
	@FXML
	TextField txtlvl39thLevelSpells;
	@FXML
	TextField txtlvl49thLevelSpells;
	@FXML
	TextField txtlvl59thLevelSpells;
	@FXML
	TextField txtlvl69thLevelSpells;
	@FXML
	TextField txtlvl79thLevelSpells;
	@FXML
	TextField txtlvl89thLevelSpells;
	@FXML
	TextField txtlvl99thLevelSpells;
	@FXML
	TextField txtlvl109thLevelSpells;
	@FXML
	TextField txtlvl119thLevelSpells;
	@FXML
	TextField txtlvl129thLevelSpells;
	@FXML
	TextField txtlvl139thLevelSpells;
	@FXML
	TextField txtlvl149thLevelSpells;
	@FXML
	TextField txtlvl159thLevelSpells;
	@FXML
	TextField txtlvl169thLevelSpells;
	@FXML
	TextField txtlvl179thLevelSpells;
	@FXML
	TextField txtlvl189thLevelSpells;
	@FXML
	TextField txtlvl199thLevelSpells;
	@FXML
	TextField txtlvl209thLevelSpells;

	TextField[] ninthLevelSpells;
	// endregion

	SpellLevelTableRow[] spellLevelTable;

	/**
	 * @return the spellLevelTable
	 */
	public SpellLevelTableRow[] getSpellLevelTable() {
		return spellLevelTable;
	}

	/**
	 * @param spellLevelTable
	 *            the spellLevelTable to set
	 */
	public void setSpellLevelTable(SpellLevelTableRow[] spellLevelTable) {
		//region Fill Text Field Arrays
		zeroLevelSpells = new TextField[] { txtlvl10LevelSpells,txtlvl20LevelSpells,txtlvl30LevelSpells,txtlvl40LevelSpells,
				txtlvl50LevelSpells,txtlvl60LevelSpells,txtlvl70LevelSpells,txtlvl80LevelSpells,txtlvl90LevelSpells,
				txtlvl100LevelSpells,txtlvl110LevelSpells,txtlvl120LevelSpells,txtlvl130LevelSpells,txtlvl140LevelSpells,
				txtlvl150LevelSpells,txtlvl160LevelSpells,txtlvl170LevelSpells,txtlvl180LevelSpells,txtlvl190LevelSpells,txtlvl200LevelSpells 
			};
		firstLevelSpells = new TextField[] { txtlvl11stLevelSpells,txtlvl21stLevelSpells,txtlvl31stLevelSpells,txtlvl41stLevelSpells,
				txtlvl51stLevelSpells,txtlvl61stLevelSpells,txtlvl71stLevelSpells,txtlvl81stLevelSpells,txtlvl91stLevelSpells,
				txtlvl101stLevelSpells,txtlvl111stLevelSpells,txtlvl121stLevelSpells,txtlvl131stLevelSpells,txtlvl141stLevelSpells,
				txtlvl151stLevelSpells,txtlvl161stLevelSpells,txtlvl171stLevelSpells,txtlvl181stLevelSpells,txtlvl191stLevelSpells,txtlvl201stLevelSpells 
			};
		secondLevelSpells = new TextField[] { txtlvl12ndLevelSpells,txtlvl22ndLevelSpells,txtlvl32ndLevelSpells,txtlvl42ndLevelSpells,
				txtlvl52ndLevelSpells,txtlvl62ndLevelSpells,txtlvl72ndLevelSpells,txtlvl82ndLevelSpells,txtlvl92ndLevelSpells,
				txtlvl102ndLevelSpells,txtlvl112ndLevelSpells,txtlvl122ndLevelSpells,txtlvl132ndLevelSpells,txtlvl142ndLevelSpells,
				txtlvl152ndLevelSpells,txtlvl162ndLevelSpells,txtlvl172ndLevelSpells,txtlvl182ndLevelSpells,txtlvl192ndLevelSpells,txtlvl202ndLevelSpells 
			};
		thirdLevelSpells = new TextField[] { txtlvl13rdLevelSpells,txtlvl23rdLevelSpells,txtlvl33rdLevelSpells,txtlvl43rdLevelSpells,
				txtlvl53rdLevelSpells,txtlvl63rdLevelSpells,txtlvl73rdLevelSpells,txtlvl83rdLevelSpells,txtlvl93rdLevelSpells,
				txtlvl103rdLevelSpells,txtlvl113rdLevelSpells,txtlvl123rdLevelSpells,txtlvl133rdLevelSpells,txtlvl143rdLevelSpells,
				txtlvl153rdLevelSpells,txtlvl163rdLevelSpells,txtlvl173rdLevelSpells,txtlvl183rdLevelSpells,txtlvl193rdLevelSpells,txtlvl203rdLevelSpells 
			};
		fourthLevelSpells = new TextField[] { txtlvl14thLevelSpells,txtlvl24thLevelSpells,txtlvl34thLevelSpells,txtlvl44thLevelSpells,
				txtlvl54thLevelSpells,txtlvl64thLevelSpells,txtlvl74thLevelSpells,txtlvl84thLevelSpells,txtlvl94thLevelSpells,
				txtlvl104thLevelSpells,txtlvl114thLevelSpells,txtlvl124thLevelSpells,txtlvl134thLevelSpells,txtlvl144thLevelSpells,
				txtlvl154thLevelSpells,txtlvl164thLevelSpells,txtlvl174thLevelSpells,txtlvl184thLevelSpells,txtlvl194thLevelSpells,txtlvl204thLevelSpells 
			};
		fifthLevelSpells = new TextField[] { txtlvl15thLevelSpells,txtlvl25thLevelSpells,txtlvl35thLevelSpells,txtlvl45thLevelSpells,
				txtlvl55thLevelSpells,txtlvl65thLevelSpells,txtlvl75thLevelSpells,txtlvl85thLevelSpells,txtlvl95thLevelSpells,
				txtlvl105thLevelSpells,txtlvl115thLevelSpells,txtlvl125thLevelSpells,txtlvl135thLevelSpells,txtlvl145thLevelSpells,
				txtlvl155thLevelSpells,txtlvl165thLevelSpells,txtlvl175thLevelSpells,txtlvl185thLevelSpells,txtlvl195thLevelSpells,txtlvl205thLevelSpells 
			};
		sixthLevelSpells = new TextField[] { txtlvl16thLevelSpells,txtlvl26thLevelSpells,txtlvl36thLevelSpells,txtlvl46thLevelSpells,
				txtlvl56thLevelSpells,txtlvl66thLevelSpells,txtlvl76thLevelSpells,txtlvl86thLevelSpells,txtlvl96thLevelSpells,
				txtlvl106thLevelSpells,txtlvl116thLevelSpells,txtlvl126thLevelSpells,txtlvl136thLevelSpells,txtlvl146thLevelSpells,
				txtlvl156thLevelSpells,txtlvl166thLevelSpells,txtlvl176thLevelSpells,txtlvl186thLevelSpells,txtlvl196thLevelSpells,txtlvl206thLevelSpells 
			};
		seventhLevelSpells = new TextField[] { txtlvl17thLevelSpells,txtlvl27thLevelSpells,txtlvl37thLevelSpells,txtlvl47thLevelSpells,
				txtlvl57thLevelSpells,txtlvl67thLevelSpells,txtlvl77thLevelSpells,txtlvl87thLevelSpells,txtlvl97thLevelSpells,
				txtlvl107thLevelSpells,txtlvl117thLevelSpells,txtlvl127thLevelSpells,txtlvl137thLevelSpells,txtlvl147thLevelSpells,
				txtlvl157thLevelSpells,txtlvl167thLevelSpells,txtlvl177thLevelSpells,txtlvl187thLevelSpells,txtlvl197thLevelSpells,txtlvl207thLevelSpells 
			};
		eighthLevelSpells = new TextField[] { txtlvl18thLevelSpells,txtlvl28thLevelSpells,txtlvl38thLevelSpells,txtlvl48thLevelSpells,
				txtlvl58thLevelSpells,txtlvl68thLevelSpells,txtlvl78thLevelSpells,txtlvl88thLevelSpells,txtlvl98thLevelSpells,
				txtlvl108thLevelSpells,txtlvl118thLevelSpells,txtlvl128thLevelSpells,txtlvl138thLevelSpells,txtlvl148thLevelSpells,
				txtlvl158thLevelSpells,txtlvl168thLevelSpells,txtlvl178thLevelSpells,txtlvl188thLevelSpells,txtlvl198thLevelSpells,txtlvl208thLevelSpells 
			};
		ninthLevelSpells = new TextField[] { txtlvl19thLevelSpells,txtlvl29thLevelSpells,txtlvl39thLevelSpells,txtlvl49thLevelSpells,
				txtlvl59thLevelSpells,txtlvl69thLevelSpells,txtlvl79thLevelSpells,txtlvl89thLevelSpells,txtlvl99thLevelSpells,
				txtlvl109thLevelSpells,txtlvl119thLevelSpells,txtlvl129thLevelSpells,txtlvl139thLevelSpells,txtlvl149thLevelSpells,
				txtlvl159thLevelSpells,txtlvl169thLevelSpells,txtlvl179thLevelSpells,txtlvl189thLevelSpells,txtlvl199thLevelSpells,txtlvl209thLevelSpells 
			};
		//endregion
		
		this.spellLevelTable = spellLevelTable;
		for (int i = 0; i < spellLevelTable.length; i++) {
			zeroLevelSpells[i].setText(spellLevelTable[i].getSPD()[0].get());
			firstLevelSpells[i].setText(spellLevelTable[i].getSPD()[1].get());
			secondLevelSpells[i].setText(spellLevelTable[i].getSPD()[2].get());
			thirdLevelSpells[i].setText(spellLevelTable[i].getSPD()[3].get());
			fourthLevelSpells[i].setText(spellLevelTable[i].getSPD()[4].get());
			fifthLevelSpells[i].setText(spellLevelTable[i].getSPD()[5].get());
			sixthLevelSpells[i].setText(spellLevelTable[i].getSPD()[6].get());
			seventhLevelSpells[i].setText(spellLevelTable[i].getSPD()[7].get());
			eighthLevelSpells[i].setText(spellLevelTable[i].getSPD()[8].get());
			ninthLevelSpells[i].setText(spellLevelTable[i].getSPD()[9].get());
		}
	}

	/**
	 * a handle method that saves changes upon pressing the Ok button
	 */
	@Override
	public void handleOkay(ActionEvent event) {
		for (int i = 0; i < spellLevelTable.length; i++) {
			spellLevelTable[i].getSPD()[0].set(zeroLevelSpells[i].getText());
			spellLevelTable[i].getSPD()[1].set(firstLevelSpells[i].getText());
			spellLevelTable[i].getSPD()[2].set(secondLevelSpells[i].getText());
			spellLevelTable[i].getSPD()[3].set(thirdLevelSpells[i].getText());
			spellLevelTable[i].getSPD()[4].set(fourthLevelSpells[i].getText());
			spellLevelTable[i].getSPD()[5].set(fifthLevelSpells[i].getText());
			spellLevelTable[i].getSPD()[6].set(sixthLevelSpells[i].getText());
			spellLevelTable[i].getSPD()[7].set(seventhLevelSpells[i].getText());
			spellLevelTable[i].getSPD()[8].set(eighthLevelSpells[i].getText());
			spellLevelTable[i].getSPD()[9].set(ninthLevelSpells[i].getText());
		}
		okayClicked = true;
		this.getDialogStage().close();
	}
}

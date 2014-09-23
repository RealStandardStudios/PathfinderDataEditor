package view.partials.dialogs;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jefXif.DialogController;
import pathfinder.data.DiceType;
import pathfinder.data.Character.Alignment;
import pathfinder.data.Classes.Class;

/**
 * A controller class for the class description edit dialog
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class ClassDescriptionsEditDialogController extends DialogController {
	
	@FXML
	TextField txtName;
	
	@FXML
	TextArea txtaRole;
	
	@FXML
	ComboBox<DiceType> cboHitDice;
	
	@FXML
	TextArea txtaClassSkills;
	
	@FXML
	TextField txtSkillRanksPerLevel;
	
	@FXML
	TextArea txtaWeaponProficiency;
	
	@FXML
	TextArea txtaArmorProficiency;
	
	@FXML
	TextField txtStartingWealth;
	
	//region alignment grid
	@FXML
	CheckBox cbLawfulGood;
	@FXML
	CheckBox cbNeutralGood;
	@FXML
	CheckBox cbChaoticGood;
	@FXML
	CheckBox cbLawfulNeutral;
	@FXML
	CheckBox cbTrueNeutral;
	@FXML
	CheckBox cbChaoticNeutral;
	@FXML
	CheckBox cbLawfulEvil;
	@FXML
	CheckBox cbNeutralEvil;
	@FXML
	CheckBox cbChaoticEvil;
	//endregion
	
	Class pClass;
	
	ObservableList<DiceType> hitDice;
	
	/**
	 * @return the pClass
	 */
	public Class getpClass() {
		return pClass;
	}

	/**
	 * @param pClass the pClass to set
	 */
	public void setpClass(Class pClass) {
		this.pClass = pClass;
		cboHitDice.setItems(hitDice);
		txtName.setText(pClass.getName());
		txtaRole.setText(pClass.getRole());
		txtaClassSkills.setText(pClass.getClassSkillsToString());
		txtSkillRanksPerLevel.setText(Integer.toString(pClass.getSkillRanksPerLevel()));
		txtaWeaponProficiency.setText(pClass.getWeaponProfsToString());
		txtaArmorProficiency.setText(pClass.getArmorProfsToString());
		txtStartingWealth.setText(Integer.toString(pClass.getStartingWealthD6()));
		cboHitDice.setValue(pClass.getHitDice());
		if(pClass.getRequireAlignments()!=null) {
			for (Alignment alignment : pClass.getRequireAlignments()) {
				switch (alignment) {
				case ChaoticEvil:
					cbChaoticEvil.setSelected(true);
					break;
				case ChaoticNeutral:
					cbChaoticNeutral.setSelected(true);
					break;
				case ChaoticGood:
					cbChaoticGood.setSelected(true);
					break;
				case LawfulEvil:
					cbLawfulEvil.setSelected(true);
					break;
				case LawfulGood:
					cbLawfulGood.setSelected(true);
					break;
				case LawfulNeutral:
					cbLawfulNeutral.setSelected(true);
					break;
				case Neutral:
					cbTrueNeutral.setSelected(true);
					break;
				case NeutralEvil:
					cbNeutralEvil.setSelected(true);
					break;
				case NeutralGood:
					cbNeutralGood.setSelected(true);
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * a handle method that saves changes upon pressing the Ok button
	 */
	@FXML
	public void handleOkay(ActionEvent event) {
		pClass.setSkillRanksPerLevel(Integer.parseInt(txtSkillRanksPerLevel.getText()));
		pClass.setRole(txtaRole.getText());
		pClass.setName(txtName.getText());
		pClass.setSkillRanksPerLevel(Integer.parseInt(txtSkillRanksPerLevel.getText()));
		pClass.setStartingWealthD6(Integer.parseInt(txtStartingWealth.getText()));
		pClass.setArmorProficiencies(txtaArmorProficiency.getText().split(","));
		pClass.setWeaponProficiencies(txtaWeaponProficiency.getText().split(","));
		pClass.setHitDice(cboHitDice.getValue());
		ArrayList<Alignment> alignments = new ArrayList<Alignment>();
		if(cbChaoticEvil.selectedProperty().get()) alignments.add(Alignment.ChaoticEvil);
		if(cbChaoticGood.selectedProperty().get()) alignments.add(Alignment.ChaoticGood);
		if(cbChaoticNeutral.selectedProperty().get()) alignments.add(Alignment.ChaoticNeutral);
		if(cbLawfulEvil.selectedProperty().get()) alignments.add(Alignment.LawfulEvil);
		if(cbLawfulGood.selectedProperty().get()) alignments.add(Alignment.LawfulGood);
		if(cbLawfulNeutral.selectedProperty().get()) alignments.add(Alignment.LawfulNeutral);
		if(cbNeutralEvil.selectedProperty().get()) alignments.add(Alignment.NeutralEvil);
		if(cbNeutralGood.selectedProperty().get()) alignments.add(Alignment.NeutralGood);
		if(cbTrueNeutral.selectedProperty().get()) alignments.add(Alignment.Neutral);
		pClass.setRequireAlignments(alignments.toArray(new Alignment[alignments.size()]));
		okayClicked = true;
		this.getDialogStage().close();
	}
	
	/**
	 * the class constructor
	 */
	public ClassDescriptionsEditDialogController() {
		hitDice = FXCollections.observableArrayList(new DiceType[]{
			DiceType.d6, DiceType.d8, DiceType.d10, DiceType.d12
		});
	}
}

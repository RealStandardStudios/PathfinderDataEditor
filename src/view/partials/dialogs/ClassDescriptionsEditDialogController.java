package view.partials.dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jefXif.DialogController;
import pathfinder.data.DiceType;
import pathfinder.data.Classes.Class;

public class ClassDescriptionsEditDialogController extends DialogController {
	
	Boolean okayClicked = false;
	
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
	}

	@FXML
	private void handleCancel(ActionEvent event) {
		getDialogStage().close();
	}

	@FXML
	private void handleOkay(ActionEvent event) {
		pClass.setSkillRanksPerLevel(Integer.parseInt(txtSkillRanksPerLevel.getText()));
		pClass.setRole(txtaRole.getText());
		pClass.setName(txtName.getText());
		pClass.setSkillRanksPerLevel(Integer.parseInt(txtSkillRanksPerLevel.getText()));
		pClass.setStartingWealthD6(Integer.parseInt(txtStartingWealth.getText()));
		pClass.setArmorProficiencies(txtaArmorProficiency.getText().split(","));
		pClass.setWeaponProficiencies(txtaWeaponProficiency.getText().split(","));
		pClass.setHitDice(cboHitDice.getValue());
		okayClicked = true;
		this.getDialogStage().close();
	}
	
	
	public ClassDescriptionsEditDialogController() {
		hitDice = FXCollections.observableArrayList(new DiceType[]{
			DiceType.d6, DiceType.d8, DiceType.d10, DiceType.d12
		});
	}

	public boolean isOkayClicked() {
		return this.okayClicked;
	}

}

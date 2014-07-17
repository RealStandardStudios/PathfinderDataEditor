package view;

import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import window.Interface;

/**
 * @author Real Standard Studios - Matthew Meehan
 *
 */
public class RootLayoutController {
	private Interface ui;
	
	private HashMap<String, Node> windowPartials;
	
	@FXML
	private BorderPane rootLayout;
	
	@FXML
	private void handleRaceAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Races"));
	}
	@FXML
	private void handleFeatsAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Feats"));
	}
	@FXML
	private void handleSpellsAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Spells"));
	}
	@FXML
	private void handleClassesAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Classes"));
	}
	@FXML
	private void handleItemsAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Items"));
	}
	
	private void SwapWindow(Node node) {
		rootLayout.setCenter(node);
	}

	public Interface getInterface() {
		return ui;
	}

	public void setInterface(Interface ui) {
		this.ui = ui;
	}
	
	public void setWindowPartials(HashMap<String, Node>windowPartials) {
		this.windowPartials = windowPartials;
	}
}

package view;

import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import jefXif.WindowController;
import window.Interface;

/**
 * @author Real Standard Studios - Matthew Meehan
 *
 */
public class RootLayoutController {
	private Interface ui;
	
	private HashMap<String, WindowController> windowPartials;
	
	@FXML
	private BorderPane rootLayout;
	
	@FXML
	private void handleRaceAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Races").getNode());
	}
	@FXML
	private void handleFeatsAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Feats").getNode());
	}
	@FXML
	private void handleSpellsAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Spells").getNode());
	}
	@FXML
	private void handleClassesAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Classes").getNode());
	}
	@FXML
	private void handleItemsAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Items").getNode());
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
	
	public void setWindowPartials(HashMap<String, WindowController>windowPartials) {
		this.windowPartials = windowPartials;
	}
	
	public HashMap<String,WindowController> getWindowPartials() {
		return this.windowPartials;
	}
}

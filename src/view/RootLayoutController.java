package view;

import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import jefXif.WindowController;
import window.Interface;

/**
 * The root controller for the layout of the data editor
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class RootLayoutController {
	private Interface ui;
	
	private HashMap<String, WindowController> windowPartials;
	
	@FXML
	private BorderPane rootLayout;
	
	/**
	 * a handle method to access the Races data editor
	 * 
	 * @param event
	 */
	@FXML
	private void handleRaceAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Races").getNode());
	}
	
	/**
	 * a handle method to access the Feats data editor
	 * 
	 * @param event
	 */
	@FXML
	private void handleFeatsAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Feats").getNode());
	}
	
	/**
	 * a handle method to access the Spells data editor
	 * 
	 * @param event
	 */
	@FXML
	private void handleSpellsAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Spells").getNode());
	}
	
	/**
	 * a handle method to access the Clases data editor
	 * 
	 * @param event
	 */
	@FXML
	private void handleClassesAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Classes").getNode());
	}
	
	/**
	 * a handle method to access the Items data editor
	 * 
	 * @param event
	 */
	@FXML
	private void handleItemsAction(ActionEvent event) {
		SwapWindow(windowPartials.get("Items").getNode());
	}
	
	/**
	 * Takes in a node and puts it in the center
	 * 
	 * @param node
	 */
	private void SwapWindow(Node node) {
		rootLayout.setCenter(node);
	}

	/**
	 * @returns the ui
	 */
	public Interface getInterface() {
		return ui;
	}

	/**
	 * @param ui
	 */
	public void setInterface(Interface ui) {
		this.ui = ui;
	}
	
	/**
	 * @param windowPartials
	 */
	public void setWindowPartials(HashMap<String, WindowController>windowPartials) {
		this.windowPartials = windowPartials;
	}
	
	/**
	 * @returns a hashmap made up of window controllers
	 */
	public HashMap<String,WindowController> getWindowPartials() {
		return this.windowPartials;
	}
}

package view;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import jefXif.MainPartialController;
import window.Interface;

/**
 * The root controller for the layout of the data editor
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class RootLayoutController {
	private Interface ui;
	
	private HashMap<String, MainPartialController> windowPartials;
	
	@FXML
	MenuItem menuItemSaveItems;
	
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
	
	@FXML
	private void handleSaveItems(ActionEvent event) {
		MainPartialController itemController = windowPartials.get("Items");
		try {
			itemController.saveDataToFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleOpenItems(ActionEvent event) {
		MainPartialController itemController = windowPartials.get("Items");
		try {
			itemController.loadDataFromFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleOpenFeats(ActionEvent event) {
		MainPartialController featsController = windowPartials.get("Feats");
		try {
			featsController.loadDataFromFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleSaveFeats(ActionEvent event) {
		MainPartialController featsController = windowPartials.get("Feats");
		try {
			featsController.saveDataToFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleOpenSpells(ActionEvent event) {
		MainPartialController spellsController = windowPartials.get("Spells");
		try {
			spellsController.loadDataFromFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleSaveSpells(ActionEvent event) {
		MainPartialController spellsController = windowPartials.get("Spells");
		try {
			spellsController.saveDataToFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleOpenAll(ActionEvent event) {
		MainPartialController spellsController = windowPartials.get("Spells");
		MainPartialController itemsController = windowPartials.get("Items");
		MainPartialController featsController = windowPartials.get("Feats");
		try {
			spellsController.loadDataFromFile(ui.getProgramFilePath());
			itemsController.loadDataFromFile(ui.getProgramFilePath());
			featsController.loadDataFromFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleSaveAll(ActionEvent event) {
		MainPartialController spellsController = windowPartials.get("Spells");
		MainPartialController itemsController = windowPartials.get("Items");
		MainPartialController featsController = windowPartials.get("Feats");
		try {
			spellsController.saveDataToFile(ui.getProgramFilePath());
			itemsController.saveDataToFile(ui.getProgramFilePath());
			featsController.saveDataToFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void setWindowPartials(HashMap<String, MainPartialController>windowPartials) {
		this.windowPartials = windowPartials;
	}
	
	/**
	 * @returns a hashmap made up of window controllers
	 */
	public HashMap<String,MainPartialController> getWindowPartials() {
		return this.windowPartials;
	}
}

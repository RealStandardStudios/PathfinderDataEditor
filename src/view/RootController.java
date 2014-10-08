package view;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import jefXif.view.Gui;
import jefXif.view.RootLayoutController;
import jefXif.view.partial.MainPartialController;
import window.Interface;

/**
 * The root controller for the layout of the data editor
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class RootController extends RootLayoutController{
	
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
	
	/**
	 * a handle method to save changes to races
	 * @param event
	 */
	@FXML 
	private void handleSaveRaces(ActionEvent event) {
		MainPartialController racesController = windowPartials.get("Races");
		try{
			racesController.saveDataToFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * a handle method to load races
	 * @param event
	 */
	@FXML
	private void handleOpenRaces(ActionEvent event) {
		MainPartialController racesController = windowPartials.get("Races");
		try {
			racesController.loadDataFromFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * a handle method to save changes to items
	 * @param event
	 */
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
	
	/**
	 * a handle method to load items
	 * @param event
	 */
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
	
	/**
	 * a handle methid to load feats
	 * @param event
	 */
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
	
	/**
	 * a handle method to save changes to feats
	 * @param event
	 */
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
	
	/**
	 * a handle method to load spells
	 * @param event
	 */
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
	
	/**
	 * a handle method to save changes to classes
	 * @param event
	 */
	@FXML
	private void handleSaveClasses(ActionEvent event) {
		MainPartialController classesController = windowPartials.get("Classes");
		try {
			classesController.saveDataToFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * a handle method to load classes
	 * @param event
	 */
	@FXML
	private void handleOpenClasses(ActionEvent event) {
		MainPartialController classesController = windowPartials.get("Classes");
		try {
			classesController.loadDataFromFile(ui.getProgramFilePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * a handle method to save changes to spells
	 * @param event
	 */
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
	
	/**
	 * a handle method to load all the things
	 * @param event
	 */
	@FXML
	private void handleOpenAll(ActionEvent event) {
		try {
			for (MainPartialController controller : windowPartials.values()) {
				controller.loadDataFromFile(ui.getProgramFilePath());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * a handle method to save changes
	 * @param event
	 */
	@FXML
	private void handleSaveAll(ActionEvent event) {
		try {
			for (MainPartialController controller : windowPartials.values()) {
				controller.loadDataFromFile(ui.getProgramFilePath());
			}
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

	@Override
	public void setInterface(Gui ui) {
		this.ui = (Interface) ui;
	}
}

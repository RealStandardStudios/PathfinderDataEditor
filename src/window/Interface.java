package window;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jefXif.Gui;
import jefXif.MainPartialController;
import jefXif.WindowController;
import jefXif.interfaces.DataLoader;
import view.RootLayoutController;

import com.sun.istack.internal.logging.Logger;

/**
 * Loads and Initializes the main
 * program
 * @author Real Standard Studios - Matthew Meehan 
 */
public class Interface extends Gui {
	private RootLayoutController rootLayoutController;

	/**
	 * construcftor for the interface
	 * @param primaryStage
	 */
	public Interface(Stage primaryStage) {
		super(primaryStage);
		setProgramFilePath(new File(this.getClass().getResource("").toString()+"../../../"));
	}

	/**
	 * initailises the root layout
	 */
	@Override
	public void initRootLayout() {
		try {
			// Load root layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource(
					"../view/RootLayout.fxml"));
			setRootLayout((BorderPane) loader.load());

			// Show the scene containing the root layout
			Scene scene = new Scene(getRootLayout());
			getPrimaryStage().setScene(scene);

			// Give the controller access to the main app.
			rootLayoutController = loader.getController();
			rootLayoutController.setInterface(this);

			getPrimaryStage().show();
		} catch (IOException e) {
			Logger.getLogger(this.getClass()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * this method loads all the partials
	 */
	@Override
	public void loadPartials() throws IOException {
		HashMap<String, MainPartialController> windowPartials = new HashMap<>();
		String[] Windows = { "Classes", "Feats", "Items", "Races", "Spells" };
		for (String string : Windows) {
			windowPartials.put(string, (MainPartialController) loadPartial(string, this));
		}
		rootLayoutController.setWindowPartials(windowPartials);
	}

	/**
	 * this is the initialiser for the interface
	 */
	@Override
	public void initialize() {
		this.getPrimaryStage().setTitle("Data Editor");
		this.getPrimaryStage().getIcons()
				.add(new Image("file:resources/images/Icon.png"));

		initRootLayout();

		try {
			loadPartials();
		} catch (IOException e) {
			Logger.getLogger(this.getClass()).log(Level.SEVERE, null, e);
		}
		loadData();
	}

	/**
	 * this method loads the data
	 */
	@Override
	public void loadData() {
		// this is where all the views will load the data from their files
		for (WindowController controller : rootLayoutController.getWindowPartials().values()) {
			// If the interface DataLoader is implemented on the current controller
			if(DataLoader.class.isAssignableFrom(controller.getClass())) {
				DataLoader loader = (DataLoader) controller;
				loader.loadData(new File(this.getClass().getResource("").toString()));
			}	
		}
	}
}

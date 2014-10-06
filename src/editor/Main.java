package editor;

import javafx.application.Application;
import javafx.stage.Stage;
import window.Interface;

/**
 * The Main class for the Pathfinder Data Editor
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class Main extends Application {

	/**
	 * Initialises the GUI interface
	 */
	@Override
	public void start(Stage primaryStage) {
		Interface gui = new Interface(primaryStage);
		gui.initialize();
	}

	/**
	 * launches the data editor
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

package editor;

import javafx.application.Application;
import javafx.stage.Stage;
import window.Interface;

/**
 * @author Real Standard Studios - Matthew Meehan
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Interface gui = new Interface(primaryStage);
		gui.initialize();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

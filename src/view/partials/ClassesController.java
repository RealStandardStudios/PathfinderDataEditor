package view.partials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jefXif.WindowController;

import pathfinder.data.Classes.Class;

public class ClassesController extends WindowController{
	
	@FXML
	private TableView<Class> tableClass;
	
	@FXML
	private TableColumn<Class, String> columnClassName;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		readSummary();
	}
	
	/**
	 * Reads class summary data
	 */
	private void readSummary() {
		String[] heading;
		Scanner reader;
		try {
			reader = new Scanner(new FileReader("data/Classes - Class summaries.tsv"));
			String output = reader.nextLine();
			heading = output.split("\t");
			while(reader.hasNextLine()) {
				output = reader.nextLine();
				String[] line = output.split("\t");
				for (int i = 0; i < line.length; i++) {
					System.out.printf("%s: %s \n",heading[i],line[i]); //<heading>: <content>
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(ClassesController.class.toString()).log(Level.SEVERE, null, e);
		}
	}

}

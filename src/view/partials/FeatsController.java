package view.partials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jefXif.DataLoader;
import jefXif.WindowController;

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Effects.*;
import pathfinder.data.Feats.Feat;
import view.partials.dialogs.FeatEditDialogController;

import com.sun.istack.internal.logging.Logger;

/**
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class FeatsController extends WindowController implements DataLoader {

	@FXML
	TableView<Feat> tableFeats;
	@FXML
	Button btnEdit;
	@FXML
	TableColumn<Feat, String> featNameColumn;
	@FXML
	TableColumn<Feat, String> prerequisiteColumn;
	@FXML
	TableColumn<Feat, String> benifitColumn;
	@FXML
	TableColumn<Feat, String> effectColumn;

	ObservableList<Feat> feats = FXCollections.observableArrayList();

	public FeatsController() {

	}

	@Override
	public void initialize() {
		tableFeats.setItems(feats);
		featNameColumn.setCellValueFactory(cellData -> cellData.getValue()
				.nameProperty());
		prerequisiteColumn.setCellValueFactory(cellData -> ((Feat) cellData
				.getValue().prerequisitePropety().getValue()).nameProperty());
		benifitColumn.setCellValueFactory(cellData -> cellData.getValue()
				.benifitProperty());
		effectColumn.setCellValueFactory(cellData -> cellData.getValue()
				.effectProperty().getValue().NameProperty());
	}

	@FXML
	public void handleEditPerson() {
		Feat selectedFeat = tableFeats.getSelectionModel().getSelectedItem();
		if (selectedFeat != null) {
			boolean okClicked = showEditFeatDialog(selectedFeat);
		} else {
			Dialogs.create().title("No Selection").masthead("No Feat selected")
					.message("Select a Feat from the table.").showWarning();
		}
	}

	private boolean showEditFeatDialog(Feat feat) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource(
					"dialogs/FeatEditDialog.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Feat");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getInterface().getPrimaryStage());
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);

			FeatEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setFeat(feat);
			controller.setPrerequisites(feats);
			dialogStage.showAndWait();
			return controller.isOkayClicked();
		} catch (IOException e) {
			Logger.getLogger(getClass()).log(Level.SEVERE, e.getMessage());
			return false;
		}
	}

	private void readFeatData() {
		String fileLoc = "data/Feats - Feats.tsv";
		try {
			Scanner scn = new Scanner(new FileReader(fileLoc));
			String line = scn.nextLine();
			while (scn.hasNextLine()) {
				line = scn.nextLine();
				if (!line.equals(null) && !line.equals("")&&!line.equals("\t\t\t\t")) {
					String[] parts = line.split("\t");
					// System.out.println(string);
					Effect effect = null;
					try {
						effect = (Effect) Class.forName(
								"pathfinder.data.Effects." + parts[4])
								.newInstance();
					} catch (ClassNotFoundException e) {
						try {
							effect = (Effect) Class.forName(
									"pathfinder.data.Effects.Actions."
											+ parts[4]).newInstance();
						} catch (InstantiationException
								| IllegalAccessException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							try {
								effect = (Effect) Class.forName(
										"pathfinder.data.Effects.NonValued."
												+ parts[4]).newInstance();
							} catch (InstantiationException
									| IllegalAccessException
									| ClassNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
					} catch (InstantiationException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					feats.add(new Feat(parts[0], new Feat(), parts[3], effect));
				}
				// System.out.println();
			}
			scn.close();
		} catch (FileNotFoundException e) {
			Dialogs.create().title("File not Found")
					.masthead("No File was Found")
					.message(e.getMessage() + "\nNo file at " + fileLoc);
		}
	}

	@Override
	public void loadData() {
		// This is where it will read in the data from the files saved through
		// the program or use the tsvs as a fallback
		readFeatData();
	}

}

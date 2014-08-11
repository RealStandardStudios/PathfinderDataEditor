package view.partials;

import java.io.IOException;
import java.util.logging.Level;

import org.controlsfx.dialog.Dialogs;

import com.sun.istack.internal.logging.Logger;

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
import jefXif.WindowController;
import pathfinder.data.Effects.Effect;
import pathfinder.data.Feats.Feat;
import view.partials.dialogs.FeatEditDialogController;

/**
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class FeatsController extends WindowController {

	@FXML
	TableView<Feat> tableFeats;
	@FXML
	Button btnEdit;
	@FXML
	TableColumn<Feat, String> featNameColumn;
	@FXML
	TableColumn<Feat, Feat> prerequisiteColumn;
	@FXML
	TableColumn<Feat, String> benifitColumn;
	@FXML
	TableColumn<Feat, Effect> effectColumn;

	ObservableList<Feat> feats = FXCollections.observableArrayList();

	public FeatsController() {
		feats.add(new Feat("Test Feat", new Feat(), "Get's tested"));
	}

	@Override
	public void initialize() {
		tableFeats.setItems(feats);
		featNameColumn.setCellValueFactory(cellData -> cellData.getValue()
				.nameProperty());
		prerequisiteColumn.setCellValueFactory(cellData -> cellData.getValue()
				.prerequisitePropety());
		benifitColumn.setCellValueFactory(cellData -> cellData.getValue()
				.benifitProperty());
		effectColumn.setCellValueFactory(cellData -> cellData.getValue()
				.effectProperty());
	}

	@FXML
	public void handleEditPerson() {
		Feat selectedFeat = tableFeats.getSelectionModel().getSelectedItem();
		if(selectedFeat!=null) {
			boolean okClicked = showEditFeatDialog(selectedFeat);
		}
		else {
			Dialogs.create().title("No Selection").masthead("No Feat selected").message("Select a Feat from the table.").showWarning();
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
			dialogStage.showAndWait();
			return controller.isOkayClicked();
		} catch (IOException e) {
			Logger.getLogger(getClass()).log(Level.SEVERE, e.getMessage());
			return false;
		}
	}

}

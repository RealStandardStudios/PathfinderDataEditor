package view.partials;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import jefXif.DataLoader;
import jefXif.Gui;
import jefXif.PartialLoader;
import jefXif.WindowController;
import pathfinder.data.Items.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ItemsController extends WindowController implements PartialLoader, DataLoader{

	private HashMap<String, WindowController> partials;
	
	@FXML
	AnchorPane ItemsPartialPane;
	
	@FXML
	TableView<Item> itemTable;
	
	@FXML
	TableColumn<Item, String> nameColumn;
	
	@FXML
	public void handleGoodsServices(ActionEvent event) {
		SwapPartial(partials.get("BasicGoods").getNode());
	}
	
	@FXML
	public void handleBasicArmor(ActionEvent event) {
		SwapPartial(partials.get("BasicArmor").getNode());
	}
	
	private void SwapPartial(Node node) {
		ItemsPartialPane.getChildren().set(0, node);	
	}
	
	public ItemsController() {
		partials = new HashMap<>();
	}
	@Override
	public void initialize() {
		try {
			String[] partials = {"BasicGoods","BasicArmor"};
			for (String string : partials) {
				this.partials.put(string, loadPartial(string, this.getInterface()));
			}
		} catch (IOException e) {
			Logger.getLogger(getClass()).log(Level.SEVERE, e.getMessage());
		}
		
	}
	
	@Override
	public WindowController loadPartial(String name, Gui ui) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("itemPartials/" + name + "Partial.fxml"));
		
		/*AnchorPane partial = */
		Node node = loader.load();
		WindowController controller = loader.getController();// YUDODIS
		controller.setNode(node);
		return controller;
	}

	@Override
	public void loadData() {
		// Josh this is where you will read the data from the file that is saved through the program or fall back to reading in the tsv files if it fails		
	}
}

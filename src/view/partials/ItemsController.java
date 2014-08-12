package view.partials;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import jefXif.DataLoader;
import jefXif.Gui;
import jefXif.PartialLoader;
import jefXif.WindowController;

public class ItemsController extends WindowController implements PartialLoader, DataLoader{

	private HashMap<String, WindowController> partials;
	
	@FXML
	AnchorPane ItemsPartialPane;
	
	@FXML
	public void handleGoodsServices(ActionEvent event) {
		SwapPartial(partials.get("BasicGoods").getNode());
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
			String[] partials = {"BasicGoods"};
			for (String string : partials) {
				this.partials.put(string, loadPartial(string, this.getInterface()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public WindowController loadPartial(String name, Gui ui) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("itemPartials/" + name + "Partial.fxml"));
		
		/*AnchorPane partial = */
		loader.load();
		WindowController controller = loader.getController();
		return controller;
	}

	@Override
	public void loadData() {
		// Josh this is where you will read the data from the file that is saved through the program or fall back to reading in the tsv files if it fails		
	}

}

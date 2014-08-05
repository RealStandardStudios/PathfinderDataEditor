package view.partials;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import jefXif.LoadablePartials;
import jefXif.Strings;
import jefXif.WindowController;

public class ItemsController extends WindowController implements LoadablePartials{

	private HashMap<String, Node> partials;
	
	@FXML
	AnchorPane ItemsPartialPane;
	
	@FXML
	public void handleGoodsServices(ActionEvent event) {
		SwapPartial(partials.get("BasicGoods"));
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
				this.partials.put(string, loadPartial(string));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Node loadPartial(String name) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(
				Strings.FileLoc+ "itemPartials/" + name + "Partial.fxml"));
		
		AnchorPane partial = loader.load();
		return partial;
	}

}

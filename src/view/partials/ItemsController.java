package view.partials;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import jefXif.LoadablePartials;
import jefXif.Strings;
import jefXif.WindowController;

public class ItemsController extends WindowController implements LoadablePartials{

	@Override
	public void initialize() {
		try {
			loadPartial("BasicGoods");
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

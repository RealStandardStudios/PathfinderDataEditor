/**
 * 
 */
package view.partials.itemPartials;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import jefXif.WindowController;
import pathfinder.data.Items.Item;

/**
 * @author Joshua Boydo
 *
 */
public abstract class ItemPartialController extends WindowController {
	
	public abstract void setItemDetails(Item item);

	public abstract void inView(ObservableList<Item> items);
}

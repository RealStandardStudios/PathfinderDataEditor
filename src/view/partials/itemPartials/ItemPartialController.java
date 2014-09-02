/**
 * 
 */
package view.partials.itemPartials;

import javafx.collections.ObservableList;
import jefXif.WindowController;
import pathfinder.data.Items.Item;

/**
 * @author Joshua Boydo
 *
 */
public abstract class ItemPartialController extends WindowController {
	
	public abstract void setItemDetails(Item item);

	public abstract void inView(ObservableList<Item> items);
	
	public abstract boolean showItemEditDialog(Item item);
}

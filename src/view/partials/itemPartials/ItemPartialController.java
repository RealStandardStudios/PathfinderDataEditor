/**
 * 
 */
package view.partials.itemPartials;

import javafx.collections.ObservableList;
import jefXif.view.WindowController;
import pathfinder.data.Items.Item;

/**
 * the base controller for item partials
 * 
 * @author Joshua Boyd
 */
public abstract class ItemPartialController extends WindowController {
	
	/**
	 * this method sets the Item details
	 */
	public abstract void setItemDetails(Item item);

	/**
	 * this method populates the partial
	 */
	public abstract void inView(ObservableList<Item> items);
	
	/**
	 * a handle method that allows for editing
	 */
	public abstract boolean showItemEditDialog(Item item);
}

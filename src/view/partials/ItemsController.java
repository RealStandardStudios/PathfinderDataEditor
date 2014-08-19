package view.partials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;

import org.controlsfx.dialog.Dialogs;

import com.sun.istack.internal.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import jefXif.DataLoader;
import jefXif.Gui;
import jefXif.PartialLoader;
import jefXif.WindowController;
import pathfinder.data.Feats.Feat;
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
	
	ObservableList<Armor> armors = FXCollections.observableArrayList();
	
	@FXML
	public void handleGoodsServices(ActionEvent event) {
		SwapPartial(partials.get("BasicGoods").getNode());
	}
	
	@FXML
	public void handleBasicArmor(ActionEvent event) {
		SwapPartial(partials.get("BasicArmor").getNode());
	}
	
	@FXML
	public void handleBasicWeapon(ActionEvent event)
	{
		SwapPartial(partials.get("BasicWeapon").getNode());
	}
	
	@FXML
	public void handleMagicArmor(ActionEvent event)
	{
		SwapPartial(partials.get("MagicArmor").getNode());
	}
	
	@FXML
	public void handleMagicWeapon(ActionEvent event)
	{
		SwapPartial(partials.get("MagicWeapon").getNode());
	}
	
	@FXML
	public void handleMagicRing(ActionEvent event)
	{
		SwapPartial(partials.get("MagicRing").getNode());
	}
	
	@FXML
	public void handleMagicRod(ActionEvent event)
	{
		SwapPartial(partials.get("MagicRod").getNode());
	}
	
	@FXML
	public void handleMagicStave(ActionEvent event)
	{
		SwapPartial(partials.get("MagicStaves").getNode());
	}
	
	@FXML
	public void handleWondrousItems(ActionEvent event)
	{
		SwapPartial(partials.get("WondrousItems").getNode());
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
			String[] partials = {"BasicGoods","BasicArmor","BasicWeapon","MagicArmor","MagicWeapon","MagicRing","MagicRod","MagicStaves","WondrousItems"};
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
		loadArmor();
	}
	
	private void loadArmor()
	{
		String fileLoc = "data/items/Armor.tsv";
		HashMap<String, Armor> armor = new HashMap<>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line = fileRead.nextLine();
			line = fileRead.nextLine();
			//this is to remove the first 2 lines of the table
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				if(!line.equals(null) && !line.equals("") && line.equals("\t\t\t\t"))
				{
					String parts[] = line.split("\t");
					Armor tempArmor = new Armor(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9]);
					armor.put(parts[0], tempArmor);
				}
			}
			fileRead.close();
			armors.setAll(armor.values());
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			/*
			Dialogs.create().title("File not Found")
			.masthead("No File was Found")
			.message(e.getMessage() + "\nNo file at " + fileLoc);
			*/
		}
	}
}

package view.partials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;

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

import org.controlsfx.dialog.Dialogs;

import pathfinder.data.Items.Armor;
import pathfinder.data.Items.CursedItem;
import pathfinder.data.Items.Goods;
import pathfinder.data.Items.Item;
import pathfinder.data.Items.MagicArmor;
import pathfinder.data.Items.MagicRing;
import pathfinder.data.Items.MagicRod;
import pathfinder.data.Items.MagicStaves;
import pathfinder.data.Items.MagicWeapon;
import pathfinder.data.Items.Weapon;
import pathfinder.data.Items.WondrousGood;
import view.partials.itemPartials.ItemPartialController;

import com.sun.istack.internal.logging.Logger;

public class ItemsController extends WindowController implements PartialLoader, DataLoader{

	private HashMap<String, ItemPartialController> partials;
	
	@FXML
	AnchorPane ItemsPartialPane;
	
	ObservableList<Item> armors = FXCollections.observableArrayList();
	ObservableList<Item> weapons = FXCollections.observableArrayList();
	ObservableList<Item> magicArmors = FXCollections.observableArrayList();
	ObservableList<Item> magicWeapons = FXCollections.observableArrayList();
	ObservableList<Item> cursedItems = FXCollections.observableArrayList();
	ObservableList<Item> magicRings = FXCollections.observableArrayList();
	ObservableList<Item> rods = FXCollections.observableArrayList();
	ObservableList<Item> goodsAndServices = FXCollections.observableArrayList();
	ObservableList<Item> staves = FXCollections.observableArrayList();
	ObservableList<Item> wondrousGoods = FXCollections.observableArrayList();
	
	@FXML
	public void handleGoodsServices(ActionEvent event) {
		ItemPartialController p = partials.get("BasicGoods");
		p.inView(goodsAndServices);
		SwapPartial(p.getNode());
	}
	
	@FXML
	public void handleBasicArmor(ActionEvent event) {
		ItemPartialController p = partials.get("BasicArmor"); 
		SwapPartial(p.getNode());
		p.inView(armors);
	}
	
	@FXML
	public void handleBasicWeapon(ActionEvent event)
	{
		ItemPartialController p = partials.get("BasicWeapon"); 
		SwapPartial(p.getNode());
		p.inView(weapons);
	}
	
	@FXML
	public void handleMagicArmor(ActionEvent event)
	{
		ItemPartialController p = partials.get("MagicArmor"); 
		SwapPartial(p.getNode());
		p.inView(magicArmors);
		}
	
	@FXML
	public void handleMagicWeapon(ActionEvent event)
	{		
		ItemPartialController p = partials.get("MagicWeapon"); 
		SwapPartial(p.getNode());
		p.inView(magicWeapons);
	}
	
	@FXML
	public void handleMagicRing(ActionEvent event)
	{
		ItemPartialController p = partials.get("MagicRing"); 
		SwapPartial(p.getNode());
		p.inView(magicRings);
	}
	
	@FXML
	public void handleMagicRod(ActionEvent event)
	{
		ItemPartialController p = partials.get("MagicRod"); 
		SwapPartial(p.getNode());
		p.inView(rods);
	}
	
	@FXML
	public void handleMagicStave(ActionEvent event)
	{	
		ItemPartialController p = partials.get("MagicStaves"); 
		SwapPartial(p.getNode());
		p.inView(staves);
	}
	
	@FXML
	public void handleWondrousItems(ActionEvent event)
	{
		ItemPartialController p = partials.get("WondrousItems"); 
		SwapPartial(p.getNode());
		p.inView(wondrousGoods);
	}
	
	private void SwapPartial(Node node) {
		ItemsPartialPane.getChildren().set(0, node);	
	}
	
	public ItemsController() {
		partials = new HashMap<>();
	}
	@Override
	public void initialize() {
		
	}
	
	@Override
	public ItemPartialController loadPartial(String name, Gui ui) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("itemPartials/" + name + "Partial.fxml"));
		
		/*AnchorPane partial = */
		Node node = loader.load();
		ItemPartialController controller = loader.getController();// YUDODIS
		controller.setNode(node);
		controller.setInterface(ui);
		return controller;
	}

	/**
	 * This is the method for loading all items 
	 */
	@Override
	public void loadData() {
		try {
			String[] partials = {"BasicGoods","BasicArmor","BasicWeapon","MagicArmor","MagicWeapon","MagicRing","MagicRod","MagicStaves","WondrousItems"};
			for (String string : partials) {
				this.partials.put(string, loadPartial(string, this.getInterface()));
			}
		} catch (IOException e) {
			Logger.getLogger(getClass()).log(Level.SEVERE, e.getMessage());
		}
		
		loadArmor();
		loadWeapon();
		loadCursedItems();
		loadMagicRing();
		loadGoodsAndServices();
		loadRod();
		loadStaves();
		loadWondrousGoods();
	}
	
	/**
	 * this is the load method for importing armor from a tab delimited file and storing it in a observable list
	 */
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
				String parts[] = line.split("\t");
				Armor tempArmor = new Armor(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9]);
				armor.put(parts[0].toLowerCase(), tempArmor);
			}
			fileRead.close();
			armors.setAll(armor.values());
			loadMagicArmor(armor);
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
	
	/**
	 * this is the load method for importing weapons from a tab delimited file and storing it in a observable list
	 */
	private void loadWeapon()
	{
		String fileLoc = "data/items/Weapons.tsv";
		HashMap<String, Weapon> weapon = new HashMap<String, Weapon>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line;
			//no lines need to be removed from the table
			
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				String[] parts = line.split("\t");
				Weapon tempWeapon = new Weapon(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5],
						parts[6], parts[7], parts[8], parts[9], parts[10]);
				weapon.put(parts[0].toLowerCase(), tempWeapon);
			}
			fileRead.close();
			weapons.setAll(weapon.values());
			loadMagicWeapon(weapon);
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
	
	/**
	 * this is the load method for importing MagicArmor from a tab delimited file and storing it in a observable list
	 * it needs a list of armors to set what armor it is based off. it is loaded from the loadArmor method
	 * @param armor
	 */
	private void loadMagicArmor(HashMap<String, Armor> armor)
	{
		String fileLoc = "data/items/MagicArmor.tsv";
		HashMap<String, MagicArmor> magicArmor = new HashMap<String, MagicArmor>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line = fileRead.nextLine();
			//one line needs to be removed from the table
			
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				String[] parts = line.split("\t");
				try
				{
					MagicArmor tempMagicArmor= new MagicArmor(armor.get(parts[0].toLowerCase()), parts[1], parts[2],
							parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
					magicArmor.put(parts[1], tempMagicArmor);
				}
				catch(NullPointerException e)
				{
					System.out.println(parts[0]);
				}
			}
			fileRead.close();
			magicArmors.setAll(magicArmor.values());
		}
		catch(FileNotFoundException e)
		{			
			//e.printStackTrace();
			Dialogs.create().title("File not Found")
			.masthead("No File was Found")
			.message(e.getMessage() + "\nNo file at " + fileLoc);
		}
	}
	
	/**
	 * this is the load method for importing Magic Weapons from a tab delimited file and storing it in a observable list
	 * it needs a list of weapons to set what weapon it is based off. it is loaded from the loadWeapon method
	 * @param weapon
	 */
	private void loadMagicWeapon(HashMap<String, Weapon> weapon)
	{
		String fileLoc = "data/items/MagicWeapons.tsv";
		HashMap<String, MagicWeapon> magicWeapon = new HashMap<String, MagicWeapon>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line = fileRead.nextLine();
			//one line needs to be removed from the table
			
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				String[] parts = line.split("\t");
				MagicWeapon tempMagicWeapon = new MagicWeapon(weapon.get(parts[0].toLowerCase()), parts[1], parts[2], parts[3], parts[4],
						parts[5], parts[6], parts[7]);
				magicWeapon.put(parts[0], tempMagicWeapon);
			}
			fileRead.close();
			magicWeapons.setAll(magicWeapon.values());
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
	
	/**
	 * this is the load method for importing cursed Items from a tab delimited file and storing it in a observable list
	 */
	private void loadCursedItems()
	{
		String fileLoc = "data/items/CursedItems.tsv";
		HashMap<String, CursedItem> cursedItems = new HashMap<String, CursedItem>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line = fileRead.nextLine();
			//one line needs to be removed from the table
			
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				String[] parts = line.split("\t");
				CursedItem tempCursedItem = new CursedItem(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
				cursedItems.put(parts[0], tempCursedItem);
			}
			fileRead.close();
			this.cursedItems.setAll(cursedItems.values());
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
	
	/**
	 * this is the load method for importing Magic Rings from a tab delimited file and storing it in a observable list
	 */
	private void loadMagicRing()
	{
		String fileLoc = "data/items/MagicRings.tsv";
		HashMap<String, MagicRing> magicRings = new HashMap<String, MagicRing>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line = fileRead.nextLine();
			//one line needs to be removed from the table
			
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				String[] parts = line.split("\t");
				MagicRing magicRing = new MagicRing(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
				magicRings.put(parts[0], magicRing);
			}
			fileRead.close();
			this.magicRings.setAll(magicRings.values());
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
	
	/**
	 * this is the load method for importing Rods from a tab delimited file and storing it in a observable list
	 */
	private void loadRod()
	{
		String fileLoc = "data/items/Rods.tsv";
		HashMap<String, MagicRod> rods = new HashMap<String, MagicRod>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line = fileRead.nextLine();
			//one line needs to be removed from the table
			
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				String[] parts = line.split("\t");
				MagicRod rod = new MagicRod(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
				rods.put(parts[0], rod);
			}
			fileRead.close();
			this.rods.setAll(rods.values());
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
	
	/**
	 * this is the load method for importing Goods and Services from a tab delimited file and storing it in a observable list
	 */
	private void loadGoodsAndServices()
	{
		String fileLoc = "data/items/ServicesAndGoods.tsv";
		HashMap<String, Goods> goods = new HashMap<String, Goods>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line = fileRead.nextLine();
			//one line needs to be removed from the table
			
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				String[] parts = line.split("\t");
				Goods good = new Goods(parts[0], parts[1], parts[2]);
				goods.put(parts[0], good);
			}
			fileRead.close();
			goodsAndServices.setAll(goods.values());
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
	
	/**
	 * this is the load method for importing Staves from a tab delimited file and storing it in a observable list
	 */
	
	private void loadStaves()
	{
		String fileLoc = "data/items/Staves.tsv";
		HashMap<String, MagicStaves> staves = new HashMap<String, MagicStaves>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line = fileRead.nextLine();
			//one line needs to be removed from the table
			
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				String[] parts = line.split("\t");
				MagicStaves stave = new MagicStaves(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
				staves.put(parts[0], stave);
			}
			fileRead.close();
			this.staves.setAll(staves.values());
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
	
	/**
	 * this is the load method for importing Wondrous Goods from a tab delimited file and storing it in a observable list
	 */
	private void loadWondrousGoods()
	{
		String fileLoc = "data/items/WondrousItems.tsv";
		HashMap<String, WondrousGood> goods = new HashMap<String, WondrousGood>();
		try
		{
			Scanner fileRead = new Scanner(new FileReader(fileLoc));
			String line = fileRead.nextLine();
			//one line needs to be removed from the table
			
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				String[] parts = line.split("\t");
				WondrousGood good = new WondrousGood(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
				goods.put(parts[0], good);
			}
			fileRead.close();
			this.wondrousGoods.setAll(goods.values());
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

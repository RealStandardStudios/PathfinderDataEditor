package view.partials;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jefXif.WindowController;
import pathfinder.data.Spells.Spell;

public class SpellsController extends WindowController{

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	private ObservableList<Spell> spellData = FXCollections.observableArrayList();
	
	public SpellsController() {
		// Test data for now
		spellData.add(new Spell());
	}

}

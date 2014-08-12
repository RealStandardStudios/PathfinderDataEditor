package view.partials.itemPartials;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jefXif.WindowController;
import pathfinder.data.Items.*;

public class BasicGoodsController extends WindowController {
	
	@FXML
	private Label lblName;
	
	@FXML
	private Label lblCost;
	
	@FXML
	private Label lblWeight;

	@Override
	public void initialize() {
	}
	
	public void setBasicGoods(Goods goods)
	{
		if(goods != null)
		{
			lblName.setText(goods.getName());
			lblCost.setText(goods.getCost());
			lblWeight.setText(goods.getWeight());
		}
		else
		{
			lblName.setText("No Goods selected");
			lblCost.setText("");
			lblWeight.setText("");
		}
	}

}

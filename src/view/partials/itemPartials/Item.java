package view.partials.itemPartials;
/*
 * Real Standard Studios - Joshua James Boyd
 */

public class Item {
	private String itemName;
	private String slot;
	private String auraStrenth;
	private String casterLevel;
	private String price;
	private String weight;
	private String description;
	private String construction;
	private String dmgS;
	private String dmgM;
	private String critical;
	private String range;
	private String type;
	private String special;
	private String acBonus;
	private String maxDexBonus;
	private String armorCheckPenalty;
	private String arcane;
	private String speed30;
	private String speed20;
	private String itemType;
	private String armorType;
	

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getAuraStrenth() {
		return auraStrenth;
	}

	public void setAuraStrenth(String auraStrenth) {
		this.auraStrenth = auraStrenth;
	}

	public String getCasterLevel() {
		return casterLevel;
	}

	public void setCasterLevel(String casterLevel) {
		this.casterLevel = casterLevel;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConstruction() {
		return construction;
	}

	public void setConstruction(String construction) {
		this.construction = construction;
	}

	public String getDmgS() {
		return dmgS;
	}

	public void setDmgS(String dmgS) {
		this.dmgS = dmgS;
	}

	public String getDmgM() {
		return dmgM;
	}

	public void setDmgM(String dmgM) {
		this.dmgM = dmgM;
	}

	public String getCritical() {
		return critical;
	}

	public void setCritical(String critical) {
		this.critical = critical;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getAcBonus() {
		return acBonus;
	}

	public void setAcBonus(String acBonus) {
		this.acBonus = acBonus;
	}

	public String getMaxDexBonus() {
		return maxDexBonus;
	}

	public void setMaxDexBonus(String maxDexBonus) {
		this.maxDexBonus = maxDexBonus;
	}

	public String getArmorCheckPenalty() {
		return armorCheckPenalty;
	}

	public void setArmorCheckPenalty(String armorCheckPenalty) {
		this.armorCheckPenalty = armorCheckPenalty;
	}

	public String getArcane() {
		return arcane;
	}

	public void setArcane(String arcane) {
		this.arcane = arcane;
	}

	public String getSpeed30() {
		return speed30;
	}

	public void setSpeed30(String speed30) {
		this.speed30 = speed30;
	}

	public String getSpeed20() {
		return speed20;
	}

	public void setSpeed20(String speed20) {
		this.speed20 = speed20;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getArmorType() {
		return armorType;
	}

	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}

	public Item(String name, String cost, String weight, String itemType)
	{
		this.itemName = name;
		this.price = cost;
		this.weight = weight;
		this.itemType = itemType;
	//this makes a new item. this layout is most common services and basic traveling gear	
	}
	
	public Item(String name, String Slot, String auraStrenth, String casterLevel, String cost, String weight, String description, String construction, String itemType)
	{
		this.itemName = name;
		this.auraStrenth = auraStrenth;
		this.casterLevel = casterLevel;
		this.price = cost;
		this.weight = weight;
		this.description = description;
		this.construction = construction;
		this.itemType = itemType;
		//this makes a new item. this layout will most likely make an magic item, type defined by itemType(E.G - wand, stave...)
	}
	
	public Item(String name, String cost, String dmgS, String dmgM, String critical, String range, String weight, String type, String special, String itemType)
	{
		this.itemName = name;
		this.price = cost;
		this.dmgS = dmgS;
		this.dmgM = dmgM;
		this.critical = critical;
		this.range = range;
		this.weight = weight;
		this.type = type; //refers to damage type(E.G - bashing percing or slashing)
		this.special = special;
		this.itemType = itemType;
		//this makes a new item, this layout will make a basic weapon
	}
	
	public Item(String armorType, String name, String cost, String acBonus, String maxDexBonus, String armorCheckPenalty, String arcaneSpellFalure, String speed30, String speed20, String weight, String itemType)
	{
		this.armorType = armorType;
		this.itemName = name;
		this.price = cost;
		this.acBonus = acBonus;
		this.maxDexBonus = maxDexBonus;
		this.armorCheckPenalty = armorCheckPenalty;
		this.arcane = arcaneSpellFalure;
		this.speed30 = speed30;
		this.speed20 = speed20;
		this.weight = weight;
		this.itemType = itemType;
		//this makes a new item, this layout will make basic armor
	}
	
	
	
}

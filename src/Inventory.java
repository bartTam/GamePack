package gamepack;

public class Inventory {
	
	private Potion[] potionArray;
	private Enchantment[] enchantmentArray;
	private Weapon weapon;
	
	public Inventory(Potion[] potionArray,Enchantment[] enchantmentArray,Weapon weapon){
		this.potionArray=potionArray;
		this.enchantmentArray=enchantmentArray;
		this.weapon=weapon;
	}
	
	public Potion[] getPotionArray(){
		return potionArray;
	}
	public void setPotionArray(Potion[] potionArray){
		this.potionArray=potionArray;
	}
	
	public Enchantment[] getEnchantmentArray(){
		return enchantmentArray;
	}
	public void setEnchantmentArray(Enchantment[] enchantmentArray){
		this.enchantmentArray=enchantmentArray;
	}
	
	public Weapon getWeapon(){
		return weapon;
	}
	public void setWeapon(Weapon weapon){
		this.weapon=weapon;
	}
	
	
}
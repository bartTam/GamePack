package gamepack;

public abstract class Enchantment{
	
		//always false, unless activated by player, reset to false after battle ends
		private boolean enchantmentIsActive = false;
	
		//the amount of enchantments by type, by default 0
		private int enchantmentAmount = 0;
		
		
		//the damage multiplier the Player has for the duration of the battle
		protected final int STRENGTH_ENCHANTMENT = 2;
	
		//the amount of accuracy added to the player's base critical chance;
		protected final int ACCURACY_ENCHANTMENT = 30;
	
		//the amount of critical chance added to the player's base critical chance
		protected final int CRITICAL_CHANCE_ENCHANTMENT = 25;
	
		//the amount of fatigue that will be subtracted from use after each attack
		protected final int FATIGUE_ENCHANTMENT = 1;
	
	
	public Enchantment(){
		
	}
	
	public void setEnchantmentIsActive(boolean set){
		enchantmentIsActive = set;
	}
	public boolean getEnchantmentIsActive(){
		return enchantmentIsActive;
	}
	
	public void setEnchantmentAmount(int amount){
		this.enchantmentAmount = amount;
	}
	public int getEnchantmentAmount(){
		return enchantmentAmount;
	}
	
	public void useEnchantment(){
		if(enchantmentAmount > 0)
			enchantmentAmount--;
	}
	
	
	
	public abstract int getEnchantment();
	
}

class StrengthEnchantment extends Enchantment{
	
	public StrengthEnchantment(){

	}
	
	public int getEnchantment(){
		return STRENGTH_ENCHANTMENT;
	}
}

class AccuracyEnchantment extends Enchantment{
	public AccuracyEnchantment(){

	}
	public int getEnchantment(){
		return ACCURACY_ENCHANTMENT;
	}
}

class CriticalChanceEnchantment extends Enchantment{
	public CriticalChanceEnchantment(){

	}
	public int getEnchantment(){
		return CRITICAL_CHANCE_ENCHANTMENT;
	}
}

class FatigueEnchantment extends Enchantment{
	public FatigueEnchantment(){

	}
	public int getEnchantment(){
		return FATIGUE_ENCHANTMENT;
	}
}
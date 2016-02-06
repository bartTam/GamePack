package gamepack;

public class Enchantment{
	
	//always false, unless activated by player, reset to false after battle ends
	private boolean enchantmentIsActive = false;
	
	//the damage multiplier the Player has for the duration of the battle
	private final int STRENGTH_ENCHANTMENT = 2;
	
	//the amount of accuracy added to the player's base critical chance;
	private final double ACCURACY_ENCHANTMENT = 30;
	
	//the amount of critical chance added to the player's base critical chance
	private final int CRITICAL_CHANCE_ENCHANTMENT = 25;
	
	//the amount of fatigue that will be subtracted from use after each attack
	private final int FATIGUE_ENCHANTMENT = 1;
	
	public Enchantment(){
		
	}
	
	public void setEnchantmentIsActive(boolean set){
		enchantmentIsActive = set;
	}
	
	public boolean getEnchantmentIsActive(){
		return enchantmentIsActive;
	}
	
	public int getStrengthEnchantment(){
		return STRENGTH_ENCHANTMENT;
	}
	
	public double getAccuracyEnchantment(){
		return ACCURACY_ENCHANTMENT;
	}
	
	public int getCriticalChanceEnchantment(){
		return CRITICAL_CHANCE_ENCHANTMENT;
	}
	
	public int getFatigueEnchantment(){
		return FATIGUE_ENCHANTMENT;
	}
	
}
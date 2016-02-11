package gamepack;


public abstract class Potion extends Item{

	//blank Potion, expected override
	public Potion(){}; 

	private int amount;
	
	private String name;
	
	private boolean isActive;
	
	private int turnsRemaining;
	
	public Potion (int amount, String name, boolean isActive, int turnsRemaining){

		this.amount = amount;
		this.name = name;
		this.isActive = isActive;
		this.turnsRemaining = turnsRemaining;
	}
//toString
	public String toString(){
		return amount+" "+name;
	}
	
//amount	
	public int getAmount(){
		return amount;
	}
	public void setAmount(int amountInput){
		amount = amountInput;
	}
//name	
	public String getName(){
		return name;
	}
	public void setName(String nameInput){
		name = nameInput;
	}
//isActive
	public boolean getIsActive(){
		return isActive;
	}
	public void setIsActive(boolean isActive){
		this.isActive=isActive;
	}
//turnsRemaining
	public int getTurnsRemaining(){
		return turnsRemaining;
	}
	public void setTurnsRemaining(int turnsRemaining){
		this.turnsRemaining = turnsRemaining;
	}
	public void drinkRegenPotion(){
		this.turnsRemaining+=5;
	}
	public void drinkRegularPotion(){
		this.turnsRemaining+=2;
	}

	
//obtain potion  increments the amount of potions owned by the type named by the amount given
	public static Potion obtainPotion(Potion pickUp, Potion inInventory){
		if(pickUp.getName().equals(inInventory.getName())){
			inInventory.setAmount( pickUp.getAmount()+inInventory.getAmount() );
		}
		return inInventory;
	}
//decrement potion amount in relation to potion, not stats	
	public Potion usePotion(Potion inInventory){
		inInventory.setAmount(inInventory.getAmount()-1);
		return inInventory;
	}
}

//each potion type will have its own subclass

class damageTakenReductionPotion extends Potion {
	
	public damageTakenReductionPotion(int amount, String name, boolean isActive,int turnsRemaining){
		super(amount,name,isActive,turnsRemaining);
		name = "Damage Taken Reduction Potion";
	}
}

class speedIncreasePotion extends Potion {
	
	public speedIncreasePotion(int amount, String name, boolean isActive,int turnsRemaining){
		super(amount,name,isActive,turnsRemaining);
		name = "Speed Increase Potion";
	}
}

class critChanceIncreasePotion extends Potion {
	
	public critChanceIncreasePotion(int amount, String name, boolean isActive,int turnsRemaining){
		super(amount,name,isActive,turnsRemaining);
		name = "Crit Chance Increase Potion";
	}
}

class healthRegenPotion extends Potion {
	
	public healthRegenPotion(int amount, String name, boolean isActive,int turnsRemaining){
		super(amount,name,isActive,turnsRemaining);
		name = "Health Regen Potion";
	}
}

class evadeIncreasePotion extends Potion {
	
	public evadeIncreasePotion(int amount, String name, boolean isActive,int turnsRemaining){
		super(amount,name,isActive,turnsRemaining);
		name = "Evade Increase Potion";
	}
}

class damageGivenIncreasePotion extends Potion {
	
	public damageGivenIncreasePotion(int amount, String name, boolean isActive,int turnsRemaining){
		super(amount,name,isActive,turnsRemaining);
		name = "Damage Given Increase Potion";
	}
}

class critDamageIncreasePotion extends Potion {
	
	public critDamageIncreasePotion(int amount, String name, boolean isActive,int turnsRemaining){
		super(amount,name,isActive,turnsRemaining);
		name = "Crit Damage Increase Potion";
	}
}

class fatigueRegenPotion extends Potion {
	
	public fatigueRegenPotion(int amount, String name, boolean isActive,int turnsRemaining){
		super(amount,name,isActive,turnsRemaining);
		name = "Fatigue Regen Potion";
	}
}

class doubleExperiencePotion extends Potion {
	
	public doubleExperiencePotion(int amount, String name, boolean isActive,int turnsRemaining){
		super(amount,name,isActive,turnsRemaining);
		name = "Double Experience Potion";
	}
}

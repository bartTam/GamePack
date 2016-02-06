package gamepack;


public abstract class Potion extends Item{

	//blank Potion, expected override
	public Potion(){}; 

	private int amount;
	
	private String name;
	public Potion (int amount, String name){

		this.amount = amount;
		this.name = name;
	}
//toString
	public String toString(){
		return amount+" "+name+";
	}
	
//amount	
	public int getAmount(){
		return amount;
	}
	public void setAmount(int amountInput){
		deltaHealth = amountInput;
	}
//name	
	public String getName(){
		return name;
	}
	public void setName(String nameInput){
		name = nameInput;
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

	public abstract void inflictStatus();
}

//each potion type will have its own subclass

class damageTakenReductionPotion extends Potion {
	
	public damageTakenReductionPotion(int amount, String name){
		super(amount,name);
	}
	
	public void inflictStatus(Player player){
		
	}

}

class speedIncreasePotion extends Potion {
	
	public speedIncreasePotion(int amount, String name){
		super(amount,name);
	}
	
	public void inflictStatus(Player player){
		
	}

}

class critChanceIncreasePotion extends Potion {
	
	public critChanceIncreasePotion(int amount, String name){
		super(amount,name);
	}
	
	public void inflictStatus(Player player){
		
	}

}

class healthRegenPotion extends Potion {
	
	public healthRegenPotion(int amount, String name){
		super(amount,name);
	}
	
	public void inflictStatus(Player player){
		
	}

}

class evadeIncreasePotion extends Potion {
	
	public evadeIncreasePotion(int amount, String name){
		super(amount,name);
	}
	
	public void inflictStatus(Player player){
		
	}

}

class damageGivenIncreasePotion extends Potion {
	
	public damageGivenIncreasePotion(int amount, String name){
		super(amount,name);
	}
	
	public void inflictStatus(Player player){
		
	}

}

class critDamageIncreasePotion extends Potion {
	
	public critDamageIncreasePotion(int amount, String name){
		super(amount,name);
	}
	
	public void inflictStatus(Player player){
		
	}

}

class fatigueRegenPotion extends Potion {
	
	public fatigueRegenPotion(int amount, String name){
		super(amount,name);
	}
	
	public void inflictStatus(Player player){
		
	}

}

class doubleExperiencePotion extends Potion {
	
	public doubleExperiencePotion(int amount, String name){
		super(amount,name);
	}
	
	public void inflictStatus(Player player){
		
	}

}

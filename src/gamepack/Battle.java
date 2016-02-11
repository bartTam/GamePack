package gamepack;


//unchanged as of 2/5/16 (before git)


import java.util.Scanner;
public class Battle {
	//if more than 1 enemy is being fought at a time then damage will run for each instantiation
	//damage will also record experienced gained after the battle
	//max amount of enemies is 3 (arbitrary atm), to have 1 enemy, the other 2 will spawn with zero health
	//xp is based off of enemy health multiplicitavely with level, so an enemy with 0 health will give no xp
	private Player hero;
	private Enemy enemy;
	public Battle(Player hero, Enemy enemy){
		this.hero = hero;
		this.enemy = enemy;
	}
	
	//scenarios need to be made for each module of the battle including health, power drain from attacks, and checking if the enemy is still alive (health > 0)
	//enemy ai in a Damage method
	//enemy death statement only following a character influenced option (ie. enemy with 0 health does not say "EnemyName just died")
	//chosen attacks will be increased once the getter method is used on weapon damage: ie. Use Powerful Attack: weapon.damageGetter()*100
	
	
	//experience received per enemy is 1
	
	public double experienceGained(){
		return 1;
	}
	
	public void playerAttack(int input){
		
		//the Player's weapon
		Weapon attack = hero.getInventory().getWeapon();
		
		//random variable to check against the Player's accuracy
		double accuracyCheck = Math.random();
		
		//random variable to check against the Player's critical hit chance
		double critCheck = Math.random();
		
		//damage from Player's base damage and the Player's Weapon's damage
		int damage = (int)( attack.getDamage() + hero.getStats().getDamage() );
		
		//the health of the Enemy
		int health = enemy.getStats().getHealth();
		
		
		//check accuracy - see if the Player hits
		if( attack.getAccuracy() > accuracyCheck ){
			
			//see if the Player does a critical hit
			if( hero.getStats().getCritChance() > critCheck ){
				damage *= hero.getStats().getCritDamage();
			}
			
			//lower Enemy health
			health-=damage;
			
			//set Enemy health to lowered amount
			enemy.getStats().setHealth(health);
			
			//add and sets Player fatigue
			hero.getStats().setFatigue( attack.getFatigue() + hero.getStats().getFatigue() );
			
		}
		else{
			//TODO: inform the Player of a MISS
		}
	}
	
	public void enemyAttack(){
		
		//the Enemy's weapon
		Weapon attack = enemy.getWeapon();
		
		//random variable to check against the Enemy's accuracy
		double accuracyCheck = Math.random();
		
		//random variable to check against the Enemy's critical hit chance
		double critCheck = Math.random();
		
		//the damage from Enemy's base damage and the Enemy's Weapon damage
		int damage = (int)( enemy.getWeapon().getDamage() + enemy.getStats().getDamage() );
		
		//the health of the Player
		int health = hero.getStats().getHealth();
		
		//check accuracy - see if the Enemy hits
		if( attack.getAccuracy() > accuracyCheck ){
			
			//see if the Enemy does a critical hit
			if(attack.getCriticalChance() > critCheck){
				damage*=2;
			}
			
			//lower Player health
			health-=damage;
			
			//set Player health to lowered amount
			hero.getStats().setHealth(health);
			
			//add and sets Enemy fatigue
			enemy.getStats().setFatigue( attack.getFatigue() + enemy.getStats().getFatigue() );
			
			
		}
		else{
			//TODO: inform the Player that the Enemy MISSED
		}
	}
	
	
	//the player uses a potion from Player.getInventory.getPotionArray()
	public void playerUsePotion(int input){
		Potion[] getPotions = hero.getInventory().getPotionArray();
		input--; //take input-1 to display 1-8 instead of 0-7
		getPotions[input].usePotion(getPotions[input]);
		hero.getInventory().setPotionArray(getPotions);
	}
	
	public void printWeaponYell(Character attacking){
		if(attacking.getCharType().equals("Mage")){
			
		}
		if(attacking.getCharType().equals("Archer")){
			
		}
		if(attacking.getCharType().equals("Warrior")){
	
		}
		
		//expected Enemy
		else{
			//TODO: Enemy hit sound
		}
	}
	/**
	 * overview
	 * 
	 * physical
	 * 		to be determined
	 * 		0 whatToDo() //back
	 * tactical
	 * 		1 bide
	 * 		2 dodge
	 * 		3 block
	 * 		0 whatToDo() //back
	 * inventory
	 * 		potion
	 * 			1-8
	 * 			0 inventory() //back
	 * 		enchantment
	 * 			1-4
	 * 			0 inventory() //back
	 * flee
	 * 		1 confirm
	 * 		0 whatToDo() //back
	 * 
	 * 
	 * 
	 * @param input choice for selection
	 */
	public void whatToDo(int input){
		switch(input){
		case 1://physical
				physical();break;
		case 2://tactical
				tactical();break;
		case 3://inventory
				inventory();
		case 4://flee
				flee();break;
		}
	}
	
	public void physical(){
		Scanner k = new Scanner(System.in);
		int input = k.nextInt();
		playerAttack(input);
		
	}
	
	public void tactical(){
		//TODO: bide, dodge, block
	}
	public void inventory(){
		//TODO: select screen for potion, enchantment, or back
	}
	public void potion(){
		Scanner k = new Scanner(System.in);
		int input = k.nextInt();
		playerUsePotion(input);
		
	}
	public void enchantment(){
		//TODO
	}
	
	public void flee(){
		//TODO
	}
	
}

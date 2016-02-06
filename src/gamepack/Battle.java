package gamepack;


//unchanged as of 2/5/16 (before git)


import java.util.Scanner;
public class Battle {
	//if more than 1 enemy is being fought at a time then damage will run for each instantiation
	//damage will also record experienced gained after the battle
	//max amount of enemies is 3 (arbitrary atm), to have 1 enemy, the other 2 will spawn with zero health
	//xp is based off of enemy health multiplicitavely with level, so an enemy with 0 health will give no xp
	private Player protagonist;
	private NonPlayerCharacter antagonist;
	public Battle(Player protagonist, NonPlayerCharacter antagonist){
		this.protagonist = protagonist;
		this.antagonist = antagonist;
	}
	
	//scenarios need to be made for each module of the battle including health, power drain from attacks, and checking if the enemy is still alive (health > 0)
	//enemy ai in a Damage method
	//enemy death statement only following a character influenced option (ie. enemy with 0 health does not say "EnemyName just died")
	//chosen attacks will be increased once the getter method is used on weapon damage: ie. Use Powerful Attack: weapon.damageGetter()*100
	
	public double experienceGained(){
		return antagonist.getLevel(); //experience gained is enemy level
	}
	
	public void playerAttack(int input){//
		Weapon attack = protagonist.getWeapon();
		double power = protagonist.getPower();
		double accuracyCheck = Math.random();
		double critCheck = Math.random();
		double damage = attack.getDamage();
		double health = antagonist.getHealth();
		if(attack.getAccuracy()>accuracyCheck){
			if(attack.getCritical()>critCheck){
				damage*=2;
			}
			health-=damage;
			power-=attack.getSpecial();
			antagonist.setHealth(health);
			protagonist.setPower(power);
		}
		else{
			System.out.println("Miss");
		}
	}
	
	public void playerUsePotion(int input){
		Potion[] getPotions = protagonist.getPotionList();
		input--; //take input-1 to display 1-8 instead of 0-7
		getPotions[input].usePotion(getPotions[input]);
		protagonist.setPotion(getPotions);
	}
	
	public void npcAttack(){
		Weapon attack = antagonist.getWeapon();
		double power = antagonist.getPower();
		double accuracyCheck = Math.random();
		double critCheck = Math.random();
		double damage = attack.getDamage();
		double health = protagonist.getHealth();
		if(attack.getAccuracy()>accuracyCheck){
			if(attack.getCritical()>critCheck){
				damage*=2;
			}
			health-=damage;
			power-=attack.getSpecial();
			protagonist.setHealth(health);
			antagonist.setPower(power);
		}
		else{
			System.out.println("Miss");
		}
	}
	
	public void printWeaponYell(Character input){
		if(input.getCharType().equals("Mage")){
			
		}
		if(input.getCharType().equals("Archer")){
			
		}
		if(input.getCharType().equals("Warrior")){
	
		}
		if(input.getCharType().equals("Enemy")){
	
		}
	}
	
	public void whatToDo(int input){
		switch(input){
		case 1://fight
				fight();break;
		case 2://potion
				potion();break;
		case 3://flee
				flee();break;
		}
	}
	
	public void fight(){
		Scanner k = new Scanner(System.in);
		int input = k.nextInt();
		playerAttack(input);
		
	}
	public void potion(){
		Scanner k = new Scanner(System.in);
		int input = k.nextInt();
		playerUsePotion(input);
		
	}
	public void flee(){
		//todo
	}
	
}

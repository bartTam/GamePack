package gamepack;


//stats for Character, Attackable

public class Stats {
	
	//the amount of health the Character has
	private int health;

	//the amount of fatigue the Character has
	private int fatigue;

	//the amount of speed the Character has
	private int speed;

	//the evade chance the Character has
	private double evade;

	//the amount of experience the Character has
	private int experience;

	//the amount of base damage the Character has
	private int damage;

	//the amount of base critical hit chance the Character has
	private double critChance;

	//the amount of base critical hit damage the Character has
	private double critDamage;

	
	public Stats(int health, int fatigue, int speed, double evade, int experience, int damage, double critChance, double critDamage) {
		
		this.health = health;
		this.fatigue = fatigue;
		this.speed = speed;
		this. evade = evade;
		this.experience =  experience;
		this.damage = damage;
		this.critChance = critChance;
		this.critDamage = critDamage;
	
	}

	public void setHealth(int health){
		this.health=health;
	}
	public int getHealth(){
		return health;
	}

	public boolean isAlive(){
		return getHealth() > 0;
	}
	
	
	
	public void setFatigue(int fatigue){
		this.fatigue=fatigue;
	}
	public int getFatigue(){
		return fatigue;
	}

	public void setSpeed(int speed){
		this.speed=speed;
	}
	public int getSpeed(){
		return speed;
	}

	public void setEvade(double evade){
		this.evade=evade;
	}
	public double getEvade(){
		return evade;
	}

	public void setExperience(int experience){
		this.experience=experience;
	}
	public int getExperience(){
		return experience;
	}

	public void setDamage(int damage){
		this.damage=damage;
	}
	public int getDamage(){
		return damage;
	}

	public void setCritChance(double critChance){
		this.critChance=critChance;
	}
	public double getCritChance(){
		return critChance;
	}

	public void setCritDamage(double critDamage){
		this.critDamage=critDamage;
	}
	public double getCritDamage(){
		return critDamage;
	}
	
	public Stats generateStats(Player player){
		//TODO: Auto-generate stats for any Character which needs Stats based on the Player
		return null;
	}
	
	
}


class playerStats extends Stats {
	
	//Modifiers for statuses
	
		//divides incoming damage
		private static final double REDUCE_DAMAGE_TAKEN = 2;

		//multiplies damage given
		private static final double INCREASE_DAMAGE_GIVEN = 2;

		//multiplies speed
		private static final double SPEED_INCREASE = 1.5;

		//multiplies evade
		private static final double EVADE_INCREASE = 1.5;
		
		//multiplies critical hit chance
		private static final double CRIT_CHANCE_INCREASE = 2;

		//multiplies critical hit damage
		private static final double CRIT_DAMAGE_INCREASE = 2;
	
		//multiplies for percentage of health to gain
		private static final double HEALTH_REGEN_AMOUNT = 1.05;

		//adds for fatigue to regenerate
		private static final int FATIGUE_REGEN_AMOUNT= 5;

		//multiplies experience gained
		private static final double INCREASE_EXPERIENCE_GAINED = 2;

	public playerStats(int health, int fatigue, int speed, double evade, int experience, int damage, double critChance, double critDamage) {
		
		super(health,fatigue,speed,evade,experience,damage,critChance,critDamage);
		
	}
	
	//parameter use
	/**
	 * If you drink reduce damage potion, reduce damage taken from Enemy.
	 * Check if the correct potion was used and check if that potion is active
	 * @param damage incoming damage
	 */
	public void takeReducedDamage(int damage,Potion potion){
		if( potion.getName().equals("Damage Taken Reduction Potion") && potion.getIsActive() )
			setHealth( getHealth() - (int)( damage / REDUCE_DAMAGE_TAKEN ) );	
		
	}

	public int giveIncreasedDamage(Potion potion){
		if( potion.getName().equals("Damage Given Increase Potion") && potion.getIsActive() )
			return  (int)(getDamage() * INCREASE_DAMAGE_GIVEN);
		return -1;
	}

	public int increaseSpeed(Potion potion){
		if( potion.getName().equals("Speed Increase Potion") && potion.getIsActive() )
			return (int)(getSpeed() * SPEED_INCREASE);
		return -1;
	}

	public double increaseEvadePotion(Potion potion){
		if( potion.getName().equals("Evade Increase Potion") && potion.getIsActive() )
			return getEvade() * EVADE_INCREASE;
		return -1;
	}
	
	public double critChanceIncrease(Potion potion){
		if (potion.getName().equals("Crit Chance Increase Potion") && potion.getIsActive() )
			return getCritChance() * CRIT_CHANCE_INCREASE;
		return -1;
	}

	public double critDamageIncrease(Potion potion){
		if( potion.getName().equals("Crit Damage Increase Potion") && potion.getIsActive() )
			return getCritDamage() * CRIT_DAMAGE_INCREASE;
		return -1;
	}

	public void healthRegen(Potion potion){
		if( potion.getName().equals("Health Regen Potion") && potion.getIsActive() )
			setHealth( (int) ( getHealth() * HEALTH_REGEN_AMOUNT) );
	}

	public void fatigueRegen(Potion potion){
		if( potion.getName().equals("Fatigue Regen Potion") && potion.getIsActive() ){
			if( getFatigue() + FATIGUE_REGEN_AMOUNT >100){
				setFatigue(100);
			}
			else{
				setFatigue( getFatigue() + FATIGUE_REGEN_AMOUNT);
			}
		}
			
	}

	public int increaseExperience(int experience,Potion potion){
		if( potion.getName().equals("Double Experience Potion") && potion.getIsActive() )
			setExperience( getExperience() + (int)( experience*INCREASE_EXPERIENCE_GAINED ) );
		return -1;
	}
}

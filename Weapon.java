package gamepack;

/**
 * This is the class for weapons.
 * 
 * @author Bart and Jacob
 *
 */
public class Weapon extends Item {
	
	
	private double damage,accuracy,criticalChance,fatigue;
	private int damage;
	private double accuracy;
	private double criticalChance;
	private String weaponType;
	
	public Weapon(){};
	
	/**
	 * This is the constructor for Weapon.
	 * 
	 * @param damage The damage the weapon will do.
	 * @param accuracy The accuracy the weapon has.
	 * @param criticalChance The chance the weapon has to crit.
	 * @param fatigue The amount of fatigue the weapon consumes to use.
	 * @param weaponType The name of the weapon.
	 */
	public Weapon (int damage, double accuracy, double criticalChance, int fatigue, String weaponType){
		this.damage = damage;
		this.accuracy = accuracy;
		this.criticalChance = criticalChance;
		this.fatigue = fatigue;
		this.weaponType = weaponType;
	}
	public String toString(){
		return (type+"\nDamage: "+damage+"\nAccuracy: "+(accuracy*100)+"%\nCritical Chance: "+(criticalChance*100)+"%\nFatigue: "+(Fatigue*100)+"%");
	}
//how much damage the weapon will increase based on player power	
	public double getDamage() {
		return damage;
	}
	public void setDamage(double damageInput) {
		damage = damageInput;
	}
//how accurate the weapon is	
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracyInput) {
		accuracy = accuracyInput;
	}
//crit chance	
	public double getCriticalChance(){
		return criticalChance;
	}
	public void setCriticalChance(double criticalChanceInput){
		criticalChance = criticalChanceInput;
	}
//the fatigue drain per attack	
	public int getFatigue(){
		return fatigue;
	}
	public void setFatigue(double fatigueInput){
		fatigue= fatigueInput;
	}
//what kind of weapon it is	
	public String getWeaponType(){
		return weaponType;
	}
	public void setWeaponType(String weaponTypeInput){
		weaponType = weaponTypeInput;
	}
}

//weapon list
//axe  bow  club  crossbow  dagger  greatsword  halberd  mace  spear  staff  sword  tome  wand  whip --> 14 weapons


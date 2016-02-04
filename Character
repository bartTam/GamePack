package gamepack;





//unorganized




/**
 * The character class that is the parent class for all characters. 
 * 
 * @author Bart and Jacob
 *
 */
public abstract class Character {
	
	// health: the charcter's hitpoints
	private double health;
	
	// fatigue: the character's energy to attack
	private int fatigue;
	
	// speed: the character's ability to attack first
	private double speed;
	
	// evade: the chance the character will evade
	private double evade;
	
	// charType: the character's type
	private String charType;
	
	// experience: the character's experience
	private int experience;
	
	// weapon: the character's weapon
	private Weapon weapon;
	
	// mapPoint: the coordinate on the map this character is located
	private Point mapPoint;
	
	// tileSetPoint: the coordinate on the tileset this character is located
	private Point tileSetPoint;
	
	/**
	 * This is the Character constructor.
	 * 
	 * @param health The character's hitpoints
	 * @param fatigue the character's energy to attack
	 * @param speed the character's ability to attack first
	 * @param evade the chance the character will evade
	 * @param charType the character's type
	 * @param experience the character's experience
	 * @param weapon the character's weapon
	 * @param mapPoint the coordinate on the map this character is located
	 * @param tileSetPoint the coordinate on the tileset this character is located
	 */
	public Character (double health, double power, double speed, double evade, String charType, int experience, 
	         Weapon weapon, Point mapPoint, Point tileSetPoint){
		this.health = health;
		this.power = power;
		this.speed = speed;
		this.evade = evade;
		this.charType = charType;
		this.level = level;
		this.weapon = weapon;
		this.mapPoint = mapPoint;
		this.tileSetPoint = tileSetPoint;
		
	}
	
	/**
	 * If possible moves the character one unit in a given direction.
	 * 
	 * @param direction The direction to move the character
	 * @param map The map to move the character on
	 */
	public void move(String direction, Map map ){
		Point[] tempPointArray;
		tempPointArray = map.checkMove(mapPoint, tileSetPoint, direction);
		mapPoint = tempPointArray[0];
		tileSetPoint = tempPointArray[1];
	}
	
//charType as follows: archer, mage, warrior	
	/**
	 * The toString
	 */
	public String toString(){
		return (charType+" Level: "+level+"\nHealth: "+health+"\nPower: "+power+"\nSpeed: "+speed+"\nEvade: "+evade+"\n\nWeapon:\n"+weapon);
	}
	
	//health  power  speed  evade  charType -- getters and setters
	/**
	 * The getter for health.
	 * 
	 * @return Returns the health of the character
	 */
	public double healthGetter() {
		return health;
	}
	public void healthSetter(double healthInput) {
		health = healthInput;
	}
	
	/**
	 * This method checks if the character is alive.
	 * 
	 * @return Returns true if the character is alive.
	 */
	public boolean isAlive(){
		return healthGetter() > 0;
	}
	
	public double powerGetter() {
		return power;
	}
	public void powerSetter(double powerInput) {
		power = powerInput;
	}
	
	public double speedGetter() {
		return speed;
	}
	public void speedSetter(double speedInput) {
		speed = speedInput;
	}
	
	public double evadeGetter() {
		return evade;
	}
	public void evadeSetter(double evadeInput) {
		evade = evadeInput;
	}
	
	public String charTypeGetter() {
		return charType;
	}
	public void charTypeSetter(String charTypeInput) {
		charType = charTypeInput;
	}
	
	public int levelGetter() {
		return level;
	}
	public void levelSetter(int levelInput) {
		level = levelInput;
	}
	
	public Weapon weaponGetter() {
		return weapon;
	}
	public void weaponSetter(Weapon weaponInput) {
		weapon = weaponInput;
	}
	
	public Point tileSetPointGetter(){
		return tileSetPoint;
	}
	public void tileSetPointSetter(Point tileSetInput){
		tileSetPoint = tileSetInput;
	}
	
	public Point mapPointGetter(){
		return mapPoint;
	}
	public void mapPointSetter(Point mapPointInput){
		mapPoint = mapPointInput;
	}
	
}

//player and enemy classes extend character
/**
 * The class of the character of the user. It adds potionList and a getter and setter to the character.
 * 
 * @author Bart and Jacob
 *
 */
class Player extends Character {
	private int experience;
	private Potion[] potionList;
	public Player(double health, double power, double speed, double evade, String charType, int level, Weapon weapon, int experience, Potion[] potionList,Point mapPoint,Point tileSetPoint) {
		super(health,power,speed,evade,charType,level,weapon,mapPoint,tileSetPoint);
		this.experience = experience;
		this.potionList = potionList;
	}
	public String toString(){
		return (charTypeGetter()+" Level: "+levelGetter()+" XP: "+experience+"\nHealth: "+healthGetter()+"\nPower: "+powerGetter()+"\nSpeed: "+speedGetter()+"\nEvade: "+evadeGetter()+"\n\nWeapon:\n"+weaponGetter());
	}
	
	public Potion[] getPotionList(){
		return potionList;
	}
	public void setPotion(Potion[] inList){
		potionList = inList;
	}
	//TODO Accessor, Mutator, and incrementor for experience.
}

/**
 * The abstract parent class of all nonplayer characters.
 * 
 * @author Bart and Jacob
 *
 */
abstract class NonPlayerCharacter extends Character{
	
	// tileNum: TODO: Figure out what it is
	private int tileNum;
	
	// talk: The message from the npc
	private String talk;
	
	/**
	 * 
	 * @param health
	 * @param power
	 * @param speed
	 * @param evade
	 * @param charType
	 * @param level
	 * @param weapon
	 * @param mapPoint
	 * @param tileSetPoint
	 * @param tileNum
	 * @param talk
	 */
	public NonPlayerCharacter(double health, double power, double speed, double evade, String charType, int level, Weapon weapon,Point mapPoint,Point tileSetPoint,int tileNum,String talk) {
		super(health,power,speed,evade,charType,level,weapon,mapPoint,tileSetPoint);
		this.tileNum = tileNum;
		this.talk = talk;
	}
	
	
	public int getTileNum(){
		return tileNum;
	}
	public String getTalk(){
		return talk;
	}
	
	public abstract void action();
}

//extend npc for enemy with attacking action or npc etc
//array of all NPCs in the game to find NonPlayerCharacter

class Enemy extends NonPlayerCharacter{
	public Enemy(double health, double power, double speed, double evade, String charType, int level, Weapon weapon,Point mapPoint,Point tileSetPoint,int tileNum,String talk) {
		super(health,power,speed,evade,charType,level,weapon,mapPoint,tileSetPoint,tileNum,talk);
	}	
	public void action(){
		System.out.println(getTalk());
		// TODO:initiate battle
	}
}

class Person extends NonPlayerCharacter{
	public Person(double health, double power, double speed, double evade, String charType, int level, Weapon weapon,Point mapPoint,Point tileSetPoint,int tileNum,String talk) {
		super(health,power,speed,evade,charType,level,weapon,mapPoint,tileSetPoint,tileNum,talk);
	}
	public void action(){
		System.out.println(getTalk());
	}
}
class Healer extends NonPlayerCharacter{
	public Healer(double health, double power, double speed, double evade, String charType, int level, Weapon weapon,Point mapPoint,Point tileSetPoint,int tileNum,String talk) {
		super(health,power,speed,evade,charType,level,weapon,mapPoint,tileSetPoint,tileNum,talk);
	}
	public void action(){
		System.out.println(getTalk());
		//TODO: initiate heals
		//scanner 
		//1. Heal (cost,gain)  2. Leave
	}
}
class Teleporter extends NonPlayerCharacter{
	public Teleporter(double health, double power, double speed, double evade, String charType, int level, Weapon weapon,Point mapPoint,Point tileSetPoint,int tileNum,String talk) {
		super(health,power,speed,evade,charType,level,weapon,mapPoint,tileSetPoint,tileNum,talk);
	}
	public void action(){
		System.out.println(getTalk());
		//TODO: initiate Teleport to new zone/map.
	}
}


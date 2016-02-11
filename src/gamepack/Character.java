package gamepack;


/**
 * The character class that is the parent class for all characters. 
 * 
 * @author Bart and Jacob
 * 
 * Outline:
 * Character
 * 		Player
 * 		Enemy
 * 			Baddie
 * 			Teleporter
 * 		NonPlayerCharacter
 * 			Person
 * 			Healer
 * 
 */
public abstract class Character {
	
	//chartype: the type or kind of character being created, used as a categorization tool through naming
	private String charType;
	
	// mapPoint: the coordinate on the map this character is located
	private Point mapPoint;
	
	// tileSetPoint: the coordinate on the tileset this character is located
	private Point tileSetPoint;
	
	/**
	 * This is the Character constructor.
	 * 
	 * @param charType the character's type
	 * @param mapPoint the coordinate on the map this character is located
	 * @param tileSetPoint the coordinate on the tileset this character is located
	 */
	public Character (String charType, Point mapPoint, Point tileSetPoint){
		this.charType = charType;
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
	

	/**
	 * The toString
	 */
	public String toString(){
		return "";
	}
	
	
	public String getCharType() {
		return charType;
	}
	public void setCharType(String charTypeInput) {
		charType = charTypeInput;
	}
	
	public Point getTileSetPoint(){
		return tileSetPoint;
	}
	public void setTileSetPoint(Point tileSetInput){
		tileSetPoint = tileSetInput;
	}
	
	public Point getMapPoint(){
		return mapPoint;
	}
	public void setMapPoint(Point mapPointInput){
		mapPoint = mapPointInput;
	}
	
}


/**
 * The class of the character of the user. It adds potionList and a getter and setter to the character.
 * 
 * @author Bart and Jacob
 * 
 * @param inventory
 * @param stats
 * @param enchantment
 *
 */
class Player extends Character {
	private Inventory inventory;
	private playerStats stats;
	public Player(String charType,Point mapPoint,Point tileSetPoint,Inventory inventory,playerStats stats) {
		super(charType,mapPoint,tileSetPoint);
		this.inventory=inventory;
		this.stats=stats;
	}
	public String toString(){
		return "";
	}
	
	public void setInventory(Inventory inventory){
		this.inventory=inventory;
	}
	public Inventory getInventory(){
		return inventory;
	}
	
	
	public void setStats(playerStats stats){
		this.stats=stats;
	}
	public playerStats getStats(){
		return stats;
	}
	
	//TODO Accessor, Mutator, and incrementor
}

/**
 * The abstract parent class of all nonplayer characters.
 * 
 * @author Bart and Jacob
 *
 */
abstract class Enemy extends Character{
	
	/**
	 * @param stats the stats for the Enemy
	 * @param talk what the Enemy says
	 */
	
	//the stats to keep track of during a battle
	private Stats stats;
	
	//what the enemy says of an encounter (after/before)
	private String talk;
	
	//an Enemy does not have an inventory but rather carries the weapon separately
	private Weapon weapon;
	
	public Enemy(String charType,Point mapPoint,Point tileSetPoint,String talk,Stats stats,Weapon weapon) {
		super(charType,mapPoint,tileSetPoint);
		this.talk = talk;
		this.stats=stats;
		this.weapon=weapon;
	}
	
	public String getTalk(){
		return talk;
	}
	
	public void setStats(Stats stats){
		this.stats=stats;
	}
	public Stats getStats(){
		return stats;
	}
	
	public void setWeapon(Weapon weapon){
		this.weapon=weapon;
	}
	public Weapon getWeapon(){
		return weapon;
	}
	
	public abstract void action();
}

abstract class NonPlayerCharacter extends Character{
	
	private String talk;
	
	public NonPlayerCharacter(String charType, Point mapPoint, Point tileSetPoint, String talk) {
		super(charType, mapPoint, tileSetPoint);
		this.talk = talk;
	}
	
	public String getTalk(){
		return talk;
	}
	
	public void setTalk(String talk){
		this.talk=talk;
	}
	
	public abstract void action();
}

class Baddie extends Enemy{
	
	public Baddie(String charType,Point mapPoint,Point tileSetPoint,String talk,Stats stats,Weapon weapon) {
		super(charType,mapPoint,tileSetPoint,talk,stats,weapon);
	}
		
	public void action(){
		System.out.println(getTalk());
		// TODO:initiate battle
	}
}

class Teleporter extends Enemy{
	
	public Teleporter(String charType,Point mapPoint,Point tileSetPoint,String talk,Stats stats,Weapon weapon) {
		super(charType,mapPoint,tileSetPoint,talk,stats,weapon);
	}
	public void action(){
		System.out.println(getTalk());
		
		//TODO: initiate battle with Player
		//TODO: initiate Teleport to new zone/map.
	}
}

class Person extends NonPlayerCharacter{
	public Person(String charType,Point mapPoint,Point tileSetPoint,String talk) {
		super(charType,mapPoint,tileSetPoint,talk);
	}
	public void action(){
		System.out.println(this.getTalk());
	}
}

class Healer extends NonPlayerCharacter{
	public Healer(String charType,Point mapPoint,Point tileSetPoint,String talk) {
		super(charType,mapPoint,tileSetPoint,talk);
	}
	public void action(){
		System.out.println(getTalk());
		//TODO: initiate heals
		//scanner 
		//1. Heal (cost,gain)  2. Leave
	}
}



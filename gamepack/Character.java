package gamepack;


/**
 * The character class that is the parent class for all characters. 
 * 
 * @author Bart and Jacob
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
	private Stats stats;
	private Enchantment enchantment;
	public Player(String charType,Point mapPoint,Point tileSetPoint,Inventory inventory,Stats stats, Enchantment enchantment) {
		super(charType,mapPoint,tileSetPoint);
		this.inventory=inventory;
		this.stats=stats;
		this.enchantment=enchantment;
	}
	public String toString(){
		return "";
	}
	
	public Inventory getInventory(){
		return inventory;
	}
	
	public Stats getStats(){
		return stats;
	}
	
	public Enchantment getEnchantment(){
		return enchantment;
	}
	
	//TODO Accessor, Mutator, and incrementor
}

/**
 * The abstract parent class of all nonplayer characters.
 * 
 * @author Bart and Jacob
 *
 */
abstract class NonPlayerCharacter extends Character{
	
	// talk: The message from the npc
	private String talk;
	
	/**
	 * 
	 * @param charType
	 * @param mapPoint
	 * @param tileSetPoint
	 * @param tileNum
	 * @param talk
	 */
	public NonPlayerCharacter(String charType,Point mapPoint,Point tileSetPoint,String talk) {
		super(charType,mapPoint,tileSetPoint);
		this.talk = talk;
	}
	
	public String getTalk(){
		return talk;
	}
	
	public abstract void action();
}

//extend npc for enemy with attacking action or npc etc
//array of all NPCs in the game to find NonPlayerCharacter

class Enemy extends NonPlayerCharacter{
	public Enemy(String charType,Point mapPoint,Point tileSetPoint,String talk) {
		super(charType,mapPoint,tileSetPoint);
	}
	
//left off doing some basic edits VISUAL SIGNPOST
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		
		//TODO: initiate battle with Player
		//TODO: initiate Teleport to new zone/map.
	}
}


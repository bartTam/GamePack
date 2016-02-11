package gamepack;

//is a mess
//ignore status is for enchantments still todo

public abstract class Status {

	//The amount of turns the status has remaining.
	private int turnsRemaining;

	public Status(int turnsRemaining){
		this.turnsRemaining = turnsRemaining;
	}

	public abstract void inflictStatus(Player player);

	public void setTurnsRemaining(int turnsRemaining){
		this.turnsRemaining = turnsRemaining;
	}

	public int getTurnsRemaining(){
		return turnsRemaining;
	}
	
	public boolean statusActive(){
		return turnsRemaining>0;
	}

}

class DamageReductionStatus extends Status {

	public DamageReductionStatus(int turnsRemaining){
		super(turnsRemaining);	
	}

	public void inflictStatus(Player player){
		player.reduceDamage();
	}

}

class SpeedIncrease extends Status{

	public SpeedIncrease(int turnsRemaining){
		super(turnsRemaining);	
	}

	public void inflictStatus(Player player){
		player.increaseSpeed();
	}

}

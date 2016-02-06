package gamepack;

//is a mess

public abstract class Status {

	//The amount of turns the status has remaining.
	private int turnsRemaining;

	public Status(int turnsRemaining){
		this.turnsRemaining = turnsRemaining;
	}

	public abstract void inflictStatus();

	public void setTurnsRemaining(int turnsRemaining){
		this.turnsRemaining = turnsRemaining;
	}

	public int getTurnsRemaining(){
		return turnsRemaining;
	}

}

class DamageReductionStatus {

	public DamageReductionStatus(int turnsRemaining){
		super(turnsRemaining);	
	}

	public void inflictStatus(Player player){
		player.reduceDamage();
	}

}

class SpeedIncrease{

	public SpeedIncrease(int turnsRemaining){
		super(turnsRemaining);	
	}

	public void inflictStatus(Player player){
		player.increaseSpeed();
	}

}

package project;

public class LimitedPlayer extends Player{
	public LimitedPlayer(String name) {
		super(name+" (Limited)");
		super.setScore(50);
	}
}

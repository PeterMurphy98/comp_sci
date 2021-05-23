package project;

public class VIPPlayer extends Player {
	public VIPPlayer(String name) {
		super(name+" (VIP)");
		super.setScore(500);
	}
}

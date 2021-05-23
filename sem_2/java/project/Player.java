package project;

public class Player implements Comparable<Player>{
	// Class variables
	private static int numberOfPlayers = 0;
	
	// Instance variables
	private int id;
	private String name;
	private double score = 100;
	
	public Player(String name) {
		this.name = name;
		id = ++numberOfPlayers;
	}
	
	public String getName() {
		return name;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double s) {
		this.score = s;
	}
	
	public void addToScore(double result) {
		this.score += result;
	}
	
	public String toString() {
		return "id: " + id + ", name: " + name + ", score: " + score;
	}
	
	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public int compareTo(Player p) {
		if (score == p.getScore()) {
			return 0;
		}
		else if (score < p.getScore()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}

package project;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		Scanner input = new Scanner(System.in);
		// Main menu loop
		while (true) {
			System.out.format("Please choose an option: \n1. New Player \n2. Quit\n");
			int option = input.nextInt();
			if (option == 1) {
				System.out.println("Please enter a name:");
				String name = input.next();
				System.out.format("What type of player are you? \n1. VIP \n2. Limited \n3. None of the above\n");
				int type = input.nextInt();
				Player newPlayer;
				if (type == 1) {
					newPlayer = new VIPPlayer(name);
					players.add(newPlayer);
				}
				else if (type == 2){
					newPlayer = new LimitedPlayer(name);
					players.add(newPlayer);
				}
				else {
					newPlayer = new Player(name);
					players.add(newPlayer);
				}
				// Games menu loop
				chooseGame(newPlayer, input);
			}
			else if (option == 2) {
				Leaderboard(players);
				break;
			}
			else {
				System.out.println("Error. Invalid entry.");
			}
		}
		input.close();
	}
		
	public static void chooseGame(Player newPlayer, Scanner input) {
		while (true) {
			System.out.format("Hello %s, Please choose a game, or -1 to quit: \n1. Rock, Paper, Scissors \n2. CoinFlip\n", newPlayer.getName());
			int game = input.nextInt();
			if (game == 1) {
				double bet = chooseBet(newPlayer, input);
				RockPaperScissors(newPlayer, bet, input);
			}
			else if (game == 2) {
				double bet = chooseBet(newPlayer, input);
				CoinFlip(newPlayer, bet, input);
			}
			else if (game == -1){
				break;
			}
		}
	}
	
	public static double chooseBet(Player newPlayer, Scanner input) {
		System.out.format("Enter an amount to bet:\n");
		double bet = input.nextDouble();
		if (newPlayer instanceof LimitedPlayer) {
			// Limited players can only bet up to 20% of their score
			while(bet > newPlayer.getScore()*0.2 || bet < 0) {
				if (bet > 0) {
					System.out.println("Error: bet is too high. Try again:");
					bet = input.nextDouble();
				}
				else {
					System.out.println("Error: bet must be non-negative. Try again:");
					bet = input.nextDouble();
				}
			}
		}
		else {
			while(bet > newPlayer.getScore() || bet < 0) {
				if (bet > 0) {
					System.out.println("Error: bet is too high. Try again:");
					bet = input.nextDouble();
				}
				else {
					System.out.println("Error: bet must be non-negative. Try again:");
					bet = input.nextDouble();
				}
			}
		}
		return bet;
	}
		
	public static String rpsChoice(int choice) {
		if (choice == 1) {
			return "Rock";
		}
		else if (choice == 2) {
			return "Paper";
		}
		else if (choice == 3){
			return "Scissors";
		}
		else {
			return "Error. Invalid entry.";
		}
	}
	
	public static void RockPaperScissors(Player p, double bet, Scanner input) {
		Random rand = new Random();
		System.out.println("Lets play 3 rounds of Rock, Paper, Scissors!");
		int count = 0;
		for (int i = 0; i < 3; i++){
			System.out.format("Choose from below: \n1. Rock \n2. Paper \n3. Scissors \n");
			int choice = input.nextInt();
			int opponent = rand.nextInt(3)+1;
			if (choice == opponent) {
				System.out.format("You chose %s, I chose %s, result: draw.\n", rpsChoice(choice), rpsChoice(opponent));
			}
			else {
				if (opponent == ((choice % 3) + 1)){
					count -= 1;
					System.out.format("You chose %s, I chose %s, result: you lose.\n", rpsChoice(choice), rpsChoice(opponent));
				}
				else {
					count += 1;
					System.out.format("You chose %s, I chose %s, result: you win.\n", rpsChoice(choice), rpsChoice(opponent));
				}
			}
		}
		if (count == 0) {
			System.out.format("Overall result: draw, your bet was returned.\n");
			bet = 0;
		}
		else if (count < 0) {
			System.out.format("Overall result: your bet lost.\n");
			bet *= -1;
		}
		else {
			System.out.format("Overall result: your bet won.\n");
			// VIP's get 10% extra win bonus
			if (p instanceof VIPPlayer) {
				bet *= 1.1;
			}
		}
		p.addToScore(bet);
	}
	
	public static void CoinFlip(Player p, double bet, Scanner input) {
		Random rand = new Random();
		System.out.println("Lets play CoinFlip! Geuss at least 3 out of 5 correctly to win your bet:");
		int count = 0;
		for (int i = 0; i < 5; i++) {
			System.out.format("Choose from below: \n1. Heads \n2. Tails \n");
			int choice = input.nextInt();
			int coin = rand.nextInt(2)+1;
			if (coin == 1) {
				System.out.println("The result was Heads.");	
			}
			else {
				System.out.println("The result was Tails.");					
			}
			if (choice == coin) {	
				count++;
			}
		}
		if (count < 3) {
			System.out.format("You got %d correct: your bet lost.\n", count);
			p.addToScore(-bet);
		}
		else {
			System.out.format("You got %d correct: your bet won.\n", count);
			p.addToScore(bet);
		}
	}
	
	public static void Leaderboard(ArrayList<Player> players) {
		try {
			File f = new File("leaderboard.txt");
			f.createNewFile();
		} 
		catch (IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		 
		try {
			FileWriter fw = new FileWriter("leaderboard.txt", true);
			System.out.println("Player : Points");
			Collections.sort(players);
			for (Player p: players) {
				System.out.format("%s : %,.2f\n", p.getName(), p.getScore());
				fw.write(String.format("%s : %,.2f\n", p.getName(), p.getScore()));
			}
			fw.close();
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();			 
		}
	}
}

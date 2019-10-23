package RockPaperScissors;
import java.util.Scanner;
import java.util.Random;

public class Game {
	
	//valid input: rock , paper , scissor, r,p,s
	
	public static void main(String[] args) {
		
		try {
			Scanner scan = new Scanner(System.in);
			if(scan.hasNext()) { //check for null values
				String userInput = quickFormat( scan.next());
				scan.close();
				
				if(isValid( userInput )) {
					game( userInput );
					
				} else {
					displayInputs();
				}
			}else {
				displayInputs(); // null value, displaying correct inputs
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void game(String user) {
		String computer = computerResults();
		
		print(user + " vs " + computer + "\n");
		
		if(user.equalsIgnoreCase(computer)) {
			print("You won against the computer!");
		}else {
			print("You lost against the computer!");
		}
		
	}

	private static String computerResults() {
		String types[] = {"rock","paper","scissors"};
		Random rand = new Random();
		int computerChoice = rand.nextInt(3);
		
		return types[computerChoice];
	}
	
	public static boolean isValid(String input) {
		switch(input.toLowerCase()) {
		case "rock": return true;
		case "paper": return true;
		case "scissors": return true;
		default: return false;
		}
	}
	
	public static boolean checkWin(String user, String opponent) {
		
		if((!isValid( user)) || (!isValid( opponent )) ) {
			return false;
		}
		String rock = "rock", paper = "paper" , scissors = "scissors";
		
		if( (user.equalsIgnoreCase( rock )) && (opponent.equalsIgnoreCase( scissors)) ) {
			return true;
		}
		if( (user.equalsIgnoreCase(scissors)) && (opponent.equalsIgnoreCase(paper)) ) {
			return true;
		}
		if( (user.equalsIgnoreCase(paper)) && (opponent.equalsIgnoreCase(rock)) ) {
			return true;
		}
		
		return false; //if no win assume loss
	}
	public static void displayInputs() {
		print("Invalid user input!\nWrite rock , paper , scissors!");
	}
	
	public static void print(String text) {
		//makes printing text easier
		System.out.println( text );
	}
	public static String quickFormat(String input) {
		//quick functions to shorten inputs
		String output = input;
		
		switch (input.toLowerCase()) {
		case "r": output = "rock";
		break;
		case "p" : output = "paper";
		break;
		case "s" : output = "scissors";
		break;
		}
		return output;
	}

}

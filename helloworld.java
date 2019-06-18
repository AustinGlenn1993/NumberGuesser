package NumberGuess;

import java.util.Scanner;

public class helloworld {

//variables
static Scanner input = new Scanner(System.in);




public static void main(String[] args) {
	playGame();
}

public static void playGame() {
	calculator calc = new calculator();	
	
	System.out.println("Welcome to Guess that number!");
	System.out.println("You will get a certain number of guesses to guess a number based off of your range you want to guess.");		
	System.out.println("Type in the range you want to guess your number from!");
	calc.calculateFromRange(input.nextInt());
	System.out.println("Hmmmm..... I'm thinking.");
	System.out.println("...");
	System.out.println("...");
	System.out.println("...");
	System.out.printf("Okay I have a number. I will give you %d guesses to figure it out. Go ahead. Give it your best shot!\n", calc.getNumberOfGuesses());
	
	while (calc.endOfGame == false)
	{
		calc.makeGuess(input.nextInt());
	}
	
	//Checks to restart game
	checkForRestart();
}


public static void endGame() {
	System.out.println("GAME OVER!");
	input.close();
}

public static void checkForRestart() {
	System.out.println("Would you like to play again? (1 for yes / 0 for no)");
	int check = input.nextInt();

	if (check == 1)
	{
		playGame();

	}
	else if (check == 0)
	{
		endGame();
	}
	else
	{
		System.out.println("You must select '1' for yes or '0' for no");
		checkForRestart();
	}
}

}

package NumberGuess;

public class calculator {

	private int numberOfGuesses = 0;
	private int guessesTaken = 0;
	private int range = 0;
	private int numberToGuess = 0;
	private int[] guesses;
	
	public boolean endOfGame = false;
	
	
//Constructor
public calculator()
{
	
}
	



//FUNCTIONS
//Getters and Setters
public void setNumberOfGuesses(int num) {
	numberOfGuesses = num;
}

public int getNumberOfGuesses() {
	return numberOfGuesses;
}



//Calculation functions
public void calculateFromRange(int rng) {
	//gets 15 percent of the range and gives you that amount 
	//this will calculate how many guesses you should get from the range
	range = rng;
	double var = (Math.log(range))*2;
	
	
	if (var < 5) {
		//check to make sure you have at least 3 guess no matter the number.
		numberOfGuesses = 3;
		guesses = new int[numberOfGuesses];
	}
	else
	{
		//sets number of guesses to the formula
		numberOfGuesses = (int) var;
		guesses = new int[numberOfGuesses];
	}
	
	//picks a number to guess
	numberToGuess = (int)(Math.random()*range);
}

public String calculateScore(boolean win) {
	//Gets the composite of the difference between every guess and the actual number
	float composite = 0.0f;
	for (int num : guesses)
	{
			composite += (Math.abs(numberToGuess - num));
	}
	
	// uses the formula to guess
	if (win) {
		return "" + (((range*((numberOfGuesses + 2) - guessesTaken))*.5)-(Math.log((double)composite)));
	}
	else
	{
		return "" + (range-composite);
	}
	
}






//During Game functions
public void makeGuess(int guess) {

	if (guess==numberToGuess && guessesTaken < numberOfGuesses) {
		System.out.println("How did you do that? You were right!");
		guesses[guessesTaken] = guess;
		guessesTaken += 1;
		endGame(true);
	}
	else if (numberOfGuesses-guessesTaken > 1)
	{
		guesses[guessesTaken] = guess;
		guessesTaken += 1;
		System.out.printf("Nope, " + giveHint(guess) + "! You have %d guesses left!\n", numberOfGuesses-guessesTaken);
	
	}
	else
	{
		endGame(false);
	}

		
}
public String giveHint(int guess)
{
	String hint = new String("");
	if (guess > numberToGuess)
	{
		if(range-guess>(range/2)) {
			hint = "Your guess is greater than my number";
		}
		else
		{
			hint = "My number is less than your number";
		}
		return hint;
	}
	else
	{
		if(range-guess>(range/2)) {
			hint = "Your guess is less than my number";
		}
		else
		{
			hint = "My number is greater than your number";
		}
		return hint;
	} 
	
}






// Start and End of Game Functions
public void endGame(boolean win) {
	endOfGame = true;
	if (win) {
		System.out.println("Congrats! You win!");
		System.out.printf("Your score was " + calculateScore(true) + ", and it only took you %d guesses!\n", guessesTaken);
	}
	else
	{
		System.out.println("Sorry! You're out of guesses. I win!");
		System.out.println("Your score was " + calculateScore(false) + ", and too bad. You're still a loser.");
	}
}
public void startGame() {
	
}







//Clear
public void clear() {
	numberOfGuesses = 0;
	guessesTaken = 0;
	range = 0;
	numberToGuess = 0;
}

}

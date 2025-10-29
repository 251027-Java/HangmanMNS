import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class HangmanGame {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        // array of words, picked at random
        Random random = new Random();
        String[] myArray = {"spiderman", "superman", "ironman", "batman", "thor", "flash"};
        int randomIndex = random.nextInt(myArray.length);
        String word = myArray[randomIndex];

        // create an array size using the previous int
        String[] blankWord = new String[word.length()];

        //Fill each element in array with "_"
        String fillChar = "_";
        Arrays.fill(blankWord, fillChar);

        // Print out blankWord
        System.out.print(Arrays.toString(blankWord));


        // prompt the user for a guess
        char guessLetter;       //The user's current guess letter
        guessLetter = '_';
        List<Character> incorrectGuesses = new ArrayList<>();       //the list of the incorrect characters
        char[] correctGuess = new char[word.length()];      //The Array of the guess so far
        int guessesLeft = 7;        //The amount of incorrect guesses the user has left
        boolean playing = true;     //denotes if we are still playing the game

        //Main loop to continue playing until the word was guessed or there are no guesses left
        while(guessesLeft > 0 && playing){
            boolean correct = false;

            //Verifies that the entry of teh character was correct
            while (!correct){
                String guess = IO.readln("Please enter a one letter guess: ");
                if(guess.length() == 1){
                    correct = true;
                    guessLetter = guess.charAt(0);
                }
                else{
                    IO.println("Your guess was invalid, please guess again");
                }
            }
            //Runs through the word to see if there are any matching iteracies
            boolean guessFound = false;
            for(int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guessLetter) {
                    correctGuess[i] = word.charAt(i);
                    guessFound = true;
                    IO.println(Arrays.toString(correctGuess));
                    if (Arrays.equals(correctGuess, word.toCharArray())) {
                        playing = false;
                        IO.println("Congrats! You won the game.");
                    }
                }
            }

            //if there were no guesses found it lets the users know how many have left and the letters they have chosen
            if (!guessFound) {
                IO.println("Your guess was incorrect.");
                guessesLeft -= 1;
                incorrectGuesses.add(guessLetter);
                IO.println("Guesses left: " + guessesLeft);
                IO.println("Letters guessed: " + incorrectGuesses);
                if (guessesLeft == 0){
                    IO.println("No more guesses left, game over.");
                }
            }


        }

    }
}
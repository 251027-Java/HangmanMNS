import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class HangmanGame {
    public static void main() {
        // array of words, picked at random (or one word)
        // give the person the length of the word
        // prompt the user for a guess
        String word = "word";   // Temp word
        char guessLetter;       //The user's current guess letter
        guessLetter = '_';
        List<Character> incorrectGuesses = new ArrayList<>();       //the list of the incorrect characters
        char[] correctGuess = new char[word.length()];      //The Array of the guess so far
        int guessesLeft = 7;        //The amount of incorrect guesses the user has left
        boolean playing = true;     //denotes if we are still playing the game

        while(guessesLeft > 0 && playing){
            boolean correct = false;
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
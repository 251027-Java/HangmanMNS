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
        String word = "word";
        char guessLetter;
        guessLetter = '_';
        List<Character> incorrectGuesses = new ArrayList<>();
        char[] correctGuess = new char[word.length()];
        int guessesLeft = 7;
        while(guessesLeft > 0){
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
            for(int i = 0; i < word.length(); i++){
                if (word.charAt(i) == guessLetter){
                    correctGuess[i] = word.charAt(i);
                    guessFound = true;
                    IO.println(Arrays.toString(correctGuess));
                }
            }
            if (!guessFound){
                IO.println("Your guess was incorrect.");
                guessesLeft -= 1;
                incorrectGuesses.add(guessLetter);
                IO.println("Guesses left: " + guessesLeft);
                IO.println("Letters guessed: " + incorrectGuesses);

            }

        }


        // if right add it in the word with dashes
        // if not, add to the bucket list and tally incorrect guesses and incorrect guesses remaining
        // if person runout of guesses game ends
        // if guesses the word correctly the person wins and game ends
    }
}

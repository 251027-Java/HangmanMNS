import java.util.Scanner;

public class HangmanGame {
    public static void main() {
        // array of words, picked at random (or one word)
        // give the person the length of the word
        // prompt the user for a guess

        // if right add it in the word with dashes
        // if not, add to the bucket list and tally incorrect guesses and incorrect guesses remaining

        // Manu
        // if person runout of guesses game ends
        // if guesses the word correctly the person wins and game ends

        // Made a rough outline so everyone can add logic in their part
        // Feel free to replace whatever part of this code
        boolean playing = true;
        int mistakes = 0;
        while(playing)
        {
            // game played in here
            String word = ""; // the randomly picked word
            char guess = 'e';  // the guess
            char[] currentProgress = new char[word.length()];

            // each guess either adds to mistakes
            if(word.indexOf(guess) == -1) {
                mistakes++;
            }
            // or is added to currentProgress
            else {
                // probably use indexOf and add letter to currentProgress at that index
                currentProgress[0] = 'y';
            }

            if(mistakes == 7) {
                playing = false;
                IO.println("Sorry, no more guesses left. Game over.");
            } else if(currentProgress.toString().equals(word)) {
                playing = false;
                IO.println("Congrats! You won the game.");
            }
        }
    }
}
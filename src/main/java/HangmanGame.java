import java.nio.file.*;
import java.io.IOException;
import java.util.Random;import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class HangmanGame {
    public static void main() throws IOException {

        // Getting random word from the word bank
        String content = Files.readString(Path.of("src/main/java/Hangman_wordbank.txt"));

        String[] words = content.split(",\\s*");

        Random rand = new Random();
        String word = words[rand.nextInt(words.length)];


        // create an array size using the previous int
        char[] blankWord = new char[word.length()];      //The Array of the guess so far

        //Fill each element in array with "_"
        char fillChar = '_';
        Arrays.fill(blankWord, fillChar);

        // Print out blankWord
        System.out.print(Arrays.toString(blankWord));


        char guessLetter;       //The user's current guess letter
        guessLetter = '_';

        List<Character> incorrectGuesses = new ArrayList<>();       //the list of the incorrect characters
        char[] correctGuess = new char[word.length()];      //The Array of the guess so far

        int guessesLeft = 7;        //The amount of incorrect guesses the user has left
        boolean playing = true;     //Denotes if we are still playing the game

        //Main loop to continue playing until the word was guessed or there are no guesses left
        while(guessesLeft > 0 && playing){
            boolean correct = false;

            //Verifies that the entry of the character was correct
            while (!correct){
                String guess = IO.readln("Please enter a one letter guess: ");

                // guess must be exactly one letter
                if(guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
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

                // if the guess was right, update the display
                if (word.charAt(i) == guessLetter) {
                    blankWord[i] = word.charAt(i);
                    guessFound = true;

                    // display
                    IO.println("Your guess was correct.");
                    IO.println(makeDrawing(guessesLeft));
                    IO.println(Arrays.toString(blankWord));
                    IO.println("Incorrect guesses: " + incorrectGuesses);

                    // if the entire word has been guessed, the game has been won
                    if (Arrays.equals(blankWord, word.toCharArray())) {
                        playing = false;
                        IO.println("Congrats! You won the game.");
                    }
                }
            }

            //if the guess was wrong, it lets the users know how many have left and the letters they have chosen
            if (!guessFound) {
                IO.println("Your guess was incorrect.");

                // Guesses left is decremented
                guessesLeft -= 1;

                IO.println(makeDrawing(guessesLeft));
                incorrectGuesses.add(guessLetter);
                IO.println(guessesLeft + " more wrong answers and you lose.");
                IO.println("Incorrect guesses: " + incorrectGuesses.toString());
                IO.println(Arrays.toString(blankWord));

                // if there are no more guesses left, game ends
                if (guessesLeft == 0){
                    IO.println("No more guesses left, game over.");
                }
            }
            IO.println();
        }

    }

    // Returns the hangman drawing for each turn
    // The drawing updates based on the number of incorrect guesses left
    public static String makeDrawing(int version)
    {
        String drawing = "";
        switch (version) {
            case 6: // adds the pole
                drawing = " _____\n|     |\n|\n|\n|\n|\n|\n|\n|\n==========";
                break;

            case 5: // adds the head
                drawing = " _____\n|     |\n|    ( )\n|\n|\n|\n|\n|\n|\n==========";
                break;

            case 4: // adds the spine
                drawing = " _____\n|     |\n|    ( )\n|     |\n|     |\n|     |\n|\n|\n|\n==========";
                break;

            case 3: // adds the first arm
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\n|     |\n|\n|\n|\n==========";
                break;

            case 2: // adds the second arm
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\\ \n|     |\n|\n|\n|\n==========";
                break;

            case 1: // adds the first leg
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\\ \n|     |\n|    /\n|\n==========";
                break;

            case 0: // adds the second leg
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\\ \n|     |\n|    / \\ \n|\n==========";
                break;
        }
        return drawing;
    }
}

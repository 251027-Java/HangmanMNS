import java.nio.file.*;
import java.io.IOException;
import java.util.Random;import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class HangmanGame {
    public static void main() throws IOException {

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
                    blankWord[i] = word.charAt(i);
                    guessFound = true;
                    IO.println(makeDrawing(guessesLeft));
                    IO.println(Arrays.toString(blankWord));
                    IO.println("Letters guessed: " + incorrectGuesses);
                    if (Arrays.equals(blankWord, word.toCharArray())) {
                        playing = false;
                        IO.println("Congrats! You won the game.");
                    }
                }
            }

            //if there were no guesses found it lets the users know how many have left and the letters they have chosen
            if (!guessFound) {
                IO.println("Your guess was incorrect.");
                guessesLeft -= 1;
                IO.println(makeDrawing(guessesLeft);
                incorrectGuesses.add(guessLetter);
                IO.println(guessesLeft + " more wrong answers and you lose.");
                IO.println(Arrays.toString(correctGuess));
                IO.println("Letters guessed: " + incorrectGuesses);
                if (guessesLeft == 0){
                    IO.println("No more guesses left, game over.");
                }
            }


        }

    }
    // there are multiple versions of the drawing
    // the drawing you get depends on the value of guessesLeft
    public static String makeDrawing(int version)
    {
        String drawing = "";
        switch (version) {
            case 7:
                drawing = "";
                break;
            case 6:
                drawing = " _____\n|     |\n|\n|\n|\n|\n|\n|\n|\n==========";
                break;
            case 5:
                drawing = " _____\n|     |\n|    ( )\n|\n|\n|\n|\n|\n|\n==========";
                break;
            case 4:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|     |\n|     |\n|\n|\n|\n==========";
                break;
            case 3:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\n|     |\n|\n|\n|\n==========";
                break;
            case 2:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\\ \n|     |\n|\n|\n|\n==========";
                break;
            case 1:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\\ \n|     |\n|    /\n|\n==========";
                break;
            case 0:
                drawing = " _____\n|     |\n|    ( )\n|     |\n|    /|\\ \n|     |\n|    / \\ \n|\n==========";
                break;
        }
        return drawing;
    }
}

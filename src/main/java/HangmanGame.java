import java.nio.file.*;
import java.io.IOException;
import java.util.Random;import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            while (!correct) {
                String guess = IO.readln("Please enter a one letter guess: ");
                char enteredChar = guess.charAt(0);
                Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                Matcher m = p.matcher(guess);
                if (Character.isDigit(enteredChar)) {
                    IO.println("Your guess was invalid, please guess again");
                } else if (guess.length() != 1) {
                    IO.println("Your guess was invalid, please guess again");
                } else if ((m.find())){
                    IO.println("Your guess was invalid, please guess again");
                }else{
                    correct = true;
                    guessLetter = guess.charAt(0);
                }

            }
            //Runs through the word to see if there are any matching iteracies
            boolean guessFound = false;
            for(int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guessLetter) {
                    blankWord[i] = word.charAt(i);
                    guessFound = true;
                    IO.println(Arrays.toString(blankWord));
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
                incorrectGuesses.add(guessLetter);
                IO.println("Guesses left: " + guessesLeft);
                IO.println("Letters guessed: " + incorrectGuesses);
                if (guessesLeft == 0){
                    IO.println("No more guesses left, game over.");
                    IO.println("The word was:" + word);
                }
            }


        }

    }
}
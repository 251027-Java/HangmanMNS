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

        // give the person the length of the word
        //create integer to establish array size
        int a = 0;
        for (int i = 0; i < myArray[randomIndex].length(); i++ ){
            a = a + 1;
        }

        // create an array size using the previous int
        String[] blankWord = new String[a];

        //Fill each element in array with "_"
        String fillChar = "_";
        Arrays.fill(blankWord, fillChar);

        // Print out blankWord
        System.out.print(Arrays.toString(blankWord));


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
        boolean playing = true;
        int mistakes = 0;
        while(playing)
        {
            // game played in here
            String word = "yes"; // the randomly picked word
            char guess = 'e';  // the guess
            char[] currentProgress = new char[word.length()];

            // each guess either adds to mistakes
            if(word.indexOf(guess) == -1) {
                IO.println("wrong");
                mistakes++;
            }
            // or is added to currentProgress
            else {
                IO.println("right");
                // probably use indexOf and add letter to currentProgress at that index
                currentProgress[0] = 'y';
            }

            if(mistakes == 7) {
                playing = false;
                IO.println("Sorry, no more guesses left. Game over.");
            } else if(Arrays.equals(currentProgress, word.toCharArray())) {
                playing = false;
                IO.println("Congrats! You won the game.");
            }
        }
    }
}
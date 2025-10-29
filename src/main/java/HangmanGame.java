import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class HangmanGame {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        // array of words, picked at random (or one word)
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
        // if right add it in the word with dashes
        // if not, add to the bucket list and tally incorrect guesses and incorrect guesses remaining
        // if person runout of guesses game ends
        // if guesses the word correctly the person wins and game ends

    }
}

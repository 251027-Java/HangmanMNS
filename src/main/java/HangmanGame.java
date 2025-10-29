import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        // array of words, picked at random (or one word)
        Random random = new Random();
        String[] myArray = {"spiderman", "superman", "ironman", "batman"};
        int randomIndex = random.nextInt(myArray.length);
        System.out.println(myArray[randomIndex]);
        String blankArray = myArray[randomIndex];

        // give the person the length of the word


        // prompt the user for a guess
        // if right add it in the word with dashes
        // if not, add to the bucket list and tally incorrect guesses and incorrect guesses remaining
        // if person runout of guesses game ends
        // if guesses the word correctly the person wins and game ends

    }
}

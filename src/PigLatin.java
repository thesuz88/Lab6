import java.util.Scanner;

/**
 * Created by Steve on 6/30/2017.
 * 1. Display welcome message and prompt user for word
 * 2. Get user input
 * 3. Translate that word to pig latin
 * 4. Display result
 * 5. Prompt user to continue with loop
 * <p>
 * Extra
 * take that process and translate two words -- eventually whole string
 * validate that only letters get translated
 * validate keeping case of word
 */
public class PigLatin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String result;
        String userWord;
        String choice = "y";
        //Display welcome message and prompt for word from user
        System.out.println("Welcome to the pig latin translator!");

        while (choice.equalsIgnoreCase("y")) {
            System.out.println("Enter a word to be translated: ");
            userWord = scan.nextLine();

            //convert to lowercase before translating
            userWord = userWord.toLowerCase();

            //isVowel will only work for one word translations
            if (isVowel(userWord)) {
                //vowels method
                result = translateWithVowel(userWord);
            } else {
                //consonants method
                result = translateWithConsonant(userWord);
            }
            //print out result
            System.out.println("Pig latin translation: " + result);

            //Play again?
            System.out.println("\nWould you like to translate another word? (y/n)");
            choice = scan.nextLine();
        }
        System.out.println("Good luck with your pig latin! Good bye.");
    }

    //Translates word starting with a consonant
    public static String translateWithConsonant(String userWord) {
        int wordLength = userWord.length();
        int firstVowelFound = 0;

        //take all consonants up to the first vowel...How do i get program to stop at vowel?
        for (int i = 0; i < wordLength; i++) {
            char c = userWord.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {

                firstVowelFound = i;
                break; //without this break the last vowel is moved to the beginning
            }
        }
        String startString = userWord.substring(firstVowelFound, wordLength);
        String movedString = userWord.substring(0, firstVowelFound);

        userWord = startString + movedString + "ay";

        return userWord;
    }
    //Translates word starting with a vowel pig latin logic
    public static String translateWithVowel(String userWord) {

        userWord = userWord.concat("way");

        return userWord;
    }
    //Determines if a word starts with a vowel or consonant
    public static boolean isVowel(String userWord) {
        if (userWord.charAt(0) == 'a' || userWord.charAt(0) == 'e' ||
                userWord.charAt(0) == 'i' || userWord.charAt(0) == 'o' ||
                userWord.charAt(0) == 'u') {
            return true;
        } else {
            return false;
        }
    }
}

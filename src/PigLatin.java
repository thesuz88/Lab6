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
        final String VOWELS = "aeiouAEIOU";
        String result;
        String userWord;

        //Display welcome message and prompt for word from user
        System.out.println("Welcome! Let's learn pig latin.");
        System.out.println("Enter a word to be translated: ");
        userWord = scan.nextLine();

        //Translate user input
        //convert to lowercase before translating
        userWord = userWord.toLowerCase();

        //isVowel will only word for one word to do sentence need to look at string split
        if (isVowel(userWord)) {
            //vowels
            result = translateWithVowel(userWord);
        } else {
            //consonants
            result = translateWithConsonant(userWord);
        }

        //print out result
        System.out.println(result);

        //Play again?

    }

    //Translates word starting with a consonant
    //TODO
    public static String translateWithConsonant(String userWord) {
        int wordLength = userWord.length();
        int firstVowelFound = 0;

        //take all consonants up to the first vowel...How do i get program to stop at vowel?
        for (int i = 0; i < wordLength; i++) {
            char c = userWord.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {

                firstVowelFound = i;
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

import java.util.Scanner;

/**
 * Created by Steve on 6/30/2017.
 * Pig latin translator. Take user input and translate the word to pig latin.
 */
public class PigLatin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String result;
        String userWord;
        String choice = "y";

        //Display welcome message and prompt for word from user
        System.out.println("Welcome to the pig latin translator!\n");

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

            System.out.println("Pig latin translation: " + result);


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
            char v = userWord.charAt(i);
            if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u') {

                firstVowelFound = i;
                break; //without this break the last vowel is moved to the beginning and word becomes scrambled
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
        char s = userWord.charAt(0);
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
            return true;
        } else {
            return false;
        }
    }
}

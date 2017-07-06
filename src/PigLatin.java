import java.util.Scanner;

/**
 * Created by Steve on 6/30/2017.
 * Pig latin translator. Take user input and translate the phrase to pig latin.
 */
public class PigLatin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] result = new String[50]; //had issues with scope when I didn't define array size
        String userPhrase;
        String choice = "y";

        //Display welcome message and prompt for word from user
        System.out.println("Welcome to the pig latin translator!\n");

        while (choice.equalsIgnoreCase("y")) {
            System.out.println("Enter a word or phrase to be translated: ");
            userPhrase = scan.nextLine();

            //convert to lowercase before translating
            userPhrase = userPhrase.toLowerCase();

            //Split user input at spaces and assign to array
            String[] splitSentence = userPhrase.split(" ");

            System.out.println("Pig latin translation: ");

            for (int i = 0; i < splitSentence.length; i++) {

                //takes each input from array and checks pig latin conditions
                if (isVowel(splitSentence[i])) {

                    //vowels method taking elements from splitSentence and copies to result array
                    result[i] = translateWithVowel(splitSentence[i]);
                } else {

                    //consonants method taking elements from splitSentence and copies to result array
                    result[i] = translateWithConsonant(splitSentence[i]);
                }
                //prints out each element of result array for each iteration of the loop
                System.out.print(result[i] + " ");
            }

            System.out.println("\nWould you like to translate another word? (y/n)");
            choice = scan.nextLine();
        }
        System.out.println("Good luck with your pig latin! Good bye.");
    }

    //Translates word starting with a consonant
    public static String translateWithConsonant(String userSentence) {
        int wordLength = userSentence.length();
        int firstVowelFound = 0;

        //take all consonants up to the first vowel
        for (int i = 0; i < wordLength; i++) {
            char v = userSentence.charAt(i);
            if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u') {

                firstVowelFound = i;
                break; //without this break the last vowel is moved to the beginning and word becomes scrambled
            }
        }
        String startString = userSentence.substring(firstVowelFound, wordLength);
        String movedString = userSentence.substring(0, firstVowelFound);

        userSentence = startString + movedString + "ay";

        return userSentence;
    }

    //Translates word starting with a vowel pig latin logic
    public static String translateWithVowel(String userSentence) {

        userSentence = userSentence.concat("way");

        return userSentence;
    }

    //Determines if a word starts with a vowel or consonant
    public static boolean isVowel(String userSentence) {
        char s = userSentence.charAt(0);
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
            return true;
        } else {
            return false;
        }
    }
}

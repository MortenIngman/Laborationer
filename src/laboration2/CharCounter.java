package laboration2;

import java.util.Scanner;

/**
 * @author Morten Ingman
 * Programmet tar inmatning från användaren i form av en mening och ett
 * tecken, sen räknar det ut det totala antalet tecken i meningen
 * samt det totala antalet förekomster av angivet tecken i meningen.
 * Programmet skriver också ut på vilken plats i meningen det angivna
 * tecknet förekommer första och sista gången
 */

public class CharCounter {
    public static void main(String[] args) {
        int numberOfCharacters = 0;
        int occurrences = 0;
        int firstOccurrence = 0;
        int lastOccurrence = 0;
        String sentence = "";
        String character = "";

        Scanner input = new Scanner(System.in);

        while (sentence.length() < 1) {
            System.out.print("Skriv in en mening: ");
            sentence = input.nextLine();
        }

        for (int i = 0; i < sentence.length(); i++) {
            sentence = sentence.toLowerCase();
                numberOfCharacters = sentence.length();
        }

        while (character.length() != 1) {
            System.out.print("Skriv in ett tecken: ");
            character = input.nextLine();
        }

        for (int j = 0; j < sentence.length(); j++) {
            character = character.toLowerCase();
            if (character.charAt(0) == sentence.charAt(j)) {
                occurrences++;
            }
            firstOccurrence = sentence.indexOf(character);
            lastOccurrence = sentence.lastIndexOf(character);
        }

        System.out.println("Meningen har totalt " + numberOfCharacters + " tecken.");
        System.out.println("Tecknet " + character + " förekommer " + occurrences + " gånger.");
        System.out.println("Första gången på indexplats " + firstOccurrence);
        System.out.println("Sista gången på indexplats " + lastOccurrence);
    }
}

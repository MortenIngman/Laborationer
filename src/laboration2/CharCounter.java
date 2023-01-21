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
        int antalTecken = 0;
        int antalForekomster = 0;
        int forstaForekomst = 0;
        int sistaForekomst = 0;
        String mening = "";
        String tecken = "";

        Scanner input = new Scanner(System.in);

        while(mening.length() < 1) {
            System.out.print("Skriv in en mening: ");
            mening = input.nextLine();
        }

        for (int i = 0; i < mening.length(); i++) {
            mening = mening.toLowerCase();
            if (mening.charAt(i) != ' ')
                antalTecken++;
        }

        while(tecken.length() != 1) {
            System.out.print("Skriv in ett tecken: ");
            tecken = input.nextLine();
        }

        for (int j = 0; j < mening.length(); j++) {
            tecken = tecken.toLowerCase();
            if (tecken.charAt(0) == mening.charAt(j)) {
                antalForekomster++;
            }
            forstaForekomst = mening.indexOf(tecken);
            sistaForekomst = mening.lastIndexOf(tecken);
        }

        System.out.println("Meningen har totalt " + antalTecken + " tecken.");
        System.out.println("Tecknet " + tecken + " förekommer " + antalForekomster + " gånger.");
        System.out.println("Första gången på indexplats " + forstaForekomst);
        System.out.println("Sista gången på indexplats " + sistaForekomst);
    }
}

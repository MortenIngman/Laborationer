package laboration3;

import java.util.ArrayList;
import java.util.Scanner;

public class HandlingIntegers {

    /**
     * @param args unused
     * @author Morten Ingman
     * Programmet tar input från användaren i form av hur många heltal vederbörande vill ange
     * därefter får användaren ange valt antal heltal. Programmet skriver ut det antal heltal
     * användaren har angivit och kontrollerar samt skriver ut hur många tal som endast inmatats
     * en gång. Det beräknar också medelvärdet av inmatade tal. Matar användaren in något annat
     * än ett heltal så får denne ett felmeddelande och blir uppmanad att ange ett heltal.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfIntegers;
        int avarageValue;
        int occurrences;

        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        ArrayList<Integer> arrayOfDuplicates = new ArrayList<>();
        ArrayList<Integer> arrayOfSingles = new ArrayList<>();

        numberOfIntegers = selectNumberOfIntegers(input);
        createArrayOfIntegers(input, numberOfIntegers, arrayOfIntegers);
        occurrences = calculateNumberOfOccurences(arrayOfIntegers, arrayOfDuplicates, arrayOfSingles);
        avarageValue = calculateAvarageValue(arrayOfIntegers);

        System.out.println("Du angav " + numberOfIntegers + " tal.");
        System.out.println("Varav " + occurrences + " bara angavs en gång.");
        System.out.println("Medelvärdet för talen är: " + avarageValue);

        input.close();
    }

    /**
     * Metoden ber användaren ange antalet heltal hen vill mata in.
     * Matar användaren in något annat än ett heltal får vederbörande
     * ett felmeddelande och ombeds mata in ett heltal
     *
     * @param input i form av ett heltal som användaren uppmanas ange.
     * @return metoden returnerar heltalet i datatypen integer
     */
    private static int selectNumberOfIntegers(Scanner input) {
        int numberOfIntegers;
        while (true) {
            System.out.print("Hur många heltal vill du ange? ");
            String heltal = input.nextLine();
            try {
                numberOfIntegers = Integer.parseInt(heltal);
                System.out.println(numberOfIntegers);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt värde!");
            }
        }
        return numberOfIntegers;
    }

    /**
     * Metoden låter användaren mata in det antal heltal hen angav
     * och skapar en array med dessa. Matar användaren in något annat
     * än ett heltal får vederbörande ett felmeddelande och ombeds
     * mata in ett heltal.
     *
     * @param input        heltalen användaren matar in
     * @param numberOfIntegers  antal heltal användaren kan mata in i arrayen
     * @param arrayOfIntegers arrayen som ska populeras i metoden.
     */
    private static void createArrayOfIntegers(Scanner input, int numberOfIntegers, ArrayList<Integer> arrayOfIntegers) {
        for (int i = 1; i <= numberOfIntegers; i++) {
            while (true) {
                System.out.print("Ange heltal " + i + ": ");
                String number = input.nextLine();
                try {
                    arrayOfIntegers.add(Integer.parseInt(number));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ogiltigt värde!");
                }
            }
        }
    }

    /**
     * Metoden beräknar hur många tal som bara förekommer
     * en gång i arrayen och returnerar det värdet.
     *
     * @param arrayOfIntegers arrayen med heltal som användaren angett
     * @param arrayOfDuplicates populeras med de tal som förkommer fler än en gång
     * @param arrayOfSingles  populeras med de tal som bara förekommer en gång
     * @return metoden returnerar antalet värden som bara förekommer en gång
     */
    private static int calculateNumberOfOccurences(ArrayList<Integer> arrayOfIntegers, ArrayList<Integer> arrayOfDuplicates, ArrayList<Integer> arrayOfSingles) {
        boolean isDuplicate;
        for (int i = 0; i < arrayOfIntegers.size(); i++) {
            isDuplicate = false;
            if (!arrayOfDuplicates.contains(arrayOfIntegers.get(i))) {
                for (int j = i + 1; j < arrayOfIntegers.size(); j++) {
                    if (arrayOfIntegers.get(i).equals(arrayOfIntegers.get(j))) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    arrayOfSingles.add(arrayOfIntegers.get(i));
                } else {
                    arrayOfDuplicates.add(arrayOfIntegers.get(i));
                }
            }
        }
        return arrayOfSingles.size();
    }

    /**
     * Metoden beräknar medelvärdet av de tal som
     * användaren matat in i arrayen.
     *
     * @param arrayOfIntegers arrayen med heltal som användaren angett
     * @return metoden returnerar medelvärdet på de tal som heltalsarrayen innehåller
     */
    private static int calculateAvarageValue(ArrayList<Integer> arrayOfIntegers) {
        int summa = 0;
        for (Integer integer : arrayOfIntegers) {
            summa += integer;
        }
        return summa / arrayOfIntegers.size();
    }
}

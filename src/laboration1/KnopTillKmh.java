package laboration1;

import java.util.Scanner;


//* Programmet tar ett heltalsvärde som motsvarar en hastighet i enheten knop och konverterar det till kilometer per timme */
public class KnopTillKmh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv en hastighet i knop: ");
        int knop = input.nextInt();
        double resultat = knop * 1.852;
        System.out.println(knop + " knop motsvarar " + resultat + " km/h");
    }
}

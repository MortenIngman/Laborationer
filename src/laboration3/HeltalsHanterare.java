package laboration3;

import java.util.ArrayList;
import java.util.Scanner;

public class HeltalsHanterare {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int antalHeltal;
        ArrayList<Integer> heltalsArray = new ArrayList<>();
        int summa = 0;

        while(true) {
            System.out.println("Hur många heltal vill du ange? ");
            String heltal = input.nextLine();
            try {
                antalHeltal = Integer.parseInt(heltal);
                System.out.println(antalHeltal);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt värde!");
            }
        }

        for(int i = 1; i <= antalHeltal; i++) {
                while(true) {
                    System.out.println("Ange heltal " + i);
                    String heltal = input.nextLine();
                    try {
                        heltalsArray.add(Integer.parseInt(heltal));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Ogiltigt värde!");
                    }
                }
        }

        System.out.println(heltalsArray);

        for (Integer integer : heltalsArray) {
            summa += integer;
        }

        System.out.println(summa);

    }


}

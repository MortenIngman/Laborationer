package laboration1.laboration3;

import java.util.ArrayList;
import java.util.Scanner;

public class HeltalsHanterare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int antalHeltal;
        int medelVarde;
        int frekvens;

        ArrayList<Integer> heltalsArray = new ArrayList<>();
        ArrayList<Integer> dublettArray = new ArrayList<>();
        ArrayList<Integer> singelArray = new ArrayList<>();

        antalHeltal = antalHeltal(input);
        skapaHeltalsArray(input, antalHeltal, heltalsArray);
        frekvens = beraknaForekomster(heltalsArray, dublettArray, singelArray);
        medelVarde = beraknaMedelvarde(heltalsArray);

        System.out.println("Du angav " + antalHeltal + " tal.");
        System.out.println("Varav " + frekvens + " bara angavs en gång.");
        System.out.println("Medelvärdet för talen är: " + medelVarde);

        input.close();
    }

    private static int antalHeltal(Scanner input) {
        int antalHeltal;
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
        return antalHeltal;
    }

    private static void skapaHeltalsArray(Scanner input, int antalHeltal, ArrayList<Integer> heltalsArray) {
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
    }

    private static int beraknaForekomster(ArrayList<Integer> heltalsArray, ArrayList<Integer> dublettArray, ArrayList<Integer> singelArray) {
        boolean arDublett;
        for (int i = 0; i < heltalsArray.size(); i++) {
            arDublett = false;
            if (!dublettArray.contains(heltalsArray.get(i))){
                for (int j = i + 1; j < heltalsArray.size(); j++) {
                    if (heltalsArray.get(i).equals(heltalsArray.get(j))) {
                        arDublett = true;
                        break;
                    }
                }
                if (!arDublett) {
                    singelArray.add(heltalsArray.get(i));
                } else {
                    dublettArray.add(heltalsArray.get(i));
                }
            }
        }
        return singelArray.size();
    }

    private static int beraknaMedelvarde(ArrayList<Integer> heltalsArray) {
        int summa = 0;
        for (Integer integer : heltalsArray) {
            summa += integer;
        }
        return summa / heltalsArray.size();
    }
}

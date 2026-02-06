
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[] hands = fileData.split("\n");

        int fiveOfAKind = 0;
        int fourOfAKind = 0;
        int fullHouse = 0;
        int threeOfAKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        for (String line : hands) {
            String[] cardTypes = {"","","","",""};
            int[] counts = new int[5];

            String[] hand = line.split("\\|");
            String cards = hand[0];
            int betAmount = Integer.parseInt(hand[1]);
            String[] cardsArray = cards.split(",");

            for (String card : cardsArray) {
                boolean inList = false;
                for (int i = 0; i < cardTypes.length; i++) {
                    if (card.equals(cardTypes[i])) {
                        counts[i]++;
                        inList = true;
                        break;
                    }
                }
                if (!inList) {
                    for (int i = 0; i < cardTypes.length; i++) {
                        if (cardTypes[i].equals("")) {
                            cardTypes[i] = card;
                            counts[i]++;
                            break;
                        }
                    }
                }
            }

            boolean five = false;
            boolean four = false;
            boolean three = false;
            int pairs = 0;

            for (int n : counts) {
                if (n == 5) {
                    five = true;
                }
                else if (n == 4) {
                    four = true;
                }
                else if (n == 3) {
                    three = true;
                }
                else if (n == 2) {
                    pairs++;
                }
            }

            if (five) {
                fiveOfAKind++;
            }
            else if (four) {
                fourOfAKind++;
            }
            else if (three && pairs > 0) {
                fullHouse++;
            }
            else if (three) {
                threeOfAKind++;
            }
            else if (pairs == 2) {
                twoPair++;
            }
            else if (pairs == 1) {
                onePair++;
            }
            else {
                highCard++;
            }
        }

        System.out.println("Number of five of a kind hands: " + fiveOfAKind);
        System.out.println("Number of full house hands: " + fullHouse);
        System.out.println("Number of four of a kind hands: " + fourOfAKind);
        System.out.println("Number of three of a kind hands: " + threeOfAKind);
        System.out.println("Number of two pair hands: " + twoPair);
        System.out.println("Number of one pair hands: " + onePair);
        System.out.println("Number of high card hands: " + highCard);

    }
}

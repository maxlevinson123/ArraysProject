
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
            boolean inList = false;

            for (String card : cardsArray) {
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
                        }
                    }
                }
            }

        }
    }
}

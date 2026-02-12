
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

            String[] hand = line.split("\\|");
            Poker h = new Poker(hand);

            int betAmount = Integer.parseInt(hand[1]);

            if (h.handType().equals("fiveOfAKind")) {
                fiveOfAKind++;
            }
            else if (h.handType().equals("fourOfAKind")) {
                fourOfAKind++;
            }
            else if (h.handType().equals("fullHouse")) {
                fullHouse++;
            }
            else if (h.handType().equals("threeOfAKind")) {
                threeOfAKind++;
            }
            else if (h.handType().equals("twoPair")) {
                twoPair++;
            }
            else if (h.handType().equals("onePair")) {
                onePair++;
            }
            else {
                highCard++;
            }
        }

        System.out.println(fiveOfAKind + " " + fullHouse + " " + fourOfAKind + " " + threeOfAKind + " " + twoPair + " " + onePair + " " + highCard);
    }
}

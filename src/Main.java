
import java.io.File;
import java.io.FileNotFoundException;
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
            String[] cards = hand[0].split(",");
            Poker h = new Poker(cards);

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

        System.out.println("Part One:");
        System.out.println("Number of five of a kind hands: " + fiveOfAKind);
        System.out.println("Number of full house hands: " + fullHouse);
        System.out.println("Number of four of a kind hands: " + fourOfAKind);
        System.out.println("Number of three of a kind hands: " + threeOfAKind);
        System.out.println("Number of two pair hands: " + twoPair);
        System.out.println("Number of one pair hands: " + onePair);
        System.out.println("Number of high card hands: " + highCard);

        System.out.println("*************************************");

            Poker[] pokerHands = new Poker[hands.length];
            int[] bets = new int[hands.length];
            int betTotal = 0;

            for (int i = 0; i < hands.length; i++){
                String[] hand = hands[i].split("\\|");
                pokerHands[i] = new Poker(hand[0].split(","));
                bets[i] = Integer.parseInt(hand[1]);
            }

            for (int i = 0; i < hands.length; i++) {
                int ranking = 1;
                for (int n = 0; n < hands.length; n++) {
                    if (pokerHands[i].handIsStronger(pokerHands[n])) {
                        ranking++;
                    }
                }

                betTotal += ranking * bets[i];
            }

            System.out.println("Part Two: ");
            System.out.println("Total bid value: " + betTotal);
            System.out.println("*************************************");

            Poker[] wildPokerHands = new Poker[hands.length];
            int[] wildBets = new int[hands.length];
            int wildBetTotal = 0;

            for (int i = 0; i < hands.length; i++){
                String[] hand = hands[i].split("\\|");
                wildPokerHands[i] = new Poker(hand[0].split(","));
                wildBets[i] = Integer.parseInt(hand[1]);
            }

            for (int i = 0; i < hands.length; i++) {
                int ranking = 1;
                for (int n = 0; n < hands.length; n++) {
                    if (wildPokerHands[i].handIsStrongerWild(wildPokerHands[n])) {
                        ranking++;
                    }
                }

                wildBetTotal += ranking * wildBets[i];
            }

            System.out.println("Part Three: ");
            System.out.println("Total bid value: " + wildBetTotal);

        }
    }

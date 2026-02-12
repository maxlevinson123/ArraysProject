public class Poker {

    private String[] hand;

    public Poker(String[] hand) {
        this.hand = hand;
    }

    public String handType(){
        String cards = hand[0];
        String[] cardTypes = {"","","","",""};
        int[] counts = new int[5];
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
            return "fiveOfAKind";
        }
        else if (four) {
            return "fourOfAKind";
        }
        else if (three && pairs > 0) {
            return "fullHouse";
        }
        else if (three) {
            return "threeOfAKind";
        }
        else if (pairs == 2) {
            return "twoPair";
        }
        else if (pairs == 1) {
            return "onePair";
        }
        else {
            return "highCard";
        }
    }

    public



}

public class Poker {

    private String[] cards;

    public Poker(String[] cards) {
        this.cards = cards;
    }

    public String handType() {
        String[] cardTypes = {"", "", "", "", ""};
        int[] counts = new int[5];

        for (String card : cards) {
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
            } else if (n == 4) {
                four = true;
            } else if (n == 3) {
                three = true;
            } else if (n == 2) {
                pairs++;
            }
        }

        if (five) {
            return "fiveOfAKind";
        } else if (four) {
            return "fourOfAKind";
        } else if (three && pairs > 0) {
            return "fullHouse";
        } else if (three) {
            return "threeOfAKind";
        } else if (pairs == 2) {
            return "twoPair";
        } else if (pairs == 1) {
            return "onePair";
        } else {
            return "highCard";
        }
    }

    public int valueOfCard(String card) {
        if (card.equals("Ace")) {
            return 12;
        }
        else if (card.equals("King")) {
            return 11;
        }
        else if (card.equals("Queen")) {
            return 10;
        }
        else if (card.equals("Jack")) {
            return 9;
        }
        else if (card.equals("10")) {
            return 8;
        }
        else if (card.equals("9")) {
            return 7;
        }
        else if (card.equals("8")) {
            return 6;
        }
        else if (card.equals("7")) {
            return 5;
        }
        else if (card.equals("6")) {
            return 4;
        }
        else if (card.equals("5")) {
            return 3;
        }
        else if (card.equals("4")) {
            return 2;
        }
        else if (card.equals("3")) {
            return 1;
        }
        else {
            return 0;
        }

    }

    public int valueOfCardWild(String card){
        if (card.equals("Ace")) {
            return 12;
        }
        else if (card.equals("King")) {
            return 11;
        }
        else if (card.equals("Queen")) {
            return 10;
        }
        else if (card.equals("10")) {
            return 9;
        }
        else if (card.equals("9")) {
            return 8;
        }
        else if (card.equals("8")) {
            return 7;
        }
        else if (card.equals("7")) {
            return 6;
        }
        else if (card.equals("6")) {
            return 5;
        }
        else if (card.equals("5")) {
            return 4;
        }
        else if (card.equals("4")) {
            return 3;
        }
        else if (card.equals("3")) {
            return 2;
        }
        else if (card.equals("2")) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int rankValue() {

        if (handType().equals("fiveOfAKind")){
            return 6;
        }
        else if (handType().equals("fourOfAKind")) {
            return 5;
        }
        else if (handType().equals("fullHouse")) {
            return 4;
        }
        else if (handType().equals("threeOfAKind")) {
            return 3;
        }
        else if (handType().equals("twoPair")) {
            return 2;
        }
        else if (handType().equals("onePair")) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int rankValueWithJacks() {
        String[] cardTypes = {"", "", "", "", ""};
        int[] counts = new int[5];
        int jacks = 0;
        int n = 0;

        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals("Jack")) {
                jacks++;
            }
            else {
                boolean inList = false;
                for (int j = 0; j < cardTypes.length; j++) {
                    if (cards[i].equals(cardTypes[j])) {
                        counts[j]++;
                        inList = true;
                        break;
                    }
                }
                if (!inList) {
                    cardTypes[n] = cards[i];
                    counts[n] = 1;
                    n++;
                }
            }
        }

        if (jacks == 5) {
            return 6;
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < n; i++) {
            if (counts[i] > largest) {
                secondLargest = largest;
                largest = counts[i];
            }
            else if (counts[i] > secondLargest) {
                secondLargest = counts[i];
            }
        }

        largest = largest + jacks;

        if (largest == 5) {
            return 6;
        }

        else if (largest == 4) {
            return 5;
        }

        else if (largest == 3 && secondLargest == 2) {
            return 4;
        }

        else if (largest == 3) {
            return 3;
        }

        else if (largest == 2 && secondLargest == 2) {
            return 2;
        }

        else if (largest == 2) {
            return 1;
        }

        else {
            return 0;
        }

    }

    public boolean handIsStronger(Poker other) {
        if (this.rankValue() == other.rankValue())
        {
            for (int i = 0; i < cards.length; i++) {
                int card = valueOfCard(cards[i]);
                int otherCard = valueOfCard(other.cards[i]);

                if (card != otherCard) {
                    return card > otherCard;
                }
            }
        }
        return this.rankValue() > other.rankValue();
    }

    public boolean handIsStrongerWild(Poker other) {
        if (this.rankValueWithJacks() == other.rankValueWithJacks())
        {
            for (int i = 0; i < cards.length; i++) {
                int card = valueOfCardWild(cards[i]);
                int otherCard = valueOfCardWild(other.cards[i]);

                if (card != otherCard) {
                    return card > otherCard;
                }
            }
        }
        return this.rankValueWithJacks() > other.rankValueWithJacks();
    }







}

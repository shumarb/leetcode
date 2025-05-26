// Question: https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/

class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        /**
         1.  Edge case: Array has 1 element,
             so can't form a group with > 1 cards.
         */
        if (deck.length == 1) {
            return false;
        }

        boolean isTest = false;
        int gcd = -1;
        int largest = deck[0];

        for (int number: deck) {
            largest = Math.max(number, largest);
        }
        int[] frequency = new int[largest + 1];
        for (int number: deck) {
            frequency[number]++;
        }
        if (isTest) {
            System.out.println("\ndeck: " + Arrays.toString(deck) + "\nfrequency: " + Arrays.toString(frequency));
        }

        for (int i = 0; i <= largest; i++) {
            if (gcd == -1) {
                gcd = frequency[i];
            } else {
                gcd = computeGCD(gcd, frequency[i]);
            }
        }

        return gcd > 1;
    }

    private int computeGCD(int first, int second) {
        if (second == 0) {
            return first;
        }
        return computeGCD(second, first % second);
    }
}
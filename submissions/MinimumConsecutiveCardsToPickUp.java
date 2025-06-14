// Question: https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/description/

class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        boolean isTest = false;
        int largest = cards[0];
        int len = cards.length;
        int minimumCardPickup = Integer.MAX_VALUE;

        for (int card: cards) {
            largest = Math.max(largest, card);
        }
        int[] lastCardIndex = new int[largest + 1];
        Arrays.fill(lastCardIndex, -1);

        for (int i = 0; i < len; i++) {
            int card = cards[i];
            int lastIndex = lastCardIndex[card];
            if (lastIndex == -1) {
                lastCardIndex[card] = i;
            } else {
                if (isTest) {
                    System.out.println(" * card: " + card + " | indices --> current: " + i + ", last: " + lastIndex);
                }
                minimumCardPickup = Math.min(minimumCardPickup, i - lastIndex + 1);
                lastCardIndex[card] = i;
            }
        }

        return minimumCardPickup == Integer.MAX_VALUE ? -1 : minimumCardPickup;
    }
}
// Question: https://leetcode.com/problems/best-poker-hand/description/

class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        int[] rankFrequency = new int[14];
        int[] suitFrequency = new int[4];

        for (char suit: suits) {
            suitFrequency[suit - 'a']++;
            if (suitFrequency[suit - 'a'] == 5) {
                return "Flush";
            }
        }
        for (int rank: ranks) {
            rankFrequency[rank]++;
            if (rankFrequency[rank] == 3) {
                return "Three of a Kind";
            }
        }
        for (int frequency: rankFrequency) {
            if (frequency == 2) {
                return "Pair";
            }
        }

        return "High Card";
    }
}
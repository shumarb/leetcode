// Question: https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/

class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int[] numberFrequency = new int[100];

        for (int[] entry: dominoes) {
            int first = entry[0];
            int second = entry[1];
            int key = Math.min(first, second) * 10 + Math.max(first, second);
            numberFrequency[key]++;
        }
        for (int i = 10; i <= 99; i++) {
            int value = numberFrequency[i];
            if (value > 1) {
                count += (value * (value - 1) / 2);
            }
        }

        return count;
    }
}
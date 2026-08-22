// Question: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/

class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        boolean isTest = false;
        int j = 0;
        int largest = 0;
        int left = 0;
        int n = piles.length / 3;
        int result = 0;
        int right = piles.length - 2;
        int[] count = new int[100001];

        for (int e: piles) {
            count[e]++;
            largest = Math.max(e, largest);
        }
        for (int i = 1; i <= largest; i++) {
            while (count[i]-- > 0) {
                piles[j++] = i;
            }
        }

        while (left++ < right) {
            result += piles[right];
            right -= 2;
        }
        if (isTest) {
            System.out.println("sorted piles: " + Arrays.toString(piles) + "\nresult: " + result);
        }

        return result;
    }
}

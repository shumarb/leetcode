// Question: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/

class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        boolean isTest = false;
        int j = 0;
        int largest = 0;
        int left = 0;
        int n = piles.length / 3;
        int p = 3 * n - 1;
        int result = 0;
        int right = piles.length - 2;
        int[] count = new int[100001];
        int[] highest = new int[2 * n];

        for (int e: piles) {
            count[e]++;
            largest = Math.max(e, largest);
        }
        for (int i = 1; i <= largest; i++) {
            while (count[i]-- > 0) {
                piles[j++] = i;
            }
        }

        for (int i = highest.length - 1; i >= 0; i--) {
            highest[i] = piles[p--];
        }
        while (left++ < right) {
            result += piles[right];
            right -= 2;
        }
        if (isTest) {
            System.out.println("sorted piles: " + Arrays.toString(piles) + "\nhighest: " + Arrays.toString(highest) + "\nresult: " + result);
        }

        return result;
    }
}

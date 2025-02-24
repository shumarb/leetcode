// Question: https://leetcode.com/problems/k-items-with-the-maximum-sum/description/

class KItemsWithTheMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        // 1. Edge case: k == 0
        if (k == 0) {
            return 0;
        }

        int maximumSum = 0;
        for (int i = 0; i < numOnes; i++) {
            maximumSum += 1;
            k -= 1;
            if (k == 0) {
                return maximumSum;
            }
        }

        for (int i = 0; i < numZeros; i++) {
            k -= 1;
            if (k == 0) {
                return maximumSum;
            }
        }

        for (int i = 0; i < numNegOnes; i++) {
            maximumSum -= 1;
            k -= 1;
            if (k == 0) {
                return maximumSum;
            }
        }

        return maximumSum;
    }
}
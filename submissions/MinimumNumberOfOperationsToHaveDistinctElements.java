// Question: https://leetcode.com/problems/minimum-number-of-operations-to-have-distinct-elements/description/

class MinimumNumberOfOperationsToHaveDistinctElements {
    public int minOperations(int[] nums) {
        int[] count;
        int countDistinct = 0;
        int i = 0;
        int largest = 0;
        int n = nums.length;
        int result = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: nums) {
            if (count[e]++ == 0) {
                countDistinct++;
            }
        }
        if (countDistinct == n) {
            return result;
        }

        while (n - i >= 3) {
            for (int j = 0; j < 3; j++) {
                int top = nums[i++];
                if (--count[top] == 0) {
                    countDistinct--;
                }
            }
            result++;
            if (countDistinct == n - i) {
                return result;
            }
        }

        return countDistinct == n ? result : ++result;
    }
}
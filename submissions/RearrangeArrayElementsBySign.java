// Question: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        boolean isPositive = true;
        int i = 0;
        int j = 0;
        int k = 0;
        int n = nums.length;
        int[] negative = new int[n / 2];
        int[] result = new int[n];
        int[] positive = new int[n / 2];

        for (int number: nums) {
            if (number > 0) {
                positive[j++] = number;
            } else {
                negative[k++] = number;
            }
        }

        j = 0;
        k = 0;
        while (j < n / 2 && k < n / 2) {
            if (isPositive) {
                result[i++] = positive[j++];
                isPositive = false;
            } else {
                result[i++] = negative[k++];
                isPositive = true;
            }
        }
        if (j < n / 2) {
            result[i++] = positive[j++];
        }
        if (k < n / 2) {
            result[i++] = negative[k++];
        }

        return result;
    }
}
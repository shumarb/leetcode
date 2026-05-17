// Question: https://leetcode.com/problems/concatenate-array-with-reverse/

class ConcatenateArrayWithReverse {
    public int[] concatWithReverse(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int[] result = new int[2 * n];

        for (int i = 0; i < n; i++) {
            result[2 * n - i - 1] = result[i] = nums[i];
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}

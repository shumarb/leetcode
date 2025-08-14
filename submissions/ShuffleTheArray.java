// Question: https://leetcode.com/problems/shuffle-the-array/description/

class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int j = 0;
        int k = n;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums[j++];
            } else {
                result[i] = nums[k++];
            }
        }

        return result;
    }
}
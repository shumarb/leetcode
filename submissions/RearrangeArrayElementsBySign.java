// Question: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int j = 0;
        int k = 1;
        int n = nums.length;
        int[] result = new int[n];

        for (int number: nums) {
            if (number > 0) {
                result[j] = number;
                j += 2;
            } else {
                result[k] = number;
                k += 2;
            }
        }

        return result;
    }
}
// Question: https://leetcode.com/problems/find-the-middle-index-in-array/description/

class FindTheMiddleIndexInArray {
    /**
     s   [14 11 12  4   0]
     [2  3  -1  8  4]
     p   [0  2   5  4 12]
     */
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] prefixArr = new int[n];
        int[] suffixArr = new int[n];
        boolean t = false;

        prefixArr[0] = 0;
        for (int i = 1; i < n; i++) {
            prefixArr[i] = nums[i - 1] + prefixArr[i - 1];
        }
        suffixArr[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            suffixArr[i] = nums[i + 1] + suffixArr[i + 1];
        }
        if (t) {
            System.out.println("nums:        " + Arrays.toString(nums));
            System.out.println("prefixArr:   " + Arrays.toString(prefixArr));
            System.out.println("suffixArr:   " + Arrays.toString(suffixArr));
        }
        for (int i = 0; i < n; i++) {
            if (suffixArr[i] == prefixArr[i]) {
                return i;
            }
        }
        return -1;
    }
}
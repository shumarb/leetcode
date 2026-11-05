// Question: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/description/

class MinimumMovesToEqualArrayElementsIII {
    public int minMoves(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;

        if (n == 1) {
            return 0;
        }
        for (int e: nums) {
            if (e > maximum) {
                maximum = e;
            }

            sum += e;
        }

        return n * maximum - sum;
    }
}

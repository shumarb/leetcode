// Question: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/

class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int minimum = Integer.MAX_VALUE;
        int result = 0;

        for (int e: nums) {
            minimum = Math.min(e, minimum);
        }
        for (int e: nums) {
            result += (e - minimum);
        }

        return result;
    }
}

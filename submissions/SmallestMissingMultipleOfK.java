// Question: https://leetcode.com/problems/smallest-missing-multiple-of-k/description/

class SmallestMissingMultipleOfK {
    public int missingMultiple(int[] nums, int k) {
        boolean[] isPresent = new boolean[101];
        int result = k;

        for (int e: nums) {
            isPresent[e] = true;
        }
        while (result <= 100 && isPresent[result]) {
            result += k;
        }

        return result;
    }
}

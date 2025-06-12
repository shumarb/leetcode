// Question:

class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int countElements = nums.length;
        int longestArithSeqLength = 0;
        Map<Integer, Integer>[] map = new HashMap[countElements];

        for (int i = 0; i < countElements; i++) {
            map[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int difference = nums[j] - nums[i];
                int len = map[j].getOrDefault(difference, 1) + 1;
                map[i].put(difference, len);
                longestArithSeqLength = Math.max(longestArithSeqLength, len);
            }
        }

        return longestArithSeqLength;
    }
}

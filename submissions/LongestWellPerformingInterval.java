// Question: https://leetcode.com/problems/longest-well-performing-interval/description/

class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int countNonTiring = 0;
            int countTiring = 0;

            for (int j = i; j < n; j++) {
                if (hours[j] > 8) {
                    countTiring++;
                } else {
                    countNonTiring++;
                }
                if (countTiring > countNonTiring) {
                    result = Math.max(j - i + 1, result);
                }
            }
        }

        return result;
    }
}

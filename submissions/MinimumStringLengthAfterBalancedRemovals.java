// Question: https://leetcode.com/problems/minimum-string-length-after-balanced-removals/description/

class MinimumStringLengthAfterBalancedRemovals {
    public int minLengthAfterRemovals(String s) {
        int countA = 0;
        int countB = 0;

        for (char c: s.toCharArray()) {
            if (c == 'a') {
                countA++;
            } else {
                countB++;
            }
        }

        return Math.abs(countA - countB);
    }
}

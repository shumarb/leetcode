// Question: https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/description/

class DetectPatternOfLengthMRepeatedKOrMoreTimes {
    public boolean containsPattern(int[] arr, int m, int k) {
        int count = 0;

        for (int i = m; i < arr.length; i++) {
            if (arr[i] == arr[i - m]) {
                count++;
                if (count == (k - 1) * m) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }
}
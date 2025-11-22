// Question: https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

class SumOfBeautyOfAllSubstrings {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (substring.length() > 1) {
                    sum += compute(substring);
                }
            }
        }

        return sum;
    }

    private int compute(String s) {
        int[] count = new int[26];
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c: s.toCharArray()) {
            if (count[c - 'a'] > 0) {
                maximum = Math.max(count[c - 'a'], maximum);
                minimum = Math.min(count[c - 'a'], minimum);
            }
        }

        return maximum - minimum;
    }
}
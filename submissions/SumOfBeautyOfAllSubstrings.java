// Question: https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/

class SumOfBeautyOfAllSubstrings {
    public int beautySum(String s) {
        char[] letters = s.toCharArray();
        int n = letters.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int[] count = new int[26];

            for (int j = i; j < n; j++) {
                int maximum = 0;
                int minimum = Integer.MAX_VALUE;
                count[letters[j] - 'a']++;

                for (int e: count) {
                    if (e == 0) {
                        continue;
                    }

                    maximum = Math.max(e, maximum);
                    minimum = Math.min(e, minimum);
                }

                sum += maximum - minimum;
            }
        }

        return sum;
    }
}

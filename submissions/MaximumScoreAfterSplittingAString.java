// Question: https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/

class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        boolean isTest = false;
        int len = s.length();
        int maxScore = 0;
        int[] prefix = new int[len - 1];
        int[] suffix = new int[len - 1];

        if (s.charAt(0) == '0') {
            prefix[0] = 1;
        }
        for (int i = 1; i < prefix.length; i++) {
            if (s.charAt(i) == '0') {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }
        if (s.charAt(len - 1) == '1') {
            suffix[suffix.length - 1] = 1;
        }
        for (int i = suffix.length - 2; i >= 0; i--) {
            if (s.charAt(i + 1) == '1') {
                suffix[i] = suffix[i + 1] + 1;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }
        if (isTest) {
            System.out.println("s: " + s);
            System.out.println("---------------------------------------");
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("suffix: " + Arrays.toString(suffix));
        }

        for (int i = 0; i < len - 1; i++) {
            maxScore = Math.max(maxScore, prefix[i] + suffix[i]);
        }
        if (isTest) {
            System.out.println("maxScore: " + maxScore);
        }

        return maxScore;
    }
}
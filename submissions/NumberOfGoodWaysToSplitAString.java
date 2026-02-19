// Question: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/

class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        boolean isTest = false;
        int countDistinctLeft = 0;
        int countDistinctRight = 0;
        int result = 0;
        int[] countLeft = new int[26];
        int[] countRight = new int[26];

        for (char c: s.toCharArray()) {
            if (++countRight[c - 'a'] == 1) {
                countDistinctRight++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (++countLeft[c - 'a'] == 1) {
                countDistinctLeft++;
            }
            if (--countRight[c - 'a'] == 0) {
                countDistinctRight--;
            }

            if (countDistinctLeft == countDistinctRight) {
                if (isTest) {
                    System.out.println("valid");
                }
                result++;
            }
            if (isTest) {
                System.out.println("i: " + i + " -> c: " + c + "\n * left: " + s.substring(0, i + 1) + " -> countLeft: " + Arrays.toString(countLeft));
                System.out.println(" * right: " + s.substring(i + 1) + " -> countRight: " + Arrays.toString(countRight));
                System.out.println("------------------------------------------------------------------------------------------------------");
            }
        }

        return result;
    }
}
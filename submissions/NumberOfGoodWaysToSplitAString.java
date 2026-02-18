// Question: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/

class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        boolean isTest = false;
        int n = s.length();
        int result = 0;
        int[] countLeft = new int[26];
        int[] countRight = new int[26];

        for (char c: s.toCharArray()) {
            countRight[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            countLeft[c - 'a']++;
            countRight[c - 'a']--;

            if (isValid(countLeft, countRight)) {
                if (isTest) {
                    System.out.println("valid");
                }
                result++;
            }
            if (isTest) {
                System.out.println("i: " + i + " -> c: " + c + "\n * countLeft: " + Arrays.toString(countLeft));
                System.out.println(" * countRight: " + Arrays.toString(countRight));
                System.out.println("------------------------------------------------------------------------------------------------------");
            }
        }

        return result;
    }

    private boolean isValid(int[] first, int[] second) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < 26; i++) {
            if (first[i] > 0) {
                count1++;
            }
            if (second[i] > 0) {
                count2++;
            }
        }
        return count1 == count2;
    }
}
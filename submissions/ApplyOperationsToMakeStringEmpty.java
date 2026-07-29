// Question: https://leetcode.com/problems/apply-operations-to-make-string-empty/description/

class ApplyOperationsToMakeStringEmpty {
    public String lastNonEmptyString(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int[] count = new int[26];
        int[] lastIndex = new int[26];
        int maxCount = 0;
        int n = letters.length;

        /**
         1.  Characters with the maximum frequency must be in the final operation before the string becomes empty.
             Hence, store the last index of all letters to ensure result preserves the ordering of the letters.
             Iterate letters from left to right, append the i-th letter to result only if its frequency is the maxmimum frequency and i is the last index of the letter.
         */
        Arrays.fill(lastIndex, -1);
        for (int i = 0; i < n; i++) {
            char c = letters[i];
            count[c - 'a']++;
            lastIndex[c - 'a'] = i;
        }
        for (int e: count) {
            maxCount = Math.max(e, maxCount);
        }

        for (int i = 0; i < n; i++) {
            char c = letters[i];

            if (i == lastIndex[c - 'a'] && count[c - 'a'] == maxCount) {
                result.append(c);
            }
        }
        if (isTest) {
            System.out.println("letters: " + Arrays.toString(letters) + "\ncount: " + Arrays.toString(count) + "\nlastIndex: " + Arrays.toString(lastIndex) + "\nmaxCount: " + maxCount + "\nresult: " + result);
        }

        return result.toString();
    }
}

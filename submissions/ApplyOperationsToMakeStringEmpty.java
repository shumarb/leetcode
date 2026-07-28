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
         1.  Count frequency of each letter and its last index.
             Letters with the maximum frequency will remain after simulation.
             Since the order of the letters matter when forming s right before applying the last operation
             store the last index of each letter.
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

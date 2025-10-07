// Question: https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/description/

class LongestSubstringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        // 1. Edge case: word has insufficient characters.
        if (word.length() < 5) {
            return 0;
        }

        int longest = 0;
        int n = word.length();

        for (int i = 0; i < n - 1; ) {
            /**
             2.  Move to next character if it does not start with 'a'
                 or for every adjacent pair of letters, the first letter > second letter
             */
            char first = word.charAt(i);
            char second = word.charAt(i + 1);
            if (first != 'a' || first > second) {
                i++;
                continue;
            }

            /**
             3.  Mark the first and second letters as seen
                 and increment countUnique for each letter being seen for first time.

                 Initialise j as i + 1. While j is a valid index and the j-th letter
                 is >= (j - 1)-th letter, mark the j-th letter as seen and increment countUnique
                 if it is being checked for first time, and increment j.

                 If all 5 vowels are present between indices i & j,
                 compare longest and length between indices j - 1 and assign the larger value to longest,
                 and start the next check at index j.
             */
            boolean[] isChecked = new boolean[26];
            int countUnique = 0;
            int j = i + 1;

            if (!isChecked[first - 'a']) {
                isChecked[first - 'a'] = true;
                countUnique++;
            }
            if (!isChecked[second - 'a']) {
                isChecked[second - 'a'] = true;
                countUnique++;
            }

            while (j < n && word.charAt(j) >= word.charAt(j - 1)) {
                if (!isChecked[word.charAt(j) - 'a']) {
                    isChecked[word.charAt(j) - 'a'] = true;
                    countUnique++;
                }
                j++;
            }
            if (countUnique == 5) {
                longest = Math.max(longest, j - i);
            }

            i = j;
        }

        return longest;
    }
}
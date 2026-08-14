// Question: https://leetcode.com/problems/longest-nice-substring/description/

class LongestNiceSubstring {
    private String result;
    private String s;
    private boolean[][] isVisited;
    private boolean isTest;
    private char[] letters;
    private int earliestIndex;

    public String longestNiceSubstring(String s) {
        earliestIndex = Integer.MAX_VALUE;
        isTest = false;
        isVisited = new boolean[s.length()][s.length()];
        letters = s.toCharArray();
        result = "";
        this.s = s;

        if (isTest) {
            System.out.println("letters: " + Arrays.toString(letters));
        }
        helper(0, letters.length - 1);
        if (isTest) {
            System.out.println("---------------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private void helper(int left, int right) {
        if (left >= right || isVisited[left][right]) {
            return;
        }

        isVisited[left][right] = true;
        String substring = s.substring(left, right + 1);
        boolean[] isPresent = new boolean[52];
        boolean isNiceSubstring = true;

        if (isTest) {
            System.out.println("---------------------------------------------------------\n * indices: [" + left + ", " + right + "] | substring: " + substring);
        }

        for (int i = left; i <= right; i++) {
            char letter = letters[i];

            if (letter >= 'a' && letter <= 'z') {
                isPresent[letter - 'a' + 26] = true;

            } else {
                isPresent[letter - 'A'] = true;
            }
        }

        int partitionIndex = -1;
        for (int i = left; i <= right; i++) {
            char letter = letters[i];
            char lower = Character.toLowerCase(letter);
            char upper = Character.toUpperCase(letter);

            /**
             1. i-th character's complement does not exist,
             so this index is not part of a nice substring if it exists,
             and a nice substring may exist in indices [left, partitionIndex - 1] and [partitionIndex + 1, right].
             */
            if (!isPresent[upper - 'A'] || !isPresent[lower - 'a' + 26]) {
                isNiceSubstring = false;
                partitionIndex = i;
                break;
            }
        }

        if (isNiceSubstring) {
            if ((substring.length() > result.length()) || (substring.length() == result.length() && left < earliestIndex)) {
                if (isTest) {
                    System.out.println(" ** is nice substring | left: " + left + ", earliestIndex: " + earliestIndex);
                }
                earliestIndex = left;
                result = substring;
            }

            return;
        }

        helper(left, partitionIndex - 1);
        helper(partitionIndex + 1, right);
    }
}

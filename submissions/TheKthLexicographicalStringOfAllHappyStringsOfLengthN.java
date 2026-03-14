// Question: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    private boolean isTest;
    private char[] letters;
    private int k;
    private int n;

    public String getHappyString(int n, int k) {
        this.k = k;
        this.n = n;

        if (isTest) {
        }

        return result;
    }

        if (current.length() == n) {
            return;
        }

        for (char c: letters) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != c) {
                current.append(c);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
// Question: https://leetcode.com/problems/lexicographically-smallest-string-after-reverse/description/

class LexicographicallySmallestStringAfterReverse {
    public String lexSmallest(String s) {
        String result = s;
        boolean isTest = false;
        int n = s.length();

        for (int k = 1; k <= n; ++k) {
            String reverseFirst = new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k);
            String reverseLast = s.substring(0, n - k) + new StringBuilder(s.substring(n - k)).reverse().toString();

            if (isTest) {
                System.out.println("k: " + k + " -> reverseFirst: " + reverseFirst + ", reverseLast: " + reverseLast);
            }

            if (reverseFirst.compareTo(result) < 0) {
                result = reverseFirst;
            }
            if (reverseLast.compareTo(result) < 0) {
                result = reverseLast;
            }
        }

        return result;
    }
}
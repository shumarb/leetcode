// Question: https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/

class ShortestAndLexicographicallySmallestBeautifulString {
    public String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        boolean isTest = false;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isValid(sub, k)) {
                    if (isTest) {
                        System.out.println(" * valid: " + sub);
                    }

                    if (result.isEmpty() || sub.length() < result.length() || (sub.length() == result.length() && sub.compareTo(result) < 0)) {
                        result = sub;
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("---------------------------------\nresult: " + result);
        }

        return result;
    }

    private boolean isValid(String s, int k) {
        int countOnes = 0;

        for (char c: s.toCharArray()) {
            if (c == '1' && ++countOnes > k) {
                return false;
            }
        }

        return countOnes == k;
    }
}

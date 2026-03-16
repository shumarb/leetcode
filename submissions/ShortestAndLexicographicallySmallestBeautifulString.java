// Question: https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/

class ShortestAndLexicographicallySmallestBeautifulString {
    public String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        boolean isTest = false;
        int countOnes = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (c == '1') {
                countOnes++;
            }

            while (countOnes == k) {
                int len = right - left + 1;

                if (isTest) {
                    System.out.println(" * valid: " + s.substring(left, right + 1));
                }

                if (result.isEmpty() || len < result.length() || (len == result.length() && s.substring(left, right + 1).compareTo(result) < 0)) {
                    result = s.substring(left, right + 1);
                }

                if (s.charAt(left++) == '1') {
                    countOnes--;
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------\nresult: " + result);
        }

        return result;
    }
}

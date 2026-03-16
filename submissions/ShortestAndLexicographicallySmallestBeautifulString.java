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
                String current = s.substring(left, right + 1);
                if (isTest) {
                    System.out.println(" * valid: " + current);
                }

                if (result.isEmpty() || current.length() < result.length() || (current.length() == result.length() && current.compareTo(result) < 0)) {
                    result = current;
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

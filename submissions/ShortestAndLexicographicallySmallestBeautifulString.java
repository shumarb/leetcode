// Question: https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/

class ShortestAndLexicographicallySmallestBeautifulString {
    public String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int countOnes = 0;
        int left = 0;

        if (isTest) {
            System.out.println("k: " + k + "\nletters: " + Arrays.toString(letters));
            System.out.println("-------------------------------------------------------------------------------");
        }
        for (int right = 0; right < letters.length; right++) {
            if (letters[right] == '1') {
                countOnes++;
            }

            while (countOnes == k) {
                String beautifulSubstring = s.substring(left, right + 1);
                int len = beautifulSubstring.length();
                int n = result.length();

                if (isTest) {
                    System.out.println(" * index range: [" + left + ", " + right + "] | length: " + len + " | beautifulSubstring: " + beautifulSubstring);
                }

                if (result.isEmpty() || len < n || (len == n && beautifulSubstring.compareTo(result) < 0)) {
                    result = beautifulSubstring;
                }

                if (letters[left++] == '1') {
                    countOnes--;
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}

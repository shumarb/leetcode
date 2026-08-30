// Question: https://leetcode.com/problems/length-of-the-longest-valid-substring/description/

class LengthOfTheLongestValidSubstring {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet<>(forbidden);
        boolean isTest = false;
        int left = 0;
        int n = word.length();
        int result = 0;

        if (isTest) {
            System.out.println("word: " + word + "\nset: " + set + "\n-------------------------------------------");
        }
        for (int right = 0; right < n; right++) {
            for (int k = 1; k <= 10 && right - k + 1 >= left; k++) {
                int start = right - k + 1;

                if (set.contains(word.substring(start, right + 1))) {
                    left = start + 1;
                    break;
                }
            }

            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | substring: " + word.substring(left, right + 1));
            }

            result = Math.max(result, right - left + 1);
        }
        if (isTest) {
            System.out.println("-------------------------------------------\nresult: " + result);
        }

        return result;
    }
}

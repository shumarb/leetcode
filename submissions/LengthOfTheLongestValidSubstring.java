// Question: https://leetcode.com/problems/length-of-the-longest-valid-substring/description/

class LengthOfTheLongestValidSubstring {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet<>(forbidden);
        boolean isTest = false;
        int left = 0;
        int result = 0;

        if (isTest) {
            System.out.println("word: " + word + "\nset: " + set + "\n-------------------------------------------");
        }
        for (int right = 0; right < word.length(); right++) {
            for (int start = right; start >= Math.max(left, right - 9); start--) {

                // 1. Substring from indices [start, right] is invalid, so longest valid substring ending @ index right is [start + 1, right].
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

// Question: https://leetcode.com/problems/ongest-substring-without-repeating-characters/description/

class LongestSubstringWithoutRepeatedCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<> ();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char letter = s.charAt(r);
            if (!set.contains(letter)) {
                set.add(letter);
                r++;
            } else {
                set.remove(s.charAt(l++));
            }
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }

}
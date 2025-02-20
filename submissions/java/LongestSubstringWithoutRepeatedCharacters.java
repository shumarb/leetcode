// Question: https://leetcode.com/problems/ongest-substring-without-repeating-characters/description/

class LongestSubstringWithoutRepeatedCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right != s.length()) {
            char sCharacter = s.charAt(right);
            if (!set.contains(sCharacter)) {
                set.add(sCharacter);
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left++));
            }
        }

        return maxLength;
    }
}
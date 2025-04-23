// Question: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/

class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int countGoodSubstrings = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
                countGoodSubstrings++;
            }
        }
        return countGoodSubstrings;
    }
}
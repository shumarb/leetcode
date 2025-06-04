// Question: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/

class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int countGoodSubstrings = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            int first = s.charAt(i);
            int second = s.charAt(i + 1);
            int third = s.charAt(i + 2);
            if (first != second && first != third && second != third) {
                countGoodSubstrings++;
            }
        }
        return countGoodSubstrings;
    }
}
// Question: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/

class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int countGoodSubstrings = 0;

        for (int i = 0; i <= s.length() - 3; i++) {
            char firstLetter = s.charAt(i);
            char secondLetter = s.charAt(i + 1);
            char thirdLetter = s.charAt(i + 2);
            if (firstLetter != secondLetter && firstLetter != thirdLetter && secondLetter != thirdLetter) {
                countGoodSubstrings++;
            }
        }

        return countGoodSubstrings;
    }
}
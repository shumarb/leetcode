// Question: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/

class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }

        int countGoodSubstrings = 0;
        int[] letterFrequency = new int[26];
        for (int i = 0; i < 3; i++) {
            letterFrequency[s.charAt(i) - 'a']++;
        }
        if (isOnlyThreeDistinctLetters(letterFrequency)) {
            countGoodSubstrings++;
        }

        for (int i = 3; i < s.length(); i++) {
            letterFrequency[s.charAt(i - 3) - 'a']--;
            letterFrequency[s.charAt(i) - 'a']++;
            if (isOnlyThreeDistinctLetters(letterFrequency)) {
                countGoodSubstrings++;
            }
        }

        return countGoodSubstrings;
    }

    private boolean isOnlyThreeDistinctLetters(int[] letterFrequency) {
        int count = 0;
        for (int i = 0; i < letterFrequency.length; i++) {
            if (letterFrequency[i] == 1) {
                count++;
            }
        }
        return count == 3;
    }
}
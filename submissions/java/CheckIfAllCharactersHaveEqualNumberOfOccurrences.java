// Question: https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/

class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s) {
        boolean isTest = false;
        int[] letterFrequency = new int[26];
        int count = 0;

        for (char letter: s.toCharArray()) {
            letterFrequency[letter - 'a']++;
            count = letterFrequency[letter - 'a'];
        }
        if (isTest) {
            System.out.println("s: " + s + "\ncount: " + count);
            System.out.println("letterFrequency: " + Arrays.toString(letterFrequency));
        }

        for (int frequency: letterFrequency) {
            if (frequency > 0 && frequency != count) {
                return false;
            }
        }

        return true;
    }
}
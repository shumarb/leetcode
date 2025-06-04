// Question: https://leetcode.com/problems/count-pairs-of-similar-strings/description/

class CountPairsOfSimilarStrings {
    public int similarPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int[] firstFrequency = countLetterFrequency(words[i]);
                int[] secondFrequency = countLetterFrequency(words[j]);
                if (isSimilar(firstFrequency, secondFrequency)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isSimilar(int[] first, int[] second) {
        for (int i = 0; i < first.length; i++) {
            if ((first[i] == 0 && second[i] > 0) || (first[i] > 0 && second[i] == 0)) {
                return false;
            }
        }
        return true;
    }

    private int[] countLetterFrequency(String word) {
        int[] letterFrequency = new int[26];
        for (char letter: word.toCharArray()) {
            letterFrequency[letter - 'a']++;
        }
        return letterFrequency;
    }
}
// Question: https://leetcode.com/problems/word-subsets/description/

class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        boolean isTest = false;
        int[] frequency = new int[26];

        for (String w: words2) {
            int[] count = new int[26];
            for (char letter: w.toCharArray()) {
                count[letter - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                /**
                     1.  A word in words 1 is universal if, for each letter,
                     its count in the word is at least the maximum frequency of that letter
                     in any single word in words2.
                 */
                frequency[i] = Math.max(frequency[i], count[i]);
            }
        }
        if (isTest) {
            System.out.println("words1: " + Arrays.toString(words1) + "\nwords2: " + Arrays.toString(words2));
            System.out.println("frequency: " + Arrays.toString(frequency));
            System.out.println("-----------------------------------------------------------------------------------------");
        }

        for (String word: words1) {
            int[] wFrequency = new int[26];
            for (char c: word.toCharArray()) {
                wFrequency[c - 'a']++;
            }
            if (isTest) {
                System.out.println(" * word: " + word);
                System.out.println(" * wFrequency: " + Arrays.toString(wFrequency));
                System.out.println(" * frequency:  " + Arrays.toString(frequency));
                System.out.println("-----------------------------------------------------------------------------------------");
            }
            if (isUniversal(frequency, wFrequency)) {
                result.add(word);
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private boolean isUniversal(int[] word2Frequency, int[] word1Frequency) {
        for (int i = 0; i < 26; i++) {
            if (word1Frequency[i] < word2Frequency[i]) {
                return false;
            }
        }
        return true;
    }
}
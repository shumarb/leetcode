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
            if (isValid(frequency, wFrequency)) {
                result.add(word);
            }
        }

        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private boolean isValid(int[] word2Frequency, int[] word1Frequency) {
        for (int i = 0; i < 26; i++) {
            if (word2Frequency[i] > 0 && word1Frequency[i] < word2Frequency[i]) {
                return false;
            }
        }
        return true;
    }
}
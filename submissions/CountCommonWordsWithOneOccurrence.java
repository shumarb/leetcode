// Question: https://leetcode.com/problems/count-common-words-with-one-occurrence/description/

class CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        int count = 0;
        Map<String, Integer> words1Frequency = new HashMap<>();
        Map<String, Integer> words2Frequency = new HashMap<>();
        boolean isTest = false;

        populate(words1, words1Frequency);
        populate(words2, words2Frequency);
        if (isTest) {
            System.out.println("words1: " + Arrays.toString(words1) + ", words1Frequency: " + words1Frequency);
            System.out.println("words2: " + Arrays.toString(words2) + ", words2Frequency: " + words2Frequency);
        }

        for (String word: words1) {
            if (words1Frequency.get(word) == 1 && words2Frequency.containsKey(word) && words2Frequency.get(word) == 1) {
                count++;
                if (isTest) {
                    System.out.println("common word: " + word + " | count so far: " + count);
                }
            }
        }

        if (isTest) {
            System.out.println("final count: " + count);
        }
        return count;
    }

    private void populate(String[] words, Map<String, Integer> wordsFrequency) {
        for (String word: words) {
            wordsFrequency.put(word, 1 + wordsFrequency.getOrDefault(word, 0));
        }
    }
}
// Question: https://leetcode.com/problems/uncommon-words-from-two-sentences/description/

class UncommonWordsFromTwoSentences {
    private boolean isTest = false;

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> s1WordFrequencyMap = new HashMap<>();
        Map<String, Integer> s2WordFrequencyMap = new HashMap<>();

        populate(s1, s1WordFrequencyMap);
        populate(s2, s2WordFrequencyMap);
        if (isTest) {
            System.out.println("s1: " + s1 + " | s1WordFrequencyMap: " + s1WordFrequencyMap);
            System.out.println("s2: " + s2 + " | s2WordFrequencyMap: " + s2WordFrequencyMap);
        }

        int count = 0;
        count += check(s1, s1WordFrequencyMap, s2WordFrequencyMap);
        count += check(s2, s2WordFrequencyMap, s1WordFrequencyMap);
        if (isTest) {
            System.out.println("count: " + count);
        }

        String[] result = new String[count];
        updateResult(result, s1, s2, s1WordFrequencyMap, s2WordFrequencyMap);
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private void updateResult(String[] result, String s1, String s2, Map<String, Integer> s1FrequencyMap, Map<String, Integer> s2FrequencyMap) {
        int i = 0;
        while (i != result.length) {
            for (String word: s1.split(" ")) {
                if (s1FrequencyMap.get(word) == 1 && !s2FrequencyMap.containsKey(word)) {
                    result[i++] = word;
                }
            }
            for (String word: s2.split(" ")) {
                if (s2FrequencyMap.get(word) == 1 && !s1FrequencyMap.containsKey(word)) {
                    result[i++] = word;
                }
            }
        }
    }

    private int check(String sentence, Map<String, Integer> sentenceFrequencyMap, Map<String, Integer> otherSentenceFrequencyMap) {
        int count = 0;
        for (String word: sentence.split(" ")) {
            if (sentenceFrequencyMap.get(word) == 1 && !otherSentenceFrequencyMap.containsKey(word)) {
                if (isTest) {
                    System.out.println("uncommon: " + word);
                }
                count++;
            }
        }
        return count;
    }

    private void populate(String sentence, Map<String, Integer> frequencyMap) {
        for (String word: sentence.split(" ")) {
            frequencyMap.put(word, 1 + frequencyMap.getOrDefault(word, 0));
        }
    }
}
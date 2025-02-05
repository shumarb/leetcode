// Question: https://leetcode.com/problems/most-common-word/description/

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        boolean isTest = false;
        if (isTest) {
            System.out.println("paragraph: " + paragraph + ", banned: " + Arrays.toString(banned));
        }

        // 1. Replcae all non-letters and non-spaces with a space
        String cleanParagraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z ]", " ");

        // 2. Split words by any whitespace character (eg: tab, whitespace, new line, etc.)
        String[] words = cleanParagraph.split("\\s+");
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        if (isTest) {
            System.out.println("clean paragraph: " + cleanParagraph);
            System.out.println("clean paragraph words: " + Arrays.toString(words));
            System.out.println("bannedSet: " + bannedSet);
        }

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word: words) {
            if (!bannedSet.contains(word)) {
                wordsMap.put(word, 1 + wordsMap.getOrDefault(word, 0));
            }
        }
        if (isTest) {
            System.out.println("wordsMap: " + wordsMap);
        }

        int maximumCount = 0;
        String mostCommonWord = null;
        for (Map.Entry<String, Integer> entry: wordsMap.entrySet()) {
            if (entry.getValue() > maximumCount) {
                maximumCount = entry.getValue();
                mostCommonWord = entry.getKey();
            }
        }

        if (isTest) {
            System.out.println("most common word: " + mostCommonWord);
        }
        return mostCommonWord;
    }
}
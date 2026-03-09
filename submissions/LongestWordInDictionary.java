// Question: https://leetcode.com/problems/longest-word-in-dictionary/description/

class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        String result = "";
        boolean isTest = false;

        Arrays.sort(words);
        set.add("");
        if (isTest) {
            System.out.println("sorted words: " + Arrays.toString(words));
        }

        for (String word: words) {
            String prefix = word.substring(0, word.length() - 1);
            if (isTest) {
                System.out.println("-----------------------------------------");
                System.out.println("word: " + word + " -> prefix: " + prefix);
            }

            if (set.contains(prefix)) {
                set.add(word);
                if (isTest) {
                    System.out.println(" * valid: " + word + "\n ** before, result: " + result);
                }
                if (word.length() > result.length()) {
                    result = word;
                }
                if (isTest) {
                    System.out.println(" ** after, result: " + result);
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------");
            System.out.println("final result: " + result);
        }

        return result;
    }
}
// Question: https://leetcode.com/problems/longest-word-in-dictionary/description/

class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        String result = "";
        boolean isTest = false;

        for (String word: words) {
            set.add(word);
        }
        if (isTest) {
            System.out.println("set: " + set);
        }

        for (String word: words) {
            if (isTest) {
                System.out.println("-----------------------------------------");
                System.out.println("word: " + word);
            }
            boolean isAllPrefixesInSet = true;
            for (int i = 0; i < word.length() - 1; i++) {
                String prefix = word.substring(0, i + 1);
                if (isTest) {
                    System.out.println(" * prefix: " + prefix);
                }
                if (!set.contains(prefix)) {
                    isAllPrefixesInSet = false;
                    break;
                }
            }

            if (isAllPrefixesInSet) {
                System.out.println(" ** valid: " + word);
                if (result.isEmpty()) {
                    result = word;
                } else if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }
}
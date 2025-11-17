// Question: https://leetcode.com/problems/replace-words/description/

class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        if (isTest) {
            System.out.println("before, words: " + Arrays.toString(words));
        }
        Collections.sort(dictionary);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (String e: dictionary) {
                if (word.startsWith(e)) {
                    words[i] = e;
                    break;
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            result.append(words[i] + " ");
        }
        result.append(words[words.length - 1]);
        if (isTest) {
            System.out.println("after, words:  " + Arrays.toString(words));
        }

        return result.toString();
    }
}
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
            boolean isFound = false;

            for (String e: dictionary) {
                if (word.startsWith(e)) {
                    result.append(e);
                    isFound = true;
                    if (i != words.length - 1) {
                        result.append(" ");
                    }
                    break;
                }
            }
            if (!isFound) {
                result.append(word);
                if (i != words.length - 1) {
                    result.append(" ");
                }
            }
        }
        if (isTest) {
            System.out.println("after, words:  " + Arrays.toString(words) + "\nresult: " + result.toString());
        }

        return result.toString();
    }
}
// Question: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int n = words.length;

        for (int i = 0; i < n - 1; i++) {
            word = new StringBuilder(words[i]);
            result.append(word.reverse().toString()).append(" ");
        }
        word = new StringBuilder(words[n - 1]);
        result.append(word.reverse().toString());

        return result.toString();
    }
}

// Question: https://leetcode.com/problems/reverse-words-in-a-string/description/

class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String updatedString = s.trim();
        String[] words = updatedString.split("\\s+");
        boolean isTest = false;
        int left = 0;
        int n = words.length;
        int right = n - 1;

        if (isTest) {
            System.out.println("updatedString: " + updatedString + "\n-------------------------------------\nbefore, words: " + Arrays.toString(words));
        }

        while (left < right) {
            String temp = words[left];
            words[left++] = words[right];
            words[right--] = temp;
        }

        for (int i = 0; i < n - 1; i++) {
            result.append(words[i]).append(" ");
        }
        result.append(words[n - 1]);
        if (isTest) {
            System.out.println("after, words:  " + Arrays.toString(words) + "\n-------------------------------------\nresult: " + result.toString());
        }

        return result.toString();
    }
}

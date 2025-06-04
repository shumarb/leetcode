// Question: https://leetcode.com/problems/reverse-words-in-a-string/description/

class ReverseWordsInAString {
    public String reverseWords(String s) {
        boolean isTest = false;
        StringBuilder result = new StringBuilder();
        String updatedString = s.trim();
        String[] words = updatedString.split("\\s+");

        if (isTest) {
            System.out.println("s: " + s + "\nupdatedString: " + updatedString);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("words: ");
            for (int i = 0; i < words.length; i++) {
                System.out.println(" * word " + (i + 1) + ": " + words[i]);
            }
            System.out.println("-------------------------------------------------------------------");
        }

        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left++] = words[right];
            words[right--] = temp;
        }
        if (isTest) {
            System.out.println("updated words: ");
            for (int i = 0; i < words.length; i++) {
                System.out.println(" * word " + (i + 1) + ": " + words[i]);
            }
            System.out.println("-------------------------------------------------------------------");
        }

        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if (i != words.length - 1) {
                result.append(" ");
            }
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}
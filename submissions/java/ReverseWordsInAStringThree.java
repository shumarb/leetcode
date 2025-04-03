// Question: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

class ReverseWordsInAStringThree {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        if (isTest) {
            System.out.println("before, words: " + Arrays.toString(words));
        }
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
            result.append(words[i]);
            if (i < words.length - 1) {
                result.append(' ');
            }
        }

        if (isTest) {
            System.out.println("after, words: " + Arrays.toString(words));
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }

    private String reverse(String word) {
        char[] letters = word.toCharArray();
        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            char temp = letters[left];
            letters[left++] = letters[right];
            letters[right--] = temp;
        }

        return new String(letters);
    }
}
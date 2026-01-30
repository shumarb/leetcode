// Question: https://leetcode.com/problems/reverse-words-with-same-vowel-count/description/

class ReverseWordsWithSameVowelCount {
    public String reverseWords(String s) {
        String[] sTokens = s.split(" ");
        boolean isTest = false;
        int vowelCount = getVowelCount(sTokens[0]);

        if (isTest) {
            System.out.println("vowelCount: " + vowelCount + "\nbefore, sTokens: " + Arrays.toString(sTokens));
            System.out.println("-----------------------------------------------");
        }
        for (int i = 1; i < sTokens.length; i++) {
            String current = sTokens[i];
            if (getVowelCount(current) == vowelCount) {
                if (isTest) {
                    System.out.println(" * reverse: " + current);
                }
                sTokens[i] = reverse(current);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------");
            System.out.println("after, sTokens:  " + Arrays.toString(sTokens));
        }

        return String.join(" ", sTokens);
    }

    private String reverse(String current) {
        StringBuilder updated = new StringBuilder();
        char[] letters = current.toCharArray();
        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            char temp = letters[left];
            letters[left++] = letters[right];
            letters[right--] = temp;
        }
        for (char letter: letters) {
            updated.append(letter);
        }

        return updated.toString();
    }

    private int getVowelCount(String word) {
        int vowelCount = 0;

        for (char c: word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }

        return vowelCount;
    }
}
// Question: https://leetcode.com/problems/reverse-words-with-same-vowel-count/description/

class ReverseWordsWithSameVowelCount {
    public String reverseWords(String s) {
        String[] sTokens = s.split(" ");
        boolean isTest = false;
        int vowelCount = getVowelCount(sTokens[0].toCharArray());

        if (isTest) {
            System.out.println("vowelCount: " + vowelCount + "\nbefore, sTokens: " + Arrays.toString(sTokens));
        }
        for (int i = 1; i < sTokens.length; i++) {
            sTokens[i] = getCorrectWord(sTokens[i].toCharArray(), vowelCount);
        }
        if (isTest) {
            System.out.println("-----------------------------------------------");
            System.out.println("after, sTokens:  " + Arrays.toString(sTokens));
        }

        return String.join(" ", sTokens);
    }

    private String getCorrectWord(char[] letters, int vowelCount) {
        int count = getVowelCount(letters);
        int left = 0;
        int right = letters.length - 1;

        if (count == vowelCount) {
            while (left < right) {
                char temp = letters[left];
                letters[left++] = letters[right];
                letters[right--] = temp;
            }
        }

        return new String(letters);
    }

    private int getVowelCount(char[] letters) {
        int vowelCount = 0;

        for (char letter: letters) {
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                vowelCount++;
            }
        }

        return vowelCount;
    }
}
// Question: https://leetcode.com/problems/count-vowel-substrings-of-a-string/description/

class CountVowelSubstringsOfAString {
    public int countVowelSubstrings(String word) {
        if (word.length() < 5) {
            return 0;
        }

        boolean[] isVowel = new boolean[26];
        int n = word.length();
        int result = 0;

        isVowel['a' - 'a'] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;

        for (int i = 0; i < n; i++) {
            if (!isVowel(word.charAt(i))) {
                continue;
            }

            boolean[] isSeen = new boolean[26];
            int countSeen = 0;
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (!isVowel(c)) {
                    break;
                }

                if (!isSeen[c - 'a']) {
                    countSeen++;
                }
                isSeen[c - 'a'] = true;
                if (countSeen == 5) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
// Question: https://leetcode.com/problems/count-vowel-substrings-of-a-string/description/

class CountVowelSubstringsOfAString {
    public int countVowelSubstrings(String word) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int countVowelSubstrings = 0;
        int len = word.length();

        if (len < 5) {
            return countVowelSubstrings;
        }
        for (int i = 0; i < len; i++) {
            if (!isVowel(word.charAt(i))) {
                continue;
            }

            Set<Character> seen = new HashSet<>();
            for (int j = i; j < len; j++) {
                char c = word.charAt(j);
                if (!isVowel(c)) {
                    break;
                }
                seen.add(c);
                if (seen.size() == 5) {
                    countVowelSubstrings++;
                }
            }
        }

        return countVowelSubstrings;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
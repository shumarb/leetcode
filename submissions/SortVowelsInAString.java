// Question: https://leetcode.com/problems/sort-vowels-in-a-string/description/

class SortVowelsInAString {
    public String sortVowels(String s) {
        char[] letters = s.toCharArray();
        char[] vowels;
        int j = 0;
        int n = letters.length;
        int totalVowels = 0;

        for (char c: letters) {
            if (isVowel(c)) {
                totalVowels++;
            }
        }
        if (n == 1 || totalVowels <= 1) {
            return s;
        }

        vowels = getSortedVowels(letters, totalVowels);
        j = 0;

        for (int i = 0; i < n; i++) {
            if (isVowel(letters[i])) {
                letters[i] = vowels[j++];
            }
        }

        return new String(letters);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private char[] getSortedVowels(char[] letters, int totalVowels) {
        char[] result = new char[totalVowels];
        int[] count = new int[52];
        int j = 0;

        for (char c: letters) {
            if (!isVowel(c)) {
                continue;

            } else if (c >= 'a' && c <= 'z') {
                count[c - 'a' + 26]++;

            } else {
                count[c - 'A']++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                if (i < 26) {
                    result[j++] = (char) ('A' + i);
                } else {
                    result[j++] = (char) ('a' + i - 26);
                }
            }
        }

        return result;
    }
}

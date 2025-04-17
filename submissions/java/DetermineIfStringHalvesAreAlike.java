// Question: https://leetcode.com/problems/determine-if-string-halves-are-alike/description/

class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int sLength = s.length();
        return countVowels(s.substring(0, sLength / 2)) == countVowels(s.substring(sLength / 2, sLength));
    }

    private int countVowels(String str) {
        int countVowels = 0;
        for (char letter: str.toCharArray()) {
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'
                    || letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
                countVowels++;
            }
        }
        return countVowels;
    }
}
// Question: https://leetcode.com/problems/vowel-consonant-score/description/

class VowelConsonantScore {
    public int vowelConsonantScore(String s) {
        boolean isTest = false;
        int c = 0;
        int v = 0;

        for (char letter: s.toCharArray()) {
            if (Character.isLetter(letter)) {
                if (isVowel(letter)) {
                    v++;
                } else {
                    c++;
                }
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\n * c: " + c + "\n * v: " + v);
        }

        return c > 0 ? v / c : 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
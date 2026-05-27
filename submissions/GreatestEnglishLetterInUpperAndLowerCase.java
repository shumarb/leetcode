// Question: https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/description/

class GreatestEnglishLetterInUpperAndLowerCase {
    public String greatestLetter(String s) {
        for (char c = 'Z'; c >= 'A'; c--) {
            if (s.indexOf(c) >= 0 && s.indexOf(Character.toLowerCase(c)) >= 0) {
                return Character.toString(c);
            }
        }

        return "";
    }
}

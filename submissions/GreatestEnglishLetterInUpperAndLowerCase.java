// Question: https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/description/

class GreatestEnglishLetterInUpperAndLowerCase {
    public String greatestLetter(String s) {
        boolean isTest = false;
        boolean[] isLower = new boolean[26];
        boolean[] isUpper = new boolean[26];

        for (char c: s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                isLower[c - 'a'] = true;
            } else {
                isUpper[c - 'A'] = true;
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nisLower: " + Arrays.toString(isLower) + "\nisUpper: " + Arrays.toString(isUpper));
        }

        for (int i = 25; i >= 0; i--) {
            if (isLower[i] && isUpper[i]) {
                return Character.toString((char) ('A' + i));
            }
        }

        return "";
    }
}

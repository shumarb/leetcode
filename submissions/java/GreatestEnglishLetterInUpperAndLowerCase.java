// Question: https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/description/

class GreatestEnglishLetterInUpperAndLowerCase {
    public String greatestLetter(String s) {
        boolean isTest = false;
        boolean[] isLowerCaseLetterPresent = new boolean[26];
        boolean[] isUpperCaseLetterPresent = new boolean[26];

        for (char letter: s.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                isUpperCaseLetterPresent[letter - 'A'] = true;
            } else {
                isLowerCaseLetterPresent[letter - 'a'] = true;
            }
        }
        if (isTest) {
            System.out.println("s: " + s);
            System.out.println("isUpperCaseLetterPresent: " + Arrays.toString(isUpperCaseLetterPresent));
            System.out.println("isLowerCaseLetterPresent: " + Arrays.toString(isLowerCaseLetterPresent));
        }

        for (int i = 25; i >= 0; i--) {
            if (isLowerCaseLetterPresent[i] && isUpperCaseLetterPresent[i]) {
                return Character.toString('A' + i);
            }
        }

        return "";
    }
}
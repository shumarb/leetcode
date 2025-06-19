// Question: https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/

class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        // 1. Edge case: s length is < 3.
        if (s.length() < 3) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        char[] letters = s.toCharArray();

        for (int i = 0; i <= s.length() - 3; i++) {
            if (letters[i] == letters[i + 1] && letters[i] == letters[i + 2]) {
                letters[i] = 'X';
            }
        }
        for (char letter: letters) {
            if (letter != 'X') {
                result.append(letter);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nletters: " + Arrays.toString(letters));
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}
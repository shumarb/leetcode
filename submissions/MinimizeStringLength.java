// Question: https://leetcode.com/problems/minimize-string-length/description/

class MinimizeStringLength {
    public int minimizedStringLength(String s) {
        int countDistinctLetters = 0;
        boolean isTest = false;
        boolean[] isLetterPresent = new boolean[26];

        for (char letter: s.toCharArray()) {
            isLetterPresent[letter - 'a'] = true;
        }
        if (isTest) {
            System.out.println("s: " + s + "\nisLetterPresent: " + Arrays.toString(isLetterPresent));
        }
        for (boolean isPresent: isLetterPresent) {
            if (isPresent) {
                countDistinctLetters++;
            }
        }
        if (isTest) {
            System.out.println("number of distinct letters: " + countDistinctLetters);
        }

        return countDistinctLetters;
    }
}
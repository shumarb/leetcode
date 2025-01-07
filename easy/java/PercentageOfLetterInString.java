// Question: https://leetcode.com/problems/percentage-of-letter-in-string/description/

class PercentageOfLetterInString {
    public int percentageLetter(String s, char letter) {
        double count = 0;
        for (char x: s.toCharArray()) {
            if (x == letter) {
                count++;
            }
        }
        return (int) (100.0 * count / (double) s.length());
    }
}
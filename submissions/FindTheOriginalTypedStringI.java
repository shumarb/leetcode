// Question: https://leetcode.com/problems/find-the-original-typed-string-i/description/

class FindTheOriginalTypedStringI {
    public int possibleStringCount(String word) {
        char[] letters = word.toCharArray();
        int count = 1;
        int result = 1; // Word itself is one original typed string.

        for (int i = 1; i < letters.length; i++) {
            if (letters[i] == letters[i - 1]) {
                count++;
            } else {
                result += (count - 1);
                count = 1;
            }
        }
        result += (count - 1);

        return result;
    }
}

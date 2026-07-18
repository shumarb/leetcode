// Question: https://leetcode.com/problems/rearrange-string-to-avoid-character-pair/description/

class RearrangeStringToAvoidCharacterPair {
    public String rearrangeString(String s, char x, char y) {
        char[] letters = s.toCharArray();
        char[] result = new char[letters.length];
        int index = 0;

        for (char c: letters) {
            if (c == y) {
                result[index++] = y;
            }
        }
        for (char c: letters) {
            if (c == x) {
                result[index++] = x;
            }
        }
        for (char c: letters) {
            if (c != x && c != y) {
                result[index++] = c;
            }
        }

        return new String(result);
    }
}

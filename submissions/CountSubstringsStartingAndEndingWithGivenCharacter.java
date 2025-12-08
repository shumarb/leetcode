// Question: https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/description/

class CountSubstringsStartingAndEndingWithGivenCharacter {
    public long countSubstrings(String s, char c) {
        long count = 0;
        long result = 0;

        for (char x: s.toCharArray()) {
            if (x == c) {
                result += ++count;
            }
        }

        return result;
    }
}
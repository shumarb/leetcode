// Question: https://leetcode.com/problems/first-unique-character-in-a-string/description/

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] frequency = new int[26];

        for (char letter: s.toCharArray()) {
            frequency[letter - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
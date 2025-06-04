// Question: https://leetcode.com/problems/first-unique-character-in-a-string/description/

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] letterFrequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterFrequency[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (letterFrequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
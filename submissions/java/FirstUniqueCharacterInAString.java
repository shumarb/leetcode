// Question: https://leetcode.com/problems/first-unique-character-in-a-string/description/

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        boolean test = false;
        for (char letter: s.toCharArray()) {
            freq[letter - 'a']++;
        }
        if (test) {
            System.out.println("freq: " + Arrays.toString(freq));
        }
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (freq[letter - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
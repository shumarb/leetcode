// Question: https://leetcode.com/problems/valid-anagram/description/

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] frequency = new int[26];

        for (char letter: s.toCharArray()) {
            frequency[letter - 'a']++;
        }
        for (char letter: t.toCharArray()) {
            frequency[letter - 'a']--;
        }
        for (int freq: frequency) {
            if (freq != 0) {
                return false;
            }
        }

        return true;
    }
}
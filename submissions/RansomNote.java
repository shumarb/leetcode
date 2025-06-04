// Question: https://leetcode.com/problems/ransom-note/

class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] magazineFrequency = new int[26];
        int[] ransomNoteFrequency = new int[26];
        populate(magazine, magazineFrequency);
        populate(ransomNote, ransomNoteFrequency);

        for (int i = 0; i < 26; i++) {
            if (magazineFrequency[i] < ransomNoteFrequency[i]) {
                return false;
            }
        }
        return true;
    }

    private void populate(String str, int[] frequency) {
        for (char letter: str.toCharArray()) {
            frequency[letter - 'a']++;
        }
    }
}
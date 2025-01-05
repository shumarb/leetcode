// Question: https://leetcode.com/problems/ransom-note/

class RandomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        char[] rArr = formsFreqArr(ransomNote);
        char[] mArr = formsFreqArr(magazine);
        for (int i = 0; i < rArr.length; i++) {
            if (rArr[i] != 0 && mArr[i] < rArr[i]) {
                return false;
            }
        }
        return true;
    }

    private char[] formsFreqArr(String str) {
        char[] arr = new char[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        return arr;
    }

}

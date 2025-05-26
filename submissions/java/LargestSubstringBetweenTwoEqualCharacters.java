// Question: https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/

class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        boolean isTest = false;
        int[] letterFirstIndex = new int[26];
        int[] letterLastIndex = new int[26];
        int maxLengthBetweenEqualCharacters = -1;

        Arrays.fill(letterFirstIndex, -1);
        Arrays.fill(letterLastIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letterFirstIndex[letter - 'a'] == -1) {
                letterFirstIndex[letter - 'a'] = i;
            } else {
                letterLastIndex[letter - 'a'] = i;
            }
            int firstIndex = letterFirstIndex[letter - 'a'];
            int lastIndex = letterLastIndex[letter - 'a'];
            if (firstIndex != -1 && lastIndex != -1) {
                // 1. Reduce index difference by 1 as firstIndex and lastIndex are 1-based, and array indices are 0-based.
                maxLengthBetweenEqualCharacters = Math.max(maxLengthBetweenEqualCharacters, lastIndex - firstIndex - 1);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "maxLengthBetweenEqualCharacters: " + maxLengthBetweenEqualCharacters);
            System.out.println("letterFirstIndex: " + Arrays.toString(letterFirstIndex));
            System.out.println("letterLastIndex: " + Arrays.toString(letterLastIndex));
        }

        return maxLengthBetweenEqualCharacters;
    }
}
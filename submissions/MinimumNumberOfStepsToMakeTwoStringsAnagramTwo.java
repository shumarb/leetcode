// Question: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/description/

class Solution {
    public int minSteps(String s, String t) {
        boolean isTest = false;
        int[] sFrequency = getFrequency(s);
        int[] tFrequency = getFrequency(t);
        int minSteps = 0;

        for (int i = 0; i < 26; i++) {
            if (sFrequency[i] != tFrequency[i]) {
                minSteps += Math.abs(sFrequency[i] - tFrequency[i]);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nt: " + t);
            System.out.println("sFrequency: " + Arrays.toString(sFrequency));
            System.out.println("tFrequency: " + Arrays.toString(tFrequency));
            System.out.println("minSteps: " + minSteps);
        }

        return minSteps;
    }

    private int[] getFrequency(String s) {
        int[] frequency = new int[26];

        for (char letter: s.toCharArray()) {
            frequency[letter - 'a']++;
        }

        return frequency;
    }
}
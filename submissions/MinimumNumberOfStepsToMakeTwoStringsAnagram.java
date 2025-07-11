// Question: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/

class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        boolean isTest = false;
        int[] sFrequency = getFrequency(s);
        int[] tFrequency = getFrequency(t);
        int result = 0;

        for (int i = 0; i < 26; i++) {
            if (tFrequency[i] < sFrequency[i]) {
                result += (sFrequency[i] - tFrequency[i]);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nt: " + t);
            System.out.println("sFrequency: " + Arrays.toString(sFrequency));
            System.out.println("tFrequency: " + Arrays.toString(tFrequency));
            System.out.println("result: " + result);
        }

        return result;
    }

    private int[] getFrequency(String s) {
        int[] frequency = new int[26];

        for (char letter: s.toCharArray()) {
            frequency[letter - 'a']++;
        }

        return frequency;
    }
}
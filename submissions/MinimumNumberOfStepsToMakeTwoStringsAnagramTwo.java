// Question: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/description/

class MinimumNumberOfStepsToMakeTwoStringsAnagramTwo {
    public int minSteps(String s, String t) {
        boolean isTest = false;
        int minSteps = 0;
        int[] frequency = new int[26];

        for (char letter: s.toCharArray()) {
            frequency[letter - 'a']++;
        }
        for (char letter: t.toCharArray()) {
            frequency[letter - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            minSteps += Math.abs(frequency[i]);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nt: " + t);
            System.out.println("frequency: " + Arrays.toString(frequency) + "\nminSteps: " + minSteps);
        }

        return minSteps;
    }
}
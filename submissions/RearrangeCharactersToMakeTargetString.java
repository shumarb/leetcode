// Question: https://leetcode.com/problems/rearrange-characters-to-make-target-string/description/

class RearrangeCharactersToMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
        boolean isTest = false;
        int count = Integer.MAX_VALUE;
        int[] sFrequency = new int[26];
        int[] targetFrequency = new int[26];

        for (char letter: s.toCharArray()) {
            sFrequency[letter - 'a']++;
        }
        for (char letter: target.toCharArray()) {
            targetFrequency[letter - 'a']++;
        }
        if (isTest) {
            System.out.println("s: " + s + "\ntarget: " + target);
            System.out.println("sFrequency: " + Arrays.toString(sFrequency) + "\ntargetFrequency: " + Arrays.toString(targetFrequency));
            System.out.println("---------------------------------------------------------------------------");
        }

        for (char letter: target.toCharArray()) {
            // 1. Can't form target is sFrequency[letter] < targetFrequency[letter].
            if (sFrequency[letter - 'a'] < targetFrequency[letter - 'a']) {
                return 0;
            } else {
                count = Math.min(count, sFrequency[letter - 'a'] / targetFrequency[letter - 'a']);
            }
        }

        return count;
    }
}
// Question: https://leetcode.com/problems/subsequence-after-one-replacement/description/

class SubsequenceAfterOneReplacement {
    public boolean canMakeSubsequence(String s, String t) {
        boolean isTest = false;
        char[] sLetters = s.toCharArray();
        char[] tLetters = t.toCharArray();
        int n = sLetters.length;
        int noReplacement = 0; // longest prefix of s matched without replacing any letter.
        int oneReplacement = 0; // longest prefix of s matched after using at most one letter replacement.

        if (isTest) {
            System.out.println("sLetters: " + Arrays.toString(sLetters) + " | tLetters: " + Arrays.toString(tLetters));
            System.out.println("----------------------------------------------------");
        }

        for (int i = 0; i < tLetters.length; i++) {
            char letter = tLetters[i];
            if (isTest) {
                System.out.println("i: " + i + " letter: " + letter);
                System.out.println(" * before | noReplacement: " + noReplacement + " | oneReplacement: " + oneReplacement);
            }

            int previousNoReplacement = noReplacement;
            int previousOneReplacement = oneReplacement;

            if (previousNoReplacement < n && sLetters[previousNoReplacement] == letter) {
                noReplacement = previousNoReplacement + 1;
            }

            int nextOneReplacement = previousOneReplacement;
            if (previousOneReplacement < n && sLetters[previousOneReplacement] == letter) {
                nextOneReplacement = previousOneReplacement + 1;
            }

            if (previousNoReplacement < n) {
                nextOneReplacement = Math.max(nextOneReplacement, previousNoReplacement + 1);
            }

            oneReplacement = nextOneReplacement;
            if (isTest) {
                System.out.println(" * after | previousNoReplacement: " + previousNoReplacement + " | previousOneReplacement: " + previousOneReplacement);
                System.out.println("----------------------------------------------------");
            }
        }

        if (isTest) {
            System.out.println("final | noReplacement: " + noReplacement + " | oneReplacement: " + oneReplacement);
        }

        return noReplacement == n || oneReplacement == n;
    }
}

// Question: https://leetcode.com/problems/permutation-in-string/description/

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        boolean isTest = false;
        char[] letters1 = s1.toCharArray();
        char[] letters2 = s2.toCharArray();
        int[] s1Window = new int[26];
        int[] s2Window = new int[26];
        int k = letters1.length;
        int n = letters2.length;

        if (k > n) {
            return false;
        }

        s1Window = getWindow(letters1, 0, k - 1);
        s2Window = getWindow(letters2, 0, k - 1);
        if (isTest) {
            System.out.println("[0, " + (k - 1) + "]\n * s1Window: " + Arrays.toString(s1Window) + "\n * s2Window: " + Arrays.toString(s2Window));
        }
        if (containsPermutation(s2Window, s1Window)) {
            return true;
        }

        for (int i = k; i < n; i++) {
            char remove = letters2[i - k];
            char incoming = letters2[i];
            s2Window[remove - 'a']--;
            s2Window[incoming - 'a']++;
            if (isTest) {
                System.out.println("\n[" + (i - k + 1) + ", " + i + "]\nremove: " + remove + "\nincoming: " + incoming + "\n * s1Window: " + Arrays.toString(s1Window) + "\n * s2Window: " + Arrays.toString(s2Window));
            }
            if (containsPermutation(s2Window, s1Window)) {
                return true;
            }
        }

        return false;
    }

    private boolean containsPermutation(int[] window, int[] pattern) {
        for (int i = 0; i < window.length; i++) {
            if (pattern[i] == 0) {
                continue;
            }
            if (pattern[i] > window[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] getWindow(char[] letters, int start, int end) {
        int[] result = new int[26];

        for (int i = start; i <= end; i++) {
            result[letters[i] - 'a']++;
        }

        return result;
    }
}

// LeetCode: https://leetcode.com/problems/find-all-anagrams-in-a-string/

class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] pLetters = p.toCharArray();
        char[] sLetters = s.toCharArray();
        int[] pWindow;
        int[] sWindow;
        int k = pLetters.length;
        int n = sLetters.length;

        if (k > n) {
            return result;
        }

        pWindow = getWindow(pLetters, 0, k - 1);
        sWindow = getWindow(sLetters, 0, k - 1);
        if (containsPermutation(sWindow, pWindow)) {
            result.add(0);
        }

        for (int i = k; i < n; i++) {
            sWindow[sLetters[i - k] - 'a']--;
            sWindow[sLetters[i] - 'a']++;
            if (containsPermutation(sWindow, pWindow)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }

    private boolean containsPermutation(int[] sWindow, int[] pWindow) {
        for (int i = 0; i < sWindow.length; i++) {
            if (pWindow[i] > sWindow[i]) {
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

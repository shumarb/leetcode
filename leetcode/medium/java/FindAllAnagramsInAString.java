// LeetCode: https://leetcode.com/problems/find-all-anagrams-in-a-string/

class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<> ();

        // 1. p not anagram of s if it exceeds length of s
        int k = p.length();
        int sLen = s.length();
        if (k > sLen) {
            return ans;
        }

        char[] pFreq = new char[26];
        char[] sFreq = new char[26];
        // 2. Check if first k characters of s form p
        // If yes, both are anagrams, and add first index of s to ans
        for (int i = 0 ; i < k; i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }
        if (isEqual(pFreq, sFreq)) {
            ans.add(0);
        }

        // 3. Iterate s from index k to its last element
        // Form an anagram by removing first character of previous window
        // and add current element (last element) of current window
        // Compare if both are anagrams, and if yes, add first index of current window to ans
        for (int i = k; i < sLen; i++) {
            sFreq[s.charAt(i - k) - 'a']--;
            sFreq[s.charAt(i) - 'a']++;
            if (isEqual(sFreq, pFreq)) {
                ans.add(i - k + 1);
            }
        }

        return ans;
    }

    private static boolean isEqual(char[] arr1, char[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

}

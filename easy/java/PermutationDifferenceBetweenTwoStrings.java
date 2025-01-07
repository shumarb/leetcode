// Question: https://leetcode.com/problems/permutation-difference-between-two-strings/description/

class PermutationDifferenceBetweenTwoStrings {
    public int findPermutationDifference(String s, String t) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        boolean test = false;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i) - 'a'] = i;
        }
        if (test) {
            System.out.println("sVal: " + Arrays.toString(sFreq));
            System.out.println("tVal: " + Arrays.toString(tFreq));
        }
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(sFreq[i] - tFreq[i]);
        }
        return sum;
    }
}
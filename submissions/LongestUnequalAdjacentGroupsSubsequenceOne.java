// Question: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/

class LongestUnequalAdjacentGroupsSubsequenceOne {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int len = words.length;
        boolean isTest = false;
        boolean[] prefix = new boolean[len];

        prefix[0] = true;
        for (int i = 1; i < len; i++) {
            if (groups[i] != groups[i - 1]) {
                prefix[i] = true;
            } else {
                prefix[i] = false;
            }
        }
        for (int i = 0; i < len; i++) {
            if (prefix[i]) {
                result.add(words[i]);
            }
        }
        if (isTest) {
            System.out.println("words:  " + Arrays.toString(words));
            System.out.println("groups: " + Arrays.toString(groups));
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("result: " + result);
        }

        return result;
    }
}
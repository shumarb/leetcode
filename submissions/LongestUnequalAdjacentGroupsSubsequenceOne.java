// Question: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/

class LongestUnequalAdjacentGroupsSubsequenceOne {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        boolean isTest = false;
        int len = groups.length;

        result.add(words[0]);
        for (int i = 1; i < len; i++) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }
        if (isTest) {
            System.out.println("words:  " + Arrays.toString(words));
            System.out.println("groups: " + Arrays.toString(groups));
            System.out.println("result: " + result);
        }

        return result;
    }
}
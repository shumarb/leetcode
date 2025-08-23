// Question: https://leetcode.com/problems/longest-harmonious-subsequence/description/

class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int longest = 0;

        for (int number: nums) {
            map.put(number, 1 + map.getOrDefault(number, 0));
        }
        for (int number: nums) {
            int current = number;
            int next = current + 1;
            if (map.containsKey(next) && map.containsKey(current)) {
                if (isTest) {
                    System.out.println("current: " + current + " -> frequency: " + map.get(current));
                    System.out.println("next: " + next + " -> frequency: " + map.get(next));
                    System.out.println("before, longest: " + longest);
                }
                longest = Math.max(longest, map.get(next) + map.get(current));
                if (isTest) {
                    System.out.println("after, longest: " + longest);
                    System.out.println("-----------------------------------------------------");
                }
            }
        }
        if (isTest) {
            System.out.println("map: " + map);
        }

        return longest;
    }
}
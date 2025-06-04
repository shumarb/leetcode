// Question: https://leetcode.com/problems/find-subarrays-with-equal-sum/description/

class FindSubarraysWithEqualSum {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> subarraySums = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (subarraySums.contains(sum)) {
                return true;
            }
            subarraySums.add(sum);
        }
        return false;
    }
}
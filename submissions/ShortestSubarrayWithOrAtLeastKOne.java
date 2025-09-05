// Question: https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/description/

class ShortestSubarrayWithOrAtLeastKOne {
    public int minimumSubarrayLength(int[] nums, int k) {
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int bitwiseOr = 0;

            for (int j = i; j < nums.length; j++) {
                bitwiseOr |= nums[j];
                if (bitwiseOr >= k) {
                    shortest = Math.min(j - i + 1, shortest);
                    break;
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
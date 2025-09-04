// Question: https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/description/

class ShortestSubarrayWithOrAtLeastKOne {
    public int minimumSubarrayLength(int[] nums, int k) {
        boolean isTest = false;
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (isTest) {
                System.out.println("-------------------------------------------------");
            }
            for (int j = i; j < nums.length; j++) {
                int[] subarray = Arrays.copyOfRange(nums, i, j + 1);
                int bitwiseOr = 0;

                for (int number: subarray) {
                    bitwiseOr |= number;
                }
                if (bitwiseOr >= k) {
                    shortest = Math.min(j - i + 1, shortest);
                }
                if (isTest) {
                    System.out.println("subarray: " + Arrays.toString(subarray) + " -> bitwiseOr: " + bitwiseOr + " | shortest: " + shortest);
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
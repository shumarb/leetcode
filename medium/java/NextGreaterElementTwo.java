// Question: https://leetcode.com/problems/next-greater-element-ii/description/

class NextGreaterElementTwo {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);

        // 1. Stack containing indices of first greater element for each element in nums
        Stack<Integer> indicesStack = new Stack<>();

        for (int i = 0; i < 2 * len; i++) {
            while (!indicesStack.isEmpty() && nums[indicesStack.peek()] < nums[i % len]) {
                ans[indicesStack.pop()] = nums[i % len];
            }

            // 2. Ensure index < nums's length to ensure indices of array are added to stack
            // to prevent array out of bounds
            if (i < len) {
                indicesStack.push(i);
            }
        }

        return ans;
    }
}
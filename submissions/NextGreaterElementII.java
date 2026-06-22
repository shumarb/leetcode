// Question: https://leetcode.com/problems/next-greater-element-ii/description/

class NextGreaterElementTwo {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        boolean isTest = false;
        int[] result = new int[len];
        Arrays.fill(result, -1);

        // Stack contains indices of next greater element for an element during iteration
        Stack<Integer> stack = new Stack<>();

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
        }

        for (int i = 0; i < len; i++) {
            if (isTest) {
                System.out.println("checking | element: " + nums[i] + ", index: " + i);
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < len; i++) {
            if (isTest) {
                System.out.println("checking | element: " + nums[i] + ", index: " + i);
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
        }

        return result;
    }
}